package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.EspecificacaoNatureza;
import br.com.telefonica.processum.model.EspecificacaoNaturezaPK;
import br.com.telefonica.processum.repository.projection.EspecificacaoNaturezaProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "especificaoNatureza", path = "especificacaonatureza", excerptProjection = EspecificacaoNaturezaProjection.class)
@CrossOrigin
public interface EspecificacaoNaturezaRepository extends PagingAndSortingRepository<EspecificacaoNatureza, EspecificacaoNaturezaPK> {
    
}
