package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Juizo;
import br.com.telefonica.processum.model.JuizoPK;
import br.com.telefonica.processum.repository.projection.JuizoProjection;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jadossantos
 */
@RepositoryRestResource(collectionResourceRel = "juizo", path = "juizo", excerptProjection = JuizoProjection.class)
@CrossOrigin
public interface JuizoRepository extends PagingAndSortingRepository<Juizo, JuizoPK> {
    
    @Query("SELECT j FROM Juizo j "
            + "INNER JOIN FETCH j.comarca c "
            + "WHERE c.stsAtivo = 1 "
            + "AND c.codComarca = ?1 "
            + "ORDER BY j.nomJuizo ")
    public List<Juizo> findByCodComarcaOrderByNomJuizo(@Param("codComarca") BigDecimal codComarca);
    
    @Query("SELECT j FROM Juizo j "
            + "INNER JOIN FETCH j.comarca c "
            + "WHERE c.stsAtivo = 1 "
            + "AND c.codComarca = ?1 "
            + "AND UPPER(j.nomJuizo) LIKE %?2% "
            + "ORDER BY j.nomJuizo ")
    public List<Juizo> findByCodComarcaAndNomJuizoOrderByNomJuizo(@Param("codComarca") BigDecimal codComarca, @Param("nomJuizo") String nomJuizo);
    
}
