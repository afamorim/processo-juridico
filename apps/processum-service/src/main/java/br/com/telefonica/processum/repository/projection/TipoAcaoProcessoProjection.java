package br.com.telefonica.processum.repository.projection;

import br.com.telefonica.processum.model.TipoAcaoProcesso;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author jadossantos
 */
@Projection(name = "projecao", types = TipoAcaoProcesso.class)
public interface TipoAcaoProcessoProjection {
    
    String getCodTipoAcaoProcesso();

    String getNomTipoAcaoProcesso();
    
    @Value("#{target.modulo.codModulo.toString()}")
    String getCodModulo();
    
}
