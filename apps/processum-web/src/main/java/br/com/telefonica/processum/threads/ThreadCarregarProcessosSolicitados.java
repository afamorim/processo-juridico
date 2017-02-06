package br.com.telefonica.processum.threads;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;
import br.com.telefonica.processum.scraping.ScrapingTJSP;
import br.com.telefonica.processum.service.ProcessoScrapingService;

public class ThreadCarregarProcessosSolicitados implements Runnable{

	@Autowired
	private ScrapingTJSP scrapingTJSP;
	
	@Autowired
	private ProcessoScrapingService	processoScrapingService;
	
	public ThreadCarregarProcessosSolicitados(ProcessoScrapingService aProcessoScrapingService, ScrapingTJSP aScrapingTJSP){
		scrapingTJSP = aScrapingTJSP;
		processoScrapingService = aProcessoScrapingService;
	}
	
	@Override
	public void run() {
		try {
			while (true){
				List<ProcessoScrapingModel> processos = processoScrapingService.findProcessosByStatus(new StatusProcessoScraping(StatusProcessoScraping.A_CARREGAR));
				scrapingTJSP.scrapingSolicitado(processos);
				Thread.sleep(600000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
