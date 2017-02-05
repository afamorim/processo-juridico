package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.PreObjetoEmpresa;
import br.com.telefonica.processum.repository.projection.PreObjetoEmpresaProjection;
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
@RepositoryRestResource(collectionResourceRel = "preObjetoEmpresa", path = "preobjetoempresa", excerptProjection = PreObjetoEmpresaProjection.class)
@CrossOrigin
public interface PreObjetoEmpresaRepository extends PagingAndSortingRepository<PreObjetoEmpresa, BigDecimal> {

    public List<PreObjetoEmpresa> findByOrderByNomPreObjetoEmpresa();
    
    public List<PreObjetoEmpresa> findByNomPreObjetoEmpresaContainingIgnoreCaseOrderByNomPreObjetoEmpresa(@Param("nomPreObjetoEmpresa") String nomPreObjetoEmpresa);
    
}
