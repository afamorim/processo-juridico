package br.com.telefonica.processum.service;

import java.util.List;

import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;

public interface ProcessoScrapingService {

	public void insert(List<ProcessoScrapingModel> processos);
	
	public void update(ProcessoScrapingModel processo);
	
	public void inert(ProcessoScrapingModel processo);
	
	public List<ProcessoScrapingModel> findProcessosByStatus(StatusProcessoScraping status);
	
	public void loadProcessosPendentes(); 
}
