package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.DetalheEspecificNatureza;
import br.com.telefonica.processum.model.DetalheEspecificNaturezaPK;
import br.com.telefonica.processum.repository.projection.DetalheEspecificNaturezaProjection;
import java.math.BigInteger;
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
@RepositoryRestResource(collectionResourceRel = "detalheEspecificNatureza", path = "detalheespecificnatureza", excerptProjection = DetalheEspecificNaturezaProjection.class)
@CrossOrigin
public interface DetalheEspecNaturezaRepository extends PagingAndSortingRepository<DetalheEspecificNatureza, DetalheEspecificNaturezaPK> {

    public List<DetalheEspecificNatureza> findByCodNatureza(@Param("codNatureza") BigInteger codNatureza);

    @Query("SELECT den FROM DetalheEspecificNatureza den "
            + "INNER JOIN FETCH den.especificacaoNatureza en "
            + "WHERE den.detalheEspecificNaturezaPK.codNatureza = ?1 "
            + "ORDER BY en.desEspecificacaoNatureza, den.nomDetalheEspecificNatureza ")
    public List<DetalheEspecificNatureza> findByCodNaturezaOrderByDesEspecificacaoNatureza(@Param("codNatureza") BigInteger codNatureza);
    
    @Query("SELECT den FROM DetalheEspecificNatureza den "
            + "INNER JOIN FETCH den.especificacaoNatureza en "
            + "WHERE den.detalheEspecificNaturezaPK.codNatureza = ?1 "
            + "AND (UPPER(en.desEspecificacaoNatureza) LIKE %?2% "
            + "OR UPPER(den.nomDetalheEspecificNatureza) LIKE %?2%) "
            + "ORDER BY en.desEspecificacaoNatureza, den.nomDetalheEspecificNatureza ")
    public List<DetalheEspecificNatureza> findByFilterOrderByDesEspecificacaoNatureza(@Param("codNatureza") BigInteger codNatureza, @Param("nomDetalheEspecificNatureza") String nomDetalheEspecificNatureza);
    
}
