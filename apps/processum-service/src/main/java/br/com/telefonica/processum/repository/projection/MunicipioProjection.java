package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Municipio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = Municipio.class)
public interface MunicipioProjection {
    
    @Value("#{target.municipioPK.sigMunicipio}")
    String getSigMunicipio();
    
    @Value("#{target.municipioPK.sigEstado}")
    String getSigEstado();

    String getNomMunicipio();
    
}
