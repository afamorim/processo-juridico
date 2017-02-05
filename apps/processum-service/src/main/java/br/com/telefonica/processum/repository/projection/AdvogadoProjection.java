package br.com.telefonica.processum.repository.projection;

import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = AdvogadoProjection.class)
public interface AdvogadoProjection {
    
    String getSigAdvogado();

    String getNomAdvogado();
    
}
