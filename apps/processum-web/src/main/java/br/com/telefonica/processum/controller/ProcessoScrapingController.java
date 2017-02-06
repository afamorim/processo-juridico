package br.com.telefonica.processum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;
import br.com.telefonica.processum.service.ProcessoScrapingService;

@CrossOrigin
@RestController
public class ProcessoScrapingController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
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
		processo.setStatusProcessoScraping(new StatusProcessoScraping(StatusProcessoScraping.A_CARREGAR));
		processo.setStrDataInclusao(dateFormat.format(new Date()));
		processoService.insert(processo);
	}
}
