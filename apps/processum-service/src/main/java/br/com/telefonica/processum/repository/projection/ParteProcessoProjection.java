package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.ParteProcesso;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = ParteProcesso.class)
public interface ParteProcessoProjection {
    
    String getCodParteProcesso();

    String getNomParteProcesso();
    
    String getNumCpfCnpj();
    
}
