package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Modulo;
import br.com.telefonica.processum.repository.projection.ModuloProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "modulo", path = "modulo", excerptProjection = ModuloProjection.class)
@CrossOrigin
public interface ModuloRepository extends PagingAndSortingRepository<Modulo, Long> {

}
