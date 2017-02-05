package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.PocOcorrencia;
import br.com.telefonica.processum.repository.projection.PocOcorrenciaProjection;
import java.math.BigDecimal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jadossantos
 */
@RepositoryRestResource(collectionResourceRel = "pocOcorrencia", path = "pococorrencia", excerptProjection = PocOcorrenciaProjection.class)
@CrossOrigin
public interface PocOcorrenciaRepository extends PagingAndSortingRepository<PocOcorrencia, BigDecimal> {

}
