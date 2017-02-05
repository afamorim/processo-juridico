package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.TipoAcao;
import br.com.telefonica.processum.model.TipoAcaoPK;
import br.com.telefonica.processum.repository.projection.TipoAcaoProjection;
import java.math.BigInteger;
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
@RepositoryRestResource(collectionResourceRel = "tipoAcao", path = "tipoacao", excerptProjection = TipoAcaoProjection.class)
@CrossOrigin
public interface TipoAcaoRepository extends PagingAndSortingRepository<TipoAcao, TipoAcaoPK> {

    @Query("SELECT t FROM TipoAcao t "
            + "INNER JOIN FETCH t.detalheEspecificNatureza den "
            + "WHERE t.stsAtivo = 1 "
            + "AND t.tipoAcaoPK.codPreObjetoEmpresa = ?1 "
            + "AND den.detalheEspecificNaturezaPK.codNatureza = ?2 "
            + "AND den.detalheEspecificNaturezaPK.codEspecificacaoNatureza = ?3 "
            + "AND den.detalheEspecificNaturezaPK.codDetalheEspecificNatureza = ?4 "
            + "AND UPPER(t.desTipoAcao) LIKE %?5% "
            + "ORDER BY t.desTipoAcao ")
    public List<TipoAcao> findByFilterOrderByDesTipoAcao(@Param("codPreObjetoEmpresa") BigInteger codPreObjetoEmpresa, @Param("codNatureza") BigInteger codNatureza, @Param("codEspecificacaoNatureza") BigInteger codEspecificacaoNatureza, @Param("codDetalheEspecificNatureza") BigInteger codDetalheEspecificNatureza, @Param("desTipoAcao") String desTipoAcao);

}
