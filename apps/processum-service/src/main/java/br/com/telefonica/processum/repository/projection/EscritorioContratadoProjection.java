package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.EscritorioContratado;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = EscritorioContratado.class)
public interface EscritorioContratadoProjection {
    
    String getSigEscritorioContratado();

    String getNomEscritorioContratado();
    
}
