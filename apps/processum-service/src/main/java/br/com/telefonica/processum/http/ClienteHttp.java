package br.com.telefonica.processum.http;

import br.com.telefonica.processum.http.request.DadosRequisicao;
import br.com.telefonica.processum.http.response.Assinatura;
import br.com.telefonica.processum.http.response.Conta;
import br.com.telefonica.processum.http.response.DadosResposta;
import br.com.telefonica.processum.http.response.Fatura;
import br.com.telefonica.processum.http.response.Pagamento;
import br.com.telefonica.processum.http.response.Pessoa;
import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Ivan Queiroz <ifbomfim@indracompany.com>
 */
@Data
@Builder
@ToString
public class ClienteHttp {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteHttp.class);

    private String url;
    private String soapEnvelope;
    private String soapResponse;
    private int responseCode = 0;
    public static final MediaType MEDIA_TYPE_XML = MediaType.parse("text/xml; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(new LogClienteHttpInterceptor())
            .build();

    public void executarChamada() {

        Request request = new Request.Builder()
                .url(url)
                .addHeader("SOAPAction", url)
                .post(RequestBody.create(MEDIA_TYPE_XML, soapEnvelope))
                .build();

        try {
            Response response = client.newCall(request).execute();
            setSoapResponse(response.body().string());
            setResponseCode(response.code());
        } catch (IOException ex) {
            LOGGER.error("Erro no cliente HTTP: ", ex);
        }

    }

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

        DadosRequisicao request = DadosRequisicao.builder()
                .tipoFiltro("LINHA")
                .filtro("44991010018")
                .build();

        ClienteHttp cliente = ClienteHttp.builder()
                .url("http://10.129.165.27/Pessoa")
                .soapEnvelope(request.getBuscaListaPessoasRequest())
                .build();
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
            System.out.println("PESSOAS - " + dadosPessoa);

            for (XML pessoa : dadosPessoa.nodes("//pes:pessoas/*")) {

                Pessoa pessoaVO = new Pessoa();
                pessoaVO.setNomeCliente(pessoa.xpath("//ns8:nomeCompleto/text()").isEmpty() ? "" : pessoa.xpath("//ns8:nomeCompleto/text()").get(0));

                List<Assinatura> assinaturas = new ArrayList<>();
                for (XML assinatura : dadosPessoa.nodes("//ns8:assinaturas/*")) {
                    Assinatura assinaturaVO = new Assinatura();
                    assinaturaVO.setStatusAssinatura(assinatura.xpath("//ass:statusAssinatura/ass:descricao/text()").isEmpty() ? "" : assinatura.xpath("//ass:statusAssinatura/ass:descricao/text()").get(0));
                    assinaturaVO.setTipoAssinatura(assinatura.xpath("//ass:tipoAssinatura/ass:descricao/text()").isEmpty() ? "" : assinatura.xpath("//ass:tipoAssinatura/ass:descricao/text()").get(0));
                    assinaturas.add(assinaturaVO);
                }
                pessoaVO.setAssinaturas(assinaturas);

                List<Conta> contas = new ArrayList<>();
                for (XML conta : dadosPessoa.nodes("//ns8:contas/*")) {
                    Conta contaVO = new Conta();
                    final String codigoConta = conta.xpath("//con:codigo/text()").isEmpty() ? "" : conta.xpath("//con:codigo/text()").get(0);
                    contaVO.setCodigo(codigoConta);
                    String codigoContaSistemaOrigem = conta.xpath("//con:codigoContaSistemOrigem/text()").isEmpty() ? "" : conta.xpath("//con:codigoContaSistemOrigem/text()").get(0);
                    contaVO.setCodigoContaSistemOrigem(codigoContaSistemaOrigem);

                    cliente.setUrl("http://10.129.165.27/Conta");
                    request.setCodigoConta(codigoConta);

                    cliente.setSoapEnvelope(request.getBuscaContaRequest());
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

                        System.out.println(dadosConta);

                        contaVO.setDataInicialCiclo(dadosConta.xpath("//con:dataInicialCiclo/text()").isEmpty() ? "" : dadosConta.xpath("//con:dataInicialCiclo/text()").get(0));
                        contaVO.setNomeConta(dadosConta.xpath("//con:tipoConta/con:descricao/text()").isEmpty() ? "" : dadosConta.xpath("//con:tipoConta/con:descricao/text()").get(0));
                        String siglaSistema = dadosConta.xpath("//con:sistemaOrigem/cat:nome/text()").isEmpty() ? "" : dadosConta.xpath("//con:sistemaOrigem/cat:nome/text()").get(0);
                        if (("ATY".equalsIgnoreCase(siglaSistema)) || ("CSO".equalsIgnoreCase(siglaSistema))) {
                            contaVO.setTipoConta("PÓS");
                        } else {
                            contaVO.setTipoConta("PRÉ");
                        }
                    } else {
                        dadosResposta.getErros().add("Erro ao obter dados de conta (buscarConta): RESPOSTA { " + cliente.getSoapResponse() + "}");
                    }

                    //Busca buscarListaUltimasFaturas
                    System.out.println("codigoConta: " + codigoContaSistemaOrigem);
                    request.setCodigoConta(codigoContaSistemaOrigem);
                    cliente.setSoapEnvelope(request.getBuscaListaUltimasFaturasRequest());
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
                            faturaVO.setSaldo(fatura.xpath("//ns1:valorAPagarFatura/text()").isEmpty() ? "" : fatura.xpath("//ns1:valorAPagarFatura/text()").get(0));
                            faturas.add(faturaVO);
                        }
                        contaVO.setFaturas(faturas);
                    } else {
                        dadosResposta.getErros().add("Erro ao obter dados de conta (buscarListaUltimasFaturas): RESPOSTA { " + cliente.getSoapResponse() + "}");
                    }

                    cliente.setSoapEnvelope(request.getBuscaPagamentosRequest());
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
                            pagamentoVO.setFormaPagamento(pagamento.xpath("//ns0:formaPagamento/cat:nome/text()").isEmpty() ? "" : pagamento.xpath("//ns0:formaPagamento/cat:nome/text()").get(0));
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

        System.out.println(dadosResposta);
    }
}
