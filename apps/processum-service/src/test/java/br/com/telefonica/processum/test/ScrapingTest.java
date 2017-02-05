package br.com.telefonica.processum.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.scraping.ScrapingTJSP;

public class ScrapingTest {

//	@Test
	public void scrapingAutomaticoTJSPTest(){
		ScrapingTJSP scrapingTJSP = new ScrapingTJSP();
		scrapingTJSP.scrapinAutomatico();
	}
	
	@Test
	public void scrapingTJSPTest(){
		ScrapingTJSP scrapingTJSP = new ScrapingTJSP();
		List<ProcessoScrapingModel> processos = new ArrayList<>();
		ProcessoScrapingModel processo = new ProcessoScrapingModel();
		processo.setNumeroProcesso("1001628-50.2016.8.26.0083");
		processos.add(processo);
		scrapingTJSP.scrapingSolicitado(processos);
	}
}
