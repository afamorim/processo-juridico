package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Autor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Autor.class)
public interface AutorProjection {
    
    @Value("#{target.autorPK.codEmpresa}")
    String getCodEmpresa();
    
    @Value("#{target.autorPK.numProcesso}")
    String getNumProcesso();
    
    @Value("#{target.autorPK.codParteProcesso}")
    String getCodParteProcesso();

    @Value("#{target.parteProcesso.nomParteProcesso}")
    String getNomParteProcesso();
    
    @Value("#{target.parteProcesso.numCpfCnpj}")
    String getNumCpfCnpj();
    
}
