package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.PocOcorrencia;
import org.springframework.data.rest.core.config.Projection;


/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = PocOcorrencia.class)
public interface PocOcorrenciaProjection {
    
    String getIdPocOcorrencia();
    
    String getStsPocOcorrencia();
    
    String getDtcPocOcorrencia();
    
    String getNumProcesso();
    
    String getNumCpfCnpj();
    
    String getNumLinha();
    
    String getDtcInicioPequisa();
    
    String getDtcFimPesquisa();
    
    String getNomCliente();
    
    String getNomConta();

    String getDtcCadastro();
    
    String getNomTipoConta();
    
    String getNomTipoAssinatura();
    
    String getStsAssinatura();
    
    String getDesEnderecoCorrespondencia();
    
    String getDesEnderecoTributacao();
    
    String getValSaldo();
    
    String getNomFormaPagamento();
    
}
