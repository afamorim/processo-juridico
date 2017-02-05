package br.com.telefonica.processum.repository;

import br.com.telefonica.processum.model.EscritorioContratado;
import br.com.telefonica.processum.repository.projection.EscritorioContratadoProjection;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jadossantos
 */
@RepositoryRestResource(collectionResourceRel = "escritorioContratado", path = "escritoriocontratado", excerptProjection = EscritorioContratadoProjection.class)
@CrossOrigin
public interface EscritorioContratadoRepository extends PagingAndSortingRepository<EscritorioContratado, String> {
    
    public List<EscritorioContratado> findByOrderByNomEscritorioContratado();
    
    public List<EscritorioContratado> findByNomEscritorioContratadoContainingIgnoreCaseOrderByNomEscritorioContratado(@Param("nomEscritorioContratado") String nomEscritorioContratado);
    
}
