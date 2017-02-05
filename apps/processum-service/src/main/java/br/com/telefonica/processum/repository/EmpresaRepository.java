package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Empresa;
import br.com.telefonica.processum.repository.projection.EmpresaProjection;
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
@RepositoryRestResource(collectionResourceRel = "empresa", path = "empresa", excerptProjection = EmpresaProjection.class)
@CrossOrigin
public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, BigDecimal> {
    
    public List<Empresa> findByNomEmpresaContainingIgnoreCaseOrderByNomEmpresa(@Param("nomEmpresa") String nomEmpresa);

}
