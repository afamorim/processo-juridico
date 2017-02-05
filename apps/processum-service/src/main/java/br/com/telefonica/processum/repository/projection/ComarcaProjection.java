package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Comarca;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Comarca.class)
public interface ComarcaProjection {
    
    String getCodComarca();
    
    @Value("#{target.municipio.municipioPK.sigMunicipio}")
    String getSigMunicipio();
    
    @Value("#{target.municipio.municipioPK.sigEstado}")
    String getSigEstado();
    
    String getNomComarca();
    
}
