package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Advogado;
import br.com.telefonica.processum.repository.projection.AdvogadoProjection;
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
@RepositoryRestResource(collectionResourceRel = "advogado", path = "advogado", excerptProjection = AdvogadoProjection.class)
@CrossOrigin
public interface AdvogadoRepository extends PagingAndSortingRepository<Advogado, String> {

    @Query("SELECT a FROM Advogado a "
            + "WHERE a.stsAdvogadoAtivo = 1 "
            + "AND UPPER(a.nomAdvogado) LIKE %?1% "
            + "ORDER BY a.nomAdvogado ")
    public List<Advogado> findByNomAdvogadoOrderByNomAdvogado(@Param("nomAdvogado") String nomAdvogado);
    
}
