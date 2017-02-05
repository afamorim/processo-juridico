package br.com.telefonica.processum.scraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

import br.com.telefonica.processum.model.ProcessoScrapingModel;
import br.com.telefonica.processum.model.StatusProcessoScraping;
import br.com.telefonica.processum.service.ProcessoScrapingService;
import br.com.telefonica.processum.service.impl.ProcessoScrapingServiceImpl;

@Component
public class ScrapingTJSP {

	private String	strURL;
	private String	strLogin;
	private String	strSenha;
	
	private String 	proxyURL;
	private Integer proxyPorta;
	private String	proxyLogin;
	private String	proxySenha;
	
	private WebClient webClient;
	
	@Autowired
	private ProcessoScrapingService processoService;
	
	public ScrapingTJSP(){
		strURL = "https://esaj.tjsp.jus.br/cpopg/open.do";
		
		proxyURL = "proxylatam.indra.es";
		proxyPorta = 8080;
		proxyLogin = "afamorim";
		proxySenha = "Indra#2020";
		
		webClient = new WebClient(BrowserVersion.CHROME, proxyURL, proxyPorta);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setUseInsecureSSL(true);
		
		final DefaultCredentialsProvider credentialsProvider = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
		credentialsProvider.addCredentials(proxyLogin, proxySenha);
	}
	
	public void scrapingSolicitado(List<ProcessoScrapingModel> processos){
		String url = "https://esaj.tjsp.jus.br/cpopg/search.do?conversationId=&dadosConsulta.localPesquisa.cdLocal=-1&cbPesquisa=NUMPROC&dadosConsulta.tipoNuProcesso=UNIFICADO&numeroDigitoAnoUnificado=:numeroProcesso:&foroNumeroUnificado=:numeroForo:&dadosConsulta.valorConsultaNuUnificado=:numProcessoCompleto:&dadosConsulta.valorConsulta=&uuidCaptcha=";
		for (ProcessoScrapingModel processo : processos){
			String[] arrayNumeroProcesso = processo.getNumeroProcesso().split("\\.");
			String urlModificada = url.replaceAll(":numeroProcesso:", arrayNumeroProcesso[0]);
			urlModificada = urlModificada.replaceAll(":numeroForo:", arrayNumeroProcesso[arrayNumeroProcesso.length-1]);
			urlModificada = urlModificada.replaceAll(":numProcessoCompleto:", processo.getNumeroProcesso());
			System.out.println(urlModificada);
			try {
				HtmlPage consultaProcessoPG = (HtmlPage)webClient.getPage(urlModificada);
				ProcessoScrapingModel processoTJSP = loadProcessoTJSSP(consultaProcessoPG);
				System.out.println(processoTJSP);
				if (processoTJSP.getNumeroProcesso() != null){
					processoTJSP.setStatusProcessoScraping(new StatusProcessoScraping(StatusProcessoScraping.CARREGADO));
					processoService.update(processoTJSP);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void scrapinAutomatico(){
		try {
			
			
			HtmlPage consultaProcessosPG = (HtmlPage)webClient.getPage(strURL);
			HtmlForm consultaProcessoForm = consultaProcessosPG.getFormByName("consultarProcessoForm");
			
			HtmlSelect selForo = (HtmlSelect)consultaProcessoForm.getSelectByName("dadosConsulta.localPesquisa.cdLocal");
			selForo.setSelectedAttribute(selForo.getOptionByValue("83"), true);
			
			HtmlSelect selPor = (HtmlSelect)consultaProcessoForm.getSelectByName("cbPesquisa");
			selPor.setSelectedAttribute(selPor.getOptionByValue("NMPARTE"), true);
			
			HtmlTextInput inputNomeParte = (HtmlTextInput)consultaProcessoForm.getInputByName("dadosConsulta.valorConsulta");
			inputNomeParte.setText("telefonica");
			
			HtmlSubmitInput btnPesquisa = (HtmlSubmitInput) consultaProcessoForm.getInputByName("pbEnviar");
			
			//JA VAI ACESSAR A PAGINA DE FORMA DIRETA
			consultaProcessosPG = (HtmlPage)webClient.getPage("https://esaj.tjsp.jus.br/cpopg/search.do?conversationId=&dadosConsulta.localPesquisa.cdLocal=83&cbPesquisa=NMPARTE&dadosConsulta.tipoNuProcesso=UNIFICADO&dadosConsulta.valorConsulta=telefonica&uuidCaptcha=");
			List<ProcessoScrapingModel> processos = new ArrayList<>();
			System.out.println(consultaProcessosPG.getAnchors());
			boolean temPaginacao;
			do {
				temPaginacao = false;
				processos.addAll(loadProcessosByLinks(consultaProcessosPG));
				for (HtmlAnchor link : consultaProcessosPG.getAnchors()){
					if (link.getAttribute("title").indexOf("Próxima") > -1){
						temPaginacao = true;
						consultaProcessosPG = (HtmlPage)link.click();
					}
				}
			}while (temPaginacao);
			processoService.insert(processos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<ProcessoScrapingModel> loadProcessosByLinks(HtmlPage consultaProcessosPG) throws IOException{
		List<ProcessoScrapingModel> retorno = new ArrayList<>();
		for (HtmlAnchor link : consultaProcessosPG.getAnchors()){
			if (link.getAttribute("class").indexOf("linkProcesso") > -1){
				HtmlPage detalheProcessum = (HtmlPage)link.click();
				ProcessoScrapingModel processoTJSP = loadProcessoTJSSP(detalheProcessum);
				retorno.add(processoTJSP);
			}
		}
		return retorno;
	}
	
	private ProcessoScrapingModel loadProcessoTJSSP(HtmlPage detalheProcessum){
		ProcessoScrapingModel processoTJSP = new ProcessoScrapingModel();
		int countTable = 0;
		for (DomElement domElement : detalheProcessum.getElementsByTagName("table")){
			if (domElement.getAttribute("class").equals("secaoFormBody")){
				int countSpan = 0;
				if (countTable == 1){
					processoTJSP.setNumeroProcesso(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
					countSpan += 2;
					if (domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim().indexOf("prioritária") > -1){
						countSpan++;
					}
					processoTJSP.setClasse(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
					int countIntTable = 0;
					for (DomElement domChild : domElement.getElementsByTagName("table")){
						
						if (countIntTable == 3){
							String strArea = domChild.getElementsByTagName("td").get(0).getTextContent().trim();
							strArea = strArea.replaceAll("<span class=\"labelClass\">Área:</span>", "");
							strArea = strArea.replaceAll("\"", "");
							strArea = strArea.replaceAll("Área:", "");
							processoTJSP.setArea(strArea.trim());
						}
						countIntTable++;
					}
					countSpan += 5;
					
					if (domElement.getElementsByTagName("label").get(3).getTextContent().indexOf("Assunto") > -1){
						processoTJSP.setAssunto(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
						countSpan++;
					}
					
					if (domElement.getElementsByTagName("label").get(3).getTextContent().indexOf("Local") > -1){
						//processoTJSP.setLocal(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
						countSpan++;
					}
					
					if (domElement.getElementsByTagName("label").get(3).getTextContent().indexOf("assuntos") > -1){
						processoTJSP.setOutrosAssuntos(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
						countSpan++;
					}
					
					processoTJSP.setDistribuicao(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
					countSpan++;
					
					processoTJSP.setDistribuicao(processoTJSP.getDistribuicao() + " " + domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
					countSpan++;
					
					processoTJSP.setControle(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
					countSpan++;
					
					if (domElement.getElementsByTagName("label").get(3).getTextContent().indexOf("Juiz") > -1){
						processoTJSP.setJuiz(domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim());
						countSpan++;
					}
					
					System.out.println(">>>>>>> " + processoTJSP);
					if (domElement.getElementsByTagName("label").get(3).getTextContent().indexOf("Valor") > -1){
						String strValoracao = domElement.getElementsByTagName("span").get(countSpan).getTextContent().trim();
						strValoracao.replaceAll("R$", "");
						processoTJSP.setValorAcao(strValoracao.trim());
						countSpan++;
					}
				}
				countTable++;
			}
			if (domElement.getAttribute("id").equals("tablePartesPrincipais")){
				if (domElement.getElementsByTagName("td").size() >= 3){
					String strRequerente = domElement.getElementsByTagName("td").get(1).getTextContent();
					String strRequerido = domElement.getElementsByTagName("td").get(3).getTextContent();
					processoTJSP.setRequerente(strRequerente.trim().substring(0, strRequerente.trim().indexOf("\n")));
					processoTJSP.setAdvogado(strRequerente.trim().substring(strRequerente.trim().indexOf("\n")).trim());
					processoTJSP.setRequerido(strRequerido.trim());
				}
			}
		}
		System.out.println("processoTJSP: " + processoTJSP);
		processoTJSP.setStatusProcessoScraping(new StatusProcessoScraping(StatusProcessoScraping.CARREGADO));
		return processoTJSP;
	}
	
}
