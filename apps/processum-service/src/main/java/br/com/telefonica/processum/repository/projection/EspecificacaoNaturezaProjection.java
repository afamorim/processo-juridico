package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.EspecificacaoNatureza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = EspecificacaoNatureza.class)
public interface EspecificacaoNaturezaProjection {
    
    @Value("#{target.especificacaoNaturezaPK.codEspecificacaoNatureza.toString()}")
    String getCodEspecificacaoNatureza();
    
    @Value("#{target.especificacaoNaturezaPK.codNatureza.toString()}")
    String getCodNatureza();
    
    String getDesEspecificacaoNatureza();
    
}
