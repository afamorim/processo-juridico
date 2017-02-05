package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Reu;
import br.com.telefonica.processum.model.ReuPK;
import br.com.telefonica.processum.repository.projection.ReuProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "reu", path = "reu", excerptProjection = ReuProjection.class)
@CrossOrigin
public interface ReuRepository extends PagingAndSortingRepository<Reu, ReuPK> {
    
}
