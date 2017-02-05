package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.DivisaoProcesso;
import br.com.telefonica.processum.repository.projection.DivisaoProcessoProjection;
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
@RepositoryRestResource(collectionResourceRel = "divisaoProcesso", path = "divisaoprocesso", excerptProjection = DivisaoProcessoProjection.class)
@CrossOrigin
public interface DivisaoProcessoRepository extends PagingAndSortingRepository<DivisaoProcesso, BigDecimal> {

    public List<DivisaoProcesso> findByOrderByNomDivisao();
    
    public List<DivisaoProcesso> findByNomDivisaoContainingIgnoreCaseOrderByNomDivisao(@Param("nomDivisao") String nomDivisao);
    
}
