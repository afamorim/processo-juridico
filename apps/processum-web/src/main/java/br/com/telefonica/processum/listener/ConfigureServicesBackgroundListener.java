package br.com.telefonica.processum.listener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import br.com.telefonica.processum.scraping.ScrapingTJSP;
import br.com.telefonica.processum.threads.ThreadProcessoScrapingAutomatico;

@WebListener
public class ConfigureServicesBackgroundListener  implements ServletContextListener{

	@Autowired
	private ScrapingTJSP scrapingTJSP;
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		initThreadProcessoScraping(scrapingTJSP);
	}
	
	public void contextDestroyed(ServletContextEvent event) {
	}

	
	private void initThreadProcessoScraping(ScrapingTJSP scrapingTJSP){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.execute(new ThreadProcessoScrapingAutomatico(scrapingTJSP));
	}
}