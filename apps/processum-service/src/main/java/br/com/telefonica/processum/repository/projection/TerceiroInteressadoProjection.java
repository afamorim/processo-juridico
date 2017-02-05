package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.TerceiroInteressado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = TerceiroInteressado.class)
public interface TerceiroInteressadoProjection {
    
    @Value("#{target.terceiroInteressadoPK.codEmpresa}")
    String getCodEmpresa();
    
    @Value("#{target.terceiroInteressadoPK.numProcesso}")
    String getNumProcesso();
    
    @Value("#{target.terceiroInteressadoPK.codParteProcesso}")
    String getCodParteProcesso();

    @Value("#{target.parteProcesso.nomParteProcesso}")
    String getNomParteProcesso();
    
    @Value("#{target.parteProcesso.numCpfCnpj}")
    String getNumCpfCnpj();
    
}
