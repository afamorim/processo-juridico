package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Natureza;
import br.com.telefonica.processum.repository.projection.NaturezaProjection;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "natureza", path = "natureza", excerptProjection = NaturezaProjection.class)
@CrossOrigin
public interface NaturezaRepository extends PagingAndSortingRepository<Natureza, BigDecimal> {
    
    public List<Natureza> findByOrderByDesNatureza();
    
    public List<Natureza> findByDesNaturezaContainingIgnoreCaseOrderByDesNatureza(@Param("desNatureza") String desNatureza);
    
}
