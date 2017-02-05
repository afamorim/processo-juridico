package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Natureza;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author ifbomfim
 */
@Projection(name = "projecao", types = Natureza.class)
public interface NaturezaProjection {
    
    String getCodNatureza();
    String getDesNatureza();
    String getStsVisualizaRelatorio();
    
}
