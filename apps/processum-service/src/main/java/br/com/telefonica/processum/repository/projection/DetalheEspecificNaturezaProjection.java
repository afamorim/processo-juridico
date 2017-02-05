package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.DetalheEspecificNatureza;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = DetalheEspecificNatureza.class)
public interface DetalheEspecificNaturezaProjection {
    
    @Value("#{target.detalheEspecificNaturezaPK.codNatureza.toString()}")
    String getCodNatureza();
    
    @Value("#{target.detalheEspecificNaturezaPK.codEspecificacaoNatureza.toString()}")
    String getCodEspecificacaoNatureza();
    
    @Value("#{target.detalheEspecificNaturezaPK.codDetalheEspecificNatureza.toString()}")
    String getCodDetalheEspecificNatureza();
    
    @Value("#{target.especificacaoNatureza.desEspecificacaoNatureza}")
    String getDesEspecificacaoNatureza();
    
    String getNomDetalheEspecificNatureza();
    
}
