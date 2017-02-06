package br.com.telefonica.processum.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.telefonica.processum.scraping.ScrapingTJSP;
import br.com.telefonica.processum.service.ProcessoScrapingService;
import br.com.telefonica.processum.threads.ThreadCarregarProcessosByScraping;
import br.com.telefonica.processum.threads.ThreadCarregarProcessosSolicitados;
import br.com.telefonica.processum.threads.ThreadProcessoScrapingAutomatico;

@WebListener
public class ConfigureServicesBackgroundListener  implements ServletContextListener{

	@Autowired
	private ScrapingTJSP scrapingTJSP;
	
	@Autowired
	private ProcessoScrapingService	processoScrapingService;
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//		initThreadProcessoScrapingAutomatico(scrapingTJSP);
		initThreadCarregarProcessoSolicitados(scrapingTJSP, processoScrapingService);
		initThreadCarregarProcessosByScraping(processoScrapingService);
	}
	
	public void contextDestroyed(ServletContextEvent event) {
	}

	
	private void initThreadProcessoScrapingAutomatico(ScrapingTJSP scrapingTJSP){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new ThreadProcessoScrapingAutomatico(scrapingTJSP));
	}
	
	private void initThreadCarregarProcessoSolicitados(ScrapingTJSP scrapingTJSP, ProcessoScrapingService	processoScrapingService){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new ThreadCarregarProcessosSolicitados(processoScrapingService, scrapingTJSP));
	}
	
	private void initThreadCarregarProcessosByScraping(ProcessoScrapingService	processoScrapingService){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new ThreadCarregarProcessosByScraping(processoScrapingService));
	}
}