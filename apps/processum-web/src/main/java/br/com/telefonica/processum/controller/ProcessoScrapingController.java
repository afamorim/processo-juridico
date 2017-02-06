package br.com.telefonica.processum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;
import br.com.telefonica.processum.service.ProcessoScrapingService;

@RestController
public class ProcessoScrapingController {

	@Autowired
	private ProcessoScrapingService	processoService;
	
	@RequestMapping(value = "/scraping/buscaProcessos", method = RequestMethod.GET)
    public List<ProcessoScrapingModel> buscaProcessosScraping(@RequestParam Long codigoStatus) throws ServicoException {
        StatusProcessoScraping status = new StatusProcessoScraping(codigoStatus);
        return processoService.findProcessosByStatus(status);
    }
	
	@RequestMapping(value = "/scraping/salvarNumeroProcesso", method = RequestMethod.GET)
    public void salvarNumeroProcesso(@RequestParam String numeroProcesso) throws ServicoException {
		ProcessoScrapingModel processo = new ProcessoScrapingModel();
		processo.setNumeroProcesso(numeroProcesso);
		processoService.insert(processo);
	}
}
