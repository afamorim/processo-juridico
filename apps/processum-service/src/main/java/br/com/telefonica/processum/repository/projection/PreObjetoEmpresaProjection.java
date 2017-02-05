package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.PreObjetoEmpresa;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = PreObjetoEmpresa.class)
public interface PreObjetoEmpresaProjection {
    
    String getCodPreObjetoEmpresa();

    String getNomPreObjetoEmpresa();
    
}
