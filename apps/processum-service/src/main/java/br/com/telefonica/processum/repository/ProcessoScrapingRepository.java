package br.com.telefonica.processum.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.telefonica.processum.model.ProcessoScrapingModel;

@RepositoryRestResource(collectionResourceRel = "reu", path = "reu", excerptProjection = ProcessoScrapingModel.class)
public interface ProcessoScrapingRepository extends PagingAndSortingRepository<ProcessoScrapingModel, String	>{

	public List<ProcessoScrapingModel> findByStatusProcessoScrapingCodigo(Long codigo);
}
