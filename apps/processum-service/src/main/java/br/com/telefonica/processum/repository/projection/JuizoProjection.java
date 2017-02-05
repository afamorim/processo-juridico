package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Juizo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Juizo.class)
public interface JuizoProjection {
    
    @Value("#{target.juizoPK.codComarca}")
    String getCodComarca();
    
    @Value("#{target.juizoPK.codJuizo}")
    String getCodJuizo();
    
    String getNomJuizo();
    
}
