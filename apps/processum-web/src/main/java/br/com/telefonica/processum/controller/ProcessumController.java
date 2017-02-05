package br.com.telefonica.processum.controller;

import br.com.telefonica.processum.exception.ServicoException;
import br.com.telefonica.processum.http.request.DadosRequisicao;
import br.com.telefonica.processum.http.response.DadosResposta;
import br.com.telefonica.processum.service.IntegracaoService;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.telefonica.processum.controller.util.PdfUtil;
import br.com.telefonica.processum.model.PocOcorrencia;
import br.com.telefonica.processum.repository.PocOcorrenciaRepository;
import br.com.telefonica.processum.scraping.ScrapingTJSP;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ifbomfim
 */
@RestController
public class ProcessumController {

    @Autowired

    private IntegracaoService integracaoService;

    @Autowired
    private ScrapingTJSP scrapingTJSP;

    @Autowired
    private PocOcorrenciaRepository pocOcorrenciaRepository;

    @RequestMapping(value = "/teste", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "Teste";
    }

    @RequestMapping(value = "/buscarpessoa", method = RequestMethod.GET)
    public DadosResposta buscaDadosPessoa(@RequestParam String tipoFiltro, @RequestParam String filtro) throws ServicoException {
        DadosRequisicao dadosRequisicao = DadosRequisicao
                .builder()
                .filtro(filtro)
                .tipoFiltro("LINHA")
                .build();
        return integracaoService.integrar(dadosRequisicao);
    }

    @RequestMapping(value = "/salvarocorrencia", method = RequestMethod.POST)
    public void salvarOcorrencia(@ModelAttribute("pocOcorrencia") PocOcorrencia pocOcorrencia) {
        System.out.println(pocOcorrencia);
    }

    @RequestMapping(value = "/downloadPdfApuracao/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void downloadPdfApuracao(@PathVariable("id") long id, HttpServletResponse response) throws IOException {
        PocOcorrencia pocOcorrencia = pocOcorrenciaRepository.findOne(new BigDecimal(id));

        if (pocOcorrencia != null && pocOcorrencia.getIdPocOcorrencia() != null) {
            File file = PdfUtil.createTempFile();
            PdfUtil.createPdf(new FileOutputStream(file), pocOcorrencia);

            System.out.println("Download inicializado");
            InputStream in = new FileInputStream(file);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            response.setHeader("Content-Length", String.valueOf(file.length()));
            FileCopyUtils.copy(in, response.getOutputStream());

            System.out.println("Download finalizado");
        }

    }
}
