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
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

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

        pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new TableHeaderEventHandler(document));

        Table table = newTable();
        addCell(table, "CNPJ/CPF", pocOcorrencia.getNumCpfCnpj());
        addCell(table, "Número da linha fixa/móvel", pocOcorrencia.getNumLinha());
        addCell(table, "Data Início da Pesquisa", getDateToString(pocOcorrencia.getDtcInicioPequisa()));
        addCell(table, "Data Fim da Pesquisa", getDateToString(pocOcorrencia.getDtcFimPesquisa()));

        addTable(document, table, "1 – Dados de entrada");

        table = newTable();
        addCell(table, "Nome do Cliente", pocOcorrencia.getNomCliente());
        addCell(table, "Nome da Conta", pocOcorrencia.getNomConta());
        addCell(table, "Data do Cadastro", getDateToString(pocOcorrencia.getDtcPocOcorrencia()));
        addCell(table, "Tipo de Conta", pocOcorrencia.getNomTipoConta());
        addCell(table, "Tipo de Assinatura", pocOcorrencia.getNomTipoAssinatura());
        addCell(table, "Status da Assinatura", pocOcorrencia.getStsAssinatura());
        addCell(table, "Endereço Correspondência", pocOcorrencia.getDesEnderecoCorrespondencia());
        addCell(table, "Endereço Tributação", pocOcorrencia.getDesEnderecoTributacao() + "1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 1234567890 ");
        addCell(table, "Saldo", pocOcorrencia.getValSaldo());
        addCell(table, "Forma de Pagamento", pocOcorrencia.getNomFormaPagamento());

        addTable(document, table, "2 – Dados de saída");

        //Close document
        document.close();
    }

    private static Table newTable() {
        Table table = new Table(new float[]{35, 65});
        table.setWidthPercent(100);
        return table;
    }

    private static void addCell(final Table table, final String label, final String texto) throws IOException {
        final String labelFormat = label != null ? label : "";
        final String textoFormat = texto != null ? texto : "";

        final PdfFont fontLabel = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        final PdfFont fontTexto = PdfFontFactory.createFont(FontConstants.HELVETICA);

        final Cell cellLabel = new Cell().add(new Paragraph(labelFormat).setFont(fontLabel)).setPaddings(5, 10, 5, 10).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT);
        final Cell cellFormat = new Cell().add(new Paragraph(textoFormat).setFont(fontTexto)).setPaddings(5, 10, 5, 10).setVerticalAlignment(VerticalAlignment.MIDDLE).setHorizontalAlignment(HorizontalAlignment.LEFT);

        table.addCell(cellLabel);
        table.addCell(cellFormat);
    }

    private static void addTable(final Document document, final Table table, final String titulo) throws IOException {
        Style blueText = new Style();
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        blueText.setFont(font).setFontSize(18).setFontColor(Color.BLUE);

        Paragraph p = new Paragraph();
        p.add(new Text(titulo).addStyle(blueText));
        document.add(p);
        document.add(table);
        document.add(new Paragraph(""));
    }

    private static String getDateToString(final Date date) {
        if (date != null) {
            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
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
            
            Image image = new Image(ImageDataFactory.create(getImage("img\\logo_telefonica.png")), 2, 2);
            image.setFixedPosition(margin, PageSize.A4.getHeight() - margin);
            image.scaleToFit(widthImage, heightImage);
            
            PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
            PdfDocument pdfDoc = docEvent.getDocument();
            PdfPage page = docEvent.getPage();
            
            PdfCanvas canvas = new PdfCanvas(page.newContentStreamBefore(), page.getResources(), pdfDoc);
            
            Rectangle rect = new Rectangle(widthImage + margin * 2,
                    pdfDoc.getDefaultPageSize().getTop() - doc.getTopMargin(), 300, 17);
            
            new Canvas(canvas, pdfDoc, rect).add(image);
            new Canvas(canvas, pdfDoc, rect).add(cell);
        }

        private URL getImage(final String name) {
            ClassLoader classLoader = getClass().getClassLoader();
            return classLoader.getResource(name);
        }
    }

}
