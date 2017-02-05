package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.Estado;
import br.com.telefonica.processum.repository.projection.EstadoProjection;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author ifbomfim
 */
@RepositoryRestResource(collectionResourceRel = "estado", path = "estado", excerptProjection = EstadoProjection.class)
@CrossOrigin
public interface EstadoRepository extends PagingAndSortingRepository<Estado, String>{
    
    public List<Estado> findByOrderBySigEstado();
    
    public List<Estado> findByNomEstadoContainingIgnoreCaseOrderBySigEstado(@Param("nomEstado") String nomEstado);
    
}
