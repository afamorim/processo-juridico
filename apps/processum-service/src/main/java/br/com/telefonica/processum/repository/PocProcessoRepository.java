package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.PocProcesso;
import br.com.telefonica.processum.repository.projection.PocProcessoProjection;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jadossantos
 */
@RepositoryRestResource(collectionResourceRel = "pocProcesso", path = "pocprocesso", excerptProjection = PocProcessoProjection.class)
@CrossOrigin
public interface PocProcessoRepository extends PagingAndSortingRepository<PocProcesso, BigDecimal> {

}
