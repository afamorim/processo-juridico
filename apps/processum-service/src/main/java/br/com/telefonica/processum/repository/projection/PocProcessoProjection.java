package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.PocProcesso;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = PocProcesso.class)
public interface PocProcessoProjection {

    String getCodEspecificacaoNatureza();

    String getDesEspecificacaoNatureza();

    String getCodDetalheEspecificNatureza();

    String getNomDetalheEspecificNatureza();

    String getCodPreObjetoEmpresa();

    String getNomPreObjetoEmpresa();

    String getDtcProtocoloAforamento();

    String getStsPassouCallCenter();

    String getStsConsumerista();

    String getStsPassouProcon();

    String getNomTipoAcaoProcesso();

    String getCodDivisaoProcesso();

    String getDtcEnvioEscContratado();

    String getCodTipoAcaoProcesso();

    String getSigEscritorioContratado();

    String getNomEscritorioContratado();

    String getSigCorresponsavel();

    String getNomCorresponsavel();

    String getNomPoloPassivo();

    String getNomTerceiroInteressado();

    String getIdPocProcesso();

    String getCodEmpresa();

    String getNomEmpresa();

    String getCodNatureza();

    String getDesNatureza();

    String getDtcCitacao();

    String getStsRelevante();

    String getNomDivisao();

    String getNumProcesso();

    String getCodTipoAcao();

    String getDesTipoAcao();

    String getSigEstado();

    String getNomEstado();

    String getSigMunicipio();

    String getNomMunicipio();

    String getCodComarca();

    String getNomComarca();

    String getCodJuizo();

    String getNomJuizo();

    String getSigAdvogado();

    String getNomAdvogado();

    String getNomPoloAtivo();
    
    String getStsValidadoUsuario();

}
