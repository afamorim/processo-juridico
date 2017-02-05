package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.DivisaoProcesso;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = DivisaoProcesso.class)
public interface DivisaoProcessoProjection {
    
    String codDivisaoProcesso();

    String getNomDivisao();

    String getSigDivisao();
    
}
