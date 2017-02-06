package br.com.telefonica.processum.handler;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.http.request.DadosRequisicao;
import br.com.telefonica.processum.http.response.DadosResposta;
import br.com.telefonica.processum.http.response.Pessoa;
import br.com.telefonica.processum.model.PocOcorrencia;
import br.com.telefonica.processum.service.IntegracaoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author ifbomfim
 */
@Component
@RepositoryEventHandler(PocOcorrencia.class)
public class PocOcorrenciaEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocOcorrenciaEventHandler.class);

    //2016-09-17
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private IntegracaoService integracaoService;

    @HandleBeforeCreate
    public void handlePocOcorrenciaSave(PocOcorrencia p) {

        if (StringUtils.isNotBlank(p.getNumLinha())) {
            DadosRequisicao requisicao = DadosRequisicao
                    .builder()
                    .filtro(p.getNumLinha())
                    .tipoFiltro("LINHA")
                    .build();
            try {
                DadosResposta dados = integracaoService.integrar(requisicao);
                if (dados != null && !dados.getPessoas().isEmpty()) {
                    Pessoa pessoa = dados.getPessoas().get(0);

                    p.setNomCliente(pessoa.getNomeCliente());
                    if (!pessoa.getAssinaturas().isEmpty()) {
                        p.setNomTipoAssinatura(pessoa.getAssinaturas().get(0).getTipoAssinatura());
                        p.setStsAssinatura(pessoa.getAssinaturas().get(0).getStatusAssinatura());

                        if (!pessoa.getContas().isEmpty()) {
                            p.setNomConta(pessoa.getContas().get(0).getNomeConta());
                            p.setDtcCadastro(formatter.parse(pessoa.getContas().get(0).getDataInicialCiclo()));
                            p.setNomTipoConta(pessoa.getContas().get(0).getTipoConta());
                            
                            if(!pessoa.getContas().get(0).getFaturas().isEmpty()){
                                p.setValSaldo(pessoa.getContas().get(0).getFaturas().get(0).getSaldo());
                            }
                            
                            if(!pessoa.getContas().get(0).getPagamentos().isEmpty()){
                                p.setNomFormaPagamento(pessoa.getContas().get(0).getPagamentos().get(0).getFormaPagamento());
                            }
                        }
                    }
                    
                    if(!dados.getErros().isEmpty()){
                        p.setStsErro("1");
                        StringBuilder erros = new StringBuilder();
                        dados.getErros().forEach((erro) -> {
                            erros.append(erro).append("|");
                        });
                        p.setDesErro(erros.toString());
                    }
                }
                
                LOGGER.debug(p.toString());
                
            } catch (ServicoException | ParseException ex) {
                LOGGER.error("ERRO AO OBTER DADOS DAS API'S", ex);
            }
        }

    }
}
