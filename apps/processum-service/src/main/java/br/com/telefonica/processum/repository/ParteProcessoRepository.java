package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.ParteProcesso;
import br.com.telefonica.processum.repository.projection.ParteProcessoProjection;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jadossantos
 */
@RepositoryRestResource(collectionResourceRel = "parteProcesso", path = "parteprocesso", excerptProjection = ParteProcessoProjection.class)
@CrossOrigin
public interface ParteProcessoRepository extends PagingAndSortingRepository<ParteProcesso, BigDecimal> {
    
    public List<ParteProcesso> findByNomParteProcessoContainingIgnoreCaseOrderByNomParteProcesso(@Param("nomParteProcesso") String nomParteProcesso);

}
