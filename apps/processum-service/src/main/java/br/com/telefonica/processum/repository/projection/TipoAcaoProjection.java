package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.TipoAcao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = TipoAcao.class)
public interface TipoAcaoProjection {
    
    @Value("#{target.tipoAcaoPK.codTipoAcao.toString()}")
    String getCodTipoAcao();
    
    @Value("#{target.tipoAcaoPK.codPreObjetoEmpresa.toString()}")
    String getCodPreObjetoEmpresa();

    String getDesTipoAcao();
    
}
