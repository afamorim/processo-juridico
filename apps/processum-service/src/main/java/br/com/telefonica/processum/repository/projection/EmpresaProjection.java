package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Empresa;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Empresa.class)
public interface EmpresaProjection {
    
    String getCodEmpresa();

    String getNomEmpresa();
    
}
