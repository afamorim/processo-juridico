package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.TipoAcaoProcesso;
import br.com.telefonica.processum.repository.projection.TipoAcaoProcessoProjection;
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
@RepositoryRestResource(collectionResourceRel = "tipoAcaoProcesso", path = "tipoacaoprocesso", excerptProjection = TipoAcaoProcessoProjection.class)
@CrossOrigin
public interface TipoAcaoProcessoRepository extends PagingAndSortingRepository<TipoAcaoProcesso, BigDecimal> {

    @Query("SELECT tap FROM TipoAcaoProcesso tap "
            + "INNER JOIN FETCH tap.modulo m "
            + "WHERE m.codModulo = 3 "
            + "ORDER BY tap.nomTipoAcaoProcesso ")
    public List<TipoAcaoProcesso> findByOrderByNomTipoAcaoProcesso();
    
    @Query("SELECT tap FROM TipoAcaoProcesso tap "
            + "INNER JOIN FETCH tap.modulo m "
            + "WHERE m.codModulo = 3 "
            + "AND tap.nomTipoAcaoProcesso LIKE %?1% "
            + "ORDER BY tap.nomTipoAcaoProcesso ")
    public List<TipoAcaoProcesso> findByNomTipoAcaoProcessoOrderByNomTipoAcaoProcesso(@Param("nomTipoAcaoProcesso") String nomTipoAcaoProcesso);
    
}
