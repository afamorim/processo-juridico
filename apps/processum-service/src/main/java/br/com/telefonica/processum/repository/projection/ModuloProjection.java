package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.Modulo;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author ifbomfim
 */
@Projection(name = "projecao", types = Modulo.class)
public interface ModuloProjection {

    String getCodModulo();

    String getNomModulo();
}
