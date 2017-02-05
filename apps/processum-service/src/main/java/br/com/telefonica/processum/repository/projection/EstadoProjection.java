package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Estado;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Estado.class)
public interface EstadoProjection {
    
    String getSigEstado();

    String getNomEstado();
    
}
