package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.DivisaoProcesso;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = DivisaoProcesso.class)
public interface DivisaoProcessoProjection {
    
    String getCodDivisaoProcesso();

    String getNomDivisao();

    String getSigDivisao();
    
}
