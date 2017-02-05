package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Municipio;
import br.com.telefonica.processum.model.MunicipioPK;
import br.com.telefonica.processum.repository.projection.MunicipioProjection;
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
@RepositoryRestResource(collectionResourceRel = "municipio", path = "municipio", excerptProjection = MunicipioProjection.class)
@CrossOrigin
public interface MunicipioRepository extends PagingAndSortingRepository<Municipio, MunicipioPK> {
    
    @Query("SELECT m FROM Municipio m "
            + "INNER JOIN FETCH m.estado e "
            + "WHERE m.stsAtivo = 1 "
            + "AND UPPER(e.sigEstado) = ?1 "
            + "ORDER BY m.nomMunicipio ")
    public List<Municipio> findBySigEstadoOrderByNomMunicipio(@Param("sigEstado") String sigEstado);
    
    @Query("SELECT m FROM Municipio m "
            + "INNER JOIN FETCH m.estado e "
            + "WHERE m.stsAtivo = 1 "
            + "AND UPPER(e.sigEstado) = ?1 "
            + "AND UPPER(m.nomMunicipio) LIKE %?2% "
            + "ORDER BY m.nomMunicipio ")
    public List<Municipio> findBySigEstadoAndNomMunicipioOrderByNomMunicipio(@Param("sigEstado") String sigEstado, @Param("nomMunicipio") String nomMunicipio);
}
