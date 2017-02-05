package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.TerceiroInteressado;
import br.com.telefonica.processum.model.TerceiroInteressadoPK;
import br.com.telefonica.processum.repository.projection.TerceiroInteressadoProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "terceiroInteressado", path = "terceirointeressado", excerptProjection = TerceiroInteressadoProjection.class)
@CrossOrigin
public interface TerceiroInteressadoRepository extends PagingAndSortingRepository<TerceiroInteressado, TerceiroInteressadoPK> {
    
}
