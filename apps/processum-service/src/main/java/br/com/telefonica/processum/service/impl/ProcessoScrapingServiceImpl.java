package br.com.telefonica.processum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telefonica.processum.model.PocProcesso;
import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;
import br.com.telefonica.processum.repository.PocProcessoRepository;
import br.com.telefonica.processum.repository.ProcessoScrapingRepository;
import br.com.telefonica.processum.service.ProcessoScrapingService;

@Service
public class ProcessoScrapingServiceImpl implements ProcessoScrapingService {

	@Autowired
	private ProcessoScrapingRepository processoScrapingRepository;
	
	@Autowired
	private PocProcessoRepository		pocProcessoRepository;
	
	@Override
	public void insert(List<ProcessoScrapingModel> aProcessos) {
		if (aProcessos != null && !aProcessos.isEmpty()){
			for (ProcessoScrapingModel processo : aProcessos){
				try {
					processoScrapingRepository.save(processo);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(ProcessoScrapingModel aProcesso) {
		processoScrapingRepository.save(aProcesso);
	}

	@Override
	public void inert(ProcessoScrapingModel aProcesso) {
		processoScrapingRepository.save(aProcesso);
	}
	
	public List<ProcessoScrapingModel> findProcessosByStatus(StatusProcessoScraping status){
		return processoScrapingRepository.findByStatusProcessoScrapingCodigo(status.getCodigo());
	}

	@Override
	public void loadProcessosPendentes() {
		List<ProcessoScrapingModel> processos = findProcessosByStatus(new StatusProcessoScraping());
		for (ProcessoScrapingModel processoScraping : processos){
			PocProcesso processo = new PocProcesso();
			processo.setNumProcesso(processoScraping.getNumeroProcesso());
			//processo.setVlrAcao(new Float(processoScraping.getValorAcao()));
			processo.setNomPoloAtivo(processoScraping.getRequerente());
			processo.setNomPoloPassivo(processoScraping.getRequerido());
			
			try {
				pocProcessoRepository.save(processo);
				processoScraping.setStatusProcessoScraping(new StatusProcessoScraping(StatusProcessoScraping.PROCESSO_CADASTRADO));
				processoScrapingRepository.save(processoScraping);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}