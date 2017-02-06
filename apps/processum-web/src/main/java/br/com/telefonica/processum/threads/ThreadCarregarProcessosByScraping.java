package br.com.telefonica.processum.threads;

import br.com.telefonica.processum.service.ProcessoScrapingService;

public class ThreadCarregarProcessosByScraping implements Runnable {

	private ProcessoScrapingService	processoScrapingService;
	
	public ThreadCarregarProcessosByScraping(ProcessoScrapingService aProcessoScrapingService){
		processoScrapingService = aProcessoScrapingService;
	}
	
	@Override
	public void run() {
		try {
			while (true){
				processoScrapingService.loadProcessosPendentes();
				Thread.sleep(600000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
