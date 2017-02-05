package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Autor;
import br.com.telefonica.processum.model.AutorPK;
import br.com.telefonica.processum.repository.projection.AutorProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "autor", path = "autor", excerptProjection = AutorProjection.class)
@CrossOrigin
public interface AutorRepository extends PagingAndSortingRepository<Autor, AutorPK> {
    
}
