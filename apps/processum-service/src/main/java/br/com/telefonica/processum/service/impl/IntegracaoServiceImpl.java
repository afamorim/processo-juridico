package br.com.telefonica.processum.service.impl;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.http.ClienteHttp;
import br.com.telefonica.processum.http.request.DadosRequisicao;
import br.com.telefonica.processum.http.response.Assinatura;
import br.com.telefonica.processum.http.response.Conta;
import br.com.telefonica.processum.http.response.DadosResposta;
import br.com.telefonica.processum.http.response.Fatura;
import br.com.telefonica.processum.http.response.Pagamento;
import br.com.telefonica.processum.http.response.Pessoa;
import br.com.telefonica.processum.service.IntegracaoService;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IntegracaoServiceImpl implements IntegracaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegracaoServiceImpl.class);

    @Override
    public DadosResposta integrar(DadosRequisicao dadosRequisicao) throws ServicoException {
        LOGGER.debug("IntegracaoServiceImpl.integrar(): Início");

        ClienteHttp cliente = ClienteHttp.builder()
                .url("http://10.129.165.27/Pessoa")
                .soapEnvelope(dadosRequisicao.getBuscaListaPessoasRequest())
                .build();
        LOGGER.debug(cliente.toString());
        cliente.executarChamada();

        DadosResposta dadosResposta = new DadosResposta();

        if (cliente.getResponseCode() == 200) {

            String respostaBuscaPessoa = cliente.getSoapResponse();

            XML dadosPessoa = new XMLDocument(respostaBuscaPessoa)
                    .registerNs("soapenv", "http://schemas.xmlsoap.org/soap/envelope/")
                    .registerNs("ger", "http://www.vivo.com.br/MC/Geral")
                    .registerNs("pes", "http://www.vivo.com.br/SN/Pessoa")
                    .registerNs("sig", "http://www.vivo.com.br/MC/Sigan")
                    .registerNs("cat", "http://www.vivo.com.br/MC/Catalogo")
                    .registerNs("ns8", "http://www.vivo.com.br/MC/Pessoa")
                    .registerNs("con", "http://www.vivo.com.br/MC/Conta")
                    .registerNs("ass", "http://www.vivo.com.br/MC/Assinatura");
            List<Pessoa> pessoas = new ArrayList<>();

            for (XML pessoa : dadosPessoa.nodes("//pes:pessoas/*")) {

                Pessoa pessoaVO = new Pessoa();
                pessoaVO.setNomeCliente(pessoa.xpath("//ns8:nomeCompleto/text()").get(0));

                List<Assinatura> assinaturas = new ArrayList<>();
                for (XML assinatura : dadosPessoa.nodes("//ns8:assinaturas/*")) {
                    Assinatura assinaturaVO = new Assinatura();
                    assinaturaVO.setStatusAssinatura(assinatura.xpath("//ass:statusAssinatura/ass:descricao/text()").get(0));
                    assinaturaVO.setTipoAssinatura(assinatura.xpath("//ass:tipoAssinatura/ass:descricao/text()").get(0));
                    assinaturas.add(assinaturaVO);
                }
                pessoaVO.setAssinaturas(assinaturas);

                List<Conta> contas = new ArrayList<>();
                for (XML conta : dadosPessoa.nodes("//ns8:contas/*")) {
                    Conta contaVO = new Conta();
                    final String codigoConta = conta.xpath("//con:codigo/text()").get(0);
                    contaVO.setCodigo(codigoConta);
                    String codigoContaSistemaOrigem = conta.xpath("//con:codigoContaSistemOrigem/text()").get(0);
                    contaVO.setCodigoContaSistemOrigem(codigoContaSistemaOrigem);

                    cliente.setUrl("http://10.129.165.27/Conta");
                    dadosRequisicao.setCodigoConta(codigoConta);

                    cliente.setSoapEnvelope(dadosRequisicao.getBuscaContaRequest());
                    cliente.executarChamada();

                    //Busca buscarConta
                    if (cliente.getResponseCode() == 200) {

                        String respostaBuscaConta = cliente.getSoapResponse();
                        XML dadosConta = new XMLDocument(respostaBuscaConta)
                                .registerNs("soapenv", "http://schemas.xmlsoap.org/soap/envelope/")
                                .registerNs("ger", "http://www.vivo.com.br/MC/Geral")
                                .registerNs("pes", "http://www.vivo.com.br/SN/Pessoa")
                                .registerNs("sig", "http://www.vivo.com.br/MC/Sigan")
                                .registerNs("cat", "http://www.vivo.com.br/MC/Catalogo")
                                .registerNs("ns8", "http://www.vivo.com.br/MC/Pessoa")
                                .registerNs("con", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ass", "http://www.vivo.com.br/MC/Assinatura");

                        contaVO.setDataInicialCiclo(dadosConta.xpath("//con:dataInicialCiclo/text()").get(0));
                        contaVO.setNomeConta(dadosConta.xpath("//con:tipoConta/con:descricao/text()").get(0));
                        String siglaSistema = dadosConta.xpath("//con:sistemaOrigem/cat:nome/text()").get(0);
                        if (("Atlys".equalsIgnoreCase(siglaSistema)) || ("CSO".equalsIgnoreCase(siglaSistema))) {
                            contaVO.setTipoConta("PÓS");
                        } else {
                            contaVO.setTipoConta("PRÉ");
                        }
                    } else {
                        dadosResposta.getErros().add("Erro ao obter dados de conta (buscarConta): RESPOSTA { " + cliente.getSoapResponse() + "}");
                    }

                    //Busca buscarListaUltimasFaturas
                    dadosRequisicao.setCodigoConta(codigoContaSistemaOrigem);
                    cliente.setSoapEnvelope(dadosRequisicao.getBuscaListaUltimasFaturasRequest());
                    cliente.executarChamada();

                    if (cliente.getResponseCode() == 200) {

                        String respostaBuscaFaturas = cliente.getSoapResponse();
                        XML dadosFaturas = new XMLDocument(respostaBuscaFaturas)
                                .registerNs("soapenv", "http://schemas.xmlsoap.org/soap/envelope/")
                                .registerNs("ger", "http://www.vivo.com.br/MC/Geral")
                                .registerNs("pes", "http://www.vivo.com.br/SN/Pessoa")
                                .registerNs("sig", "http://www.vivo.com.br/MC/Sigan")
                                .registerNs("cat", "http://www.vivo.com.br/MC/Catalogo")
                                .registerNs("ns8", "http://www.vivo.com.br/MC/Pessoa")
                                .registerNs("con", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ns1", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ass", "http://www.vivo.com.br/MC/Assinatura");

                        List<Fatura> faturas = new ArrayList<>();
                        for (XML fatura : dadosFaturas.nodes("//ns1:Faturas/*")) {
                            Fatura faturaVO = new Fatura();
                            faturaVO.setSaldo(fatura.xpath("//ns1:valorAPagarFatura/text()").get(0));
                            faturas.add(faturaVO);
                        }
                        contaVO.setFaturas(faturas);
                    } else {
                        dadosResposta.getErros().add("Erro ao obter dados de conta (buscarListaUltimasFaturas): RESPOSTA { " + cliente.getSoapResponse() + "}");
                    }

                    cliente.setSoapEnvelope(dadosRequisicao.getBuscaPagamentosRequest());
                    cliente.executarChamada();

                    if (cliente.getResponseCode() == 200) {
                        String respostaBuscaPagamentos = cliente.getSoapResponse();
                        XML dadosPagamentos = new XMLDocument(respostaBuscaPagamentos)
                                .registerNs("soapenv", "http://schemas.xmlsoap.org/soap/envelope/")
                                .registerNs("ger", "http://www.vivo.com.br/MC/Geral")
                                .registerNs("pes", "http://www.vivo.com.br/SN/Pessoa")
                                .registerNs("sig", "http://www.vivo.com.br/MC/Sigan")
                                .registerNs("cat", "http://www.vivo.com.br/MC/Catalogo")
                                .registerNs("ns8", "http://www.vivo.com.br/MC/Pessoa")
                                .registerNs("con", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ns1", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ns0", "http://www.vivo.com.br/MC/Conta")
                                .registerNs("ass", "http://www.vivo.com.br/MC/Assinatura");

                        List<Pagamento> pagamentos = new ArrayList<>();
                        for (XML pagamento : dadosPagamentos.nodes("//ns0:Pagamentos/*")) {
                            Pagamento pagamentoVO = new Pagamento();
                            pagamentoVO.setFormaPagamento(pagamento.xpath("//ns0:formaPagamento/cat:nome/text()").get(0));
                            pagamentos.add(pagamentoVO);
                        }
                        contaVO.setPagamentos(pagamentos);
                    } else {
                        dadosResposta.getErros().add("Erro ao obter dados de conta (buscarPagamentosConta): RESPOSTA { " + cliente.getSoapResponse() + "}");
                    }

                    contas.add(contaVO);
                }

                pessoaVO.setContas(contas);
                pessoas.add(pessoaVO);
            }
            dadosResposta.setPessoas(pessoas);
        } else {
            dadosResposta.getErros().add("Erro ao obter dados de cliente (buscarListaPessoas): RESPOSTA { " + cliente.getSoapResponse() + "}");
        }

        LOGGER.info(dadosResposta.toString());

        return dadosResposta;
    }

}
