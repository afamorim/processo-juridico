package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Comarca;
import br.com.telefonica.processum.repository.projection.ComarcaProjection;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "comarca", path = "comarca", excerptProjection = ComarcaProjection.class)
@CrossOrigin
public interface ComarcaRepository extends PagingAndSortingRepository<Comarca, BigDecimal> {
    
    @Query("SELECT c FROM Comarca c "
            + "INNER JOIN FETCH c.municipio m "
            + "WHERE c.stsAtivo = 1 "
            + "AND UPPER(m.municipioPK.sigEstado) = ?1 "
            + "AND UPPER(m.municipioPK.sigMunicipio) = ?2 "
            + "ORDER BY c.nomComarca ")
    public List<Comarca> findBySigEstadoAndSigMunicipioOrderByNomComarca(@Param("sigEstado") String sigEstado, @Param("sigMunicipio") String sigMunicipio);
    
    @Query("SELECT c FROM Comarca c "
            + "INNER JOIN FETCH c.municipio m "
            + "WHERE c.stsAtivo = 1 "
            + "AND UPPER(m.municipioPK.sigEstado) = ?1 "
            + "AND UPPER(m.municipioPK.sigMunicipio) = ?2 "
            + "AND UPPER(c.nomComarca) LIKE %?3% "
            + "ORDER BY c.nomComarca ")
    public List<Comarca> findBySigEstadoAndSigMunicipioAndNomComarcaOrderByNomComarca(@Param("sigEstado") String sigEstado, @Param("sigMunicipio") String sigMunicipio, @Param("nomComarca") String nomComarca);
    
}
