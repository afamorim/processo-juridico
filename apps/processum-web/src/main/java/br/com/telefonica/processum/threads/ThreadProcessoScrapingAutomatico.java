package br.com.telefonica.processum.threads;

import br.com.telefonica.processum.scraping.ScrapingTJSP;

public class ThreadProcessoScrapingAutomatico implements Runnable {

	private ScrapingTJSP scrapingTJSP;
	
	public ThreadProcessoScrapingAutomatico(ScrapingTJSP aScrapingTJSP){
		scrapingTJSP = aScrapingTJSP;
	}
	
	@Override
	public void run() {
		try {
			while (true){
				scrapingTJSP.scrapinAutomatico();
				Thread.sleep(600000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}