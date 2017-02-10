package br.com.telefonica.processum.controller.util;

import br.com.telefonica.processum.model.PocOcorrencia;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author jadossantos
 */
public final class PdfUtil {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\desenvolvimento\\projetos\\processo-juridico\\pdf-test.pdf");

        PocOcorrencia pocOcorrencia = new PocOcorrencia();
        pocOcorrencia.setDesEnderecoCorrespondencia("desEnderecoCorrespondencia");
        pocOcorrencia.setDesEnderecoTributacao("desEnderecoTributacao");
        pocOcorrencia.setDesErro("desErro");
        pocOcorrencia.setDtcCadastro(new Date());
        pocOcorrencia.setDtcFimPesquisa(new Date());
        pocOcorrencia.setDtcInicioPequisa(new Date());
        pocOcorrencia.setDtcPocOcorrencia(new Date());
        pocOcorrencia.setIdPocOcorrencia(BigDecimal.TEN);
        pocOcorrencia.setNomCliente("nomCliente");
        pocOcorrencia.setNomConta("nomConta");
        pocOcorrencia.setNomFormaPagamento("nomFormaPagamento");
        pocOcorrencia.setNomTipoAssinatura("nomTipoAssinatura");
        pocOcorrencia.setNomTipoConta("nomTipoConta");
        pocOcorrencia.setNumCpfCnpj("numCpfCnpj");
        pocOcorrencia.setNumLinha("numLinha");
        pocOcorrencia.setNumProcesso("numProcesso");
        pocOcorrencia.setStsAssinatura("stsAssinatura");
        pocOcorrencia.setStsErro("stsErro");
        pocOcorrencia.setStsPocOcorrencia("stsPocOcorrencia");
        pocOcorrencia.setValSaldo("valSaldo");

        PdfUtil.createPdf(new FileOutputStream(file), pocOcorrencia);
    }

    public static void createPdf(OutputStream os, PocOcorrencia pocOcorrencia) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(os);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(20, 20, 20, 20);
        document.add(new Paragraph(""));

        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new TableHeaderEventHandler(document));

        addTitle(document, "1 – Dados do Processo");
        
        addCell(document, "CNPJ/CPF", pocOcorrencia.getNumCpfCnpj());
        addCell(document, "Número da linha fixa/móvel", pocOcorrencia.getNumLinha());
        addCell(document, "Data Início da Pesquisa", getDateToString_DDMMYYYY(pocOcorrencia.getDtcInicioPequisa()));
        addCell(document, "Data Fim da Pesquisa", getDateToString_DDMMYYYY(pocOcorrencia.getDtcFimPesquisa()));
        
        addTitle(document, "2 – Dados da(s) Linhas(s) Reclamada(s)");
        
        addCell(document, "Nome do Cliente", pocOcorrencia.getNomCliente());
        addCell(document, "Nome da Conta", pocOcorrencia.getNomConta());
        addCell(document, "Data do Cadastro", getDateToString_DDMMYYYY_HHMMSS(pocOcorrencia.getDtcPocOcorrencia()));
        addCell(document, "Tipo de Conta", pocOcorrencia.getNomTipoConta());
        addCell(document, "Tipo de Assinatura", pocOcorrencia.getNomTipoAssinatura());
        addCell(document, "Status da Assinatura", pocOcorrencia.getStsAssinatura());
        addCell(document, "Endereço Correspondência", pocOcorrencia.getDesEnderecoCorrespondencia());
        addCell(document, "Endereço Tributação", pocOcorrencia.getDesEnderecoTributacao());
        addCell(document, "Saldo", pocOcorrencia.getValSaldo());
        addCell(document, "Forma de Pagamento", pocOcorrencia.getNomFormaPagamento());

        //Close document
        document.close();
    }

    private static void addCell(final Document document, final String strLabel, final String strTexto) throws IOException {
        final String labelFormat = strLabel != null ? strLabel + ": " : "";
        final String textoFormat = strTexto != null ? strTexto : "";

        final PdfFont fontLabel = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        final PdfFont fontTexto = PdfFontFactory.createFont(FontConstants.HELVETICA);
        
        final Text textLabel = new Text(labelFormat).setFont(fontLabel);
        final Text textTexto = new Text(textoFormat).setFont(fontTexto);
 
        Paragraph paragraph = new Paragraph().setMargin(0);
        paragraph.add(textLabel);
        paragraph.add(textTexto);
        
        document.add(paragraph);
    }

    private static void addTitle(final Document document, final String titulo) throws IOException {
        Style blueText = new Style();
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        blueText.setFont(font).setFontSize(18).setFontColor(Color.BLUE);

        Paragraph p = new Paragraph();
        p.add(new Text(titulo).addStyle(blueText));
        document.add(p);
    }

    private static String getDateToString_DDMMYYYY_HHMMSS(final Date date) {
        if (date != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            return dt.format(date);
        }
        return "";
    }
    
    private static String getDateToString_DDMMYYYY(final Date date) {
        if (date != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
            return dt.format(date);
        }
        return "";
    }

    public static File createTempFile() throws IOException {
        final File tempFile = File.createTempFile("arquivo-temp", ".pdf");
        tempFile.deleteOnExit();
        return tempFile;
    }

    private static class TableHeaderEventHandler implements IEventHandler {

        private Document doc;
        private Cell cell;

        public TableHeaderEventHandler(Document doc) throws IOException {
            this.doc = doc;

            Style style = new Style();
            PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            style.setFont(font).setFontSize(8).setFontColor(Color.RED).setUnderline();

            Paragraph p = new Paragraph();
            p.add(new Text("Gerência de Obrigações e Apoio Jurídico Móvel - GOAJ Móvel").addStyle(style));
            cell = new Cell().add(p);
        }

        @Override
        public void handleEvent(Event event) {
            final int margin = 20;
            final int widthImage = 72;
            final int heightImage = 274;
            
            Image image = null;
            
            try {
                InputStream is = getImage("img//logo_telefonica.png");
                if (is != null) {
                    byte[] array = IOUtils.toByteArray(is);
                    image = new Image(ImageDataFactory.create(array), 2, 2);
                    image.setFixedPosition(margin, PageSize.A4.getHeight() - margin);
                    image.scaleToFit(widthImage, heightImage);
                }
            } catch (IOException ex) {
                Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdfDoc = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            
            PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);
            
            Rectangle rect = new Rectangle(widthImage + margin * 2,
                    pdfDoc.getDefaultPageSize().getTop() - doc.getTopMargin(), 300, 17);
            
            
            if (image != null) {
                new Canvas(canvas, pdfDoc, rect).add(image);
            }
            new Canvas(canvas, pdfDoc, rect).add(cell);
        }

        private InputStream getImage(final String name) {
            ClassLoader classLoader = getClass().getClassLoader();
            return classLoader.getResourceAsStream(name);
        }
    }

}
