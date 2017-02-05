package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Reu;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Reu.class)
public interface ReuProjection {
    
    @Value("#{target.reuPK.codEmpresa}")
    String getCodEmpresa();
    
    @Value("#{target.reuPK.numProcesso}")
    String getNumProcesso();
    
    @Value("#{target.reuPK.codParteProcesso}")
    String getCodParteProcesso();

    @Value("#{target.parteProcesso.nomParteProcesso}")
    String getNomParteProcesso();
    
    @Value("#{target.parteProcesso.numCpfCnpj}")
    String getNumCpfCnpj();
    
}
