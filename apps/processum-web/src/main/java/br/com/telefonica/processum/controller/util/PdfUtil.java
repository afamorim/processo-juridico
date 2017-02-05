package br.com.telefonica.processum.controller.util;

import br.com.telefonica.processum.model.PocOcorrencia;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jadossantos
 */
public final class PdfUtil {

    public static void createPdf(OutputStream os, PocOcorrencia pocOcorrencia) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(os);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        final PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);

        Table table = newTable();
        addCell(table, "CNPJ/CPF", pocOcorrencia.getNumCpfCnpj(), font);
        addCell(table, "Número da linha fixa/móvel", pocOcorrencia.getNumLinha(), font);
        addCell(table, "Data Início da Pesquisa", getDateToString(pocOcorrencia.getDtcInicioPequisa()), font);
        addCell(table, "Data Fim da Pesquisa", getDateToString(pocOcorrencia.getDtcFimPesquisa()), font);

        document.add(new Paragraph("1 – Dados de entrada"));
        document.add(table);

        table = newTable();
        addCell(table, "Nome do Cliente", pocOcorrencia.getNomCliente(), font);
        addCell(table, "Nome da Conta", pocOcorrencia.getNomConta(), font);
        addCell(table, "Data do Cadastro", getDateToString(pocOcorrencia.getDtcPocOcorrencia()), font);
        addCell(table, "Tipo de Conta", pocOcorrencia.getNomTipoConta(), font);
        addCell(table, "Tipo de Assinatura", pocOcorrencia.getNomTipoAssinatura(), font);
        addCell(table, "Status da Assinatura", pocOcorrencia.getStsAssinatura(), font);
        addCell(table, "Endereço Correspondência", pocOcorrencia.getDesEnderecoCorrespondencia(), font);
        addCell(table, "Endereço Tributação", pocOcorrencia.getDesEnderecoTributacao(), font);
        addCell(table, "Saldo", pocOcorrencia.getValSaldo(), font);
        addCell(table, "Forma de Pagamento", pocOcorrencia.getNomFormaPagamento(), font);

        document.add(new Paragraph("2 – Dados de saída"));
        document.add(table);

        //Close document
        document.close();
    }

    private static Table newTable() {
        Table table = new Table(2);
        table.setWidthPercent(100);
        return table;
    }

    private static void addCell(final Table table, final String label, final String texto, final PdfFont font) {
        String labelFormat = label != null ? label : "";
        String textoFormat = texto != null ? texto : "";
        
        table.addCell(new Cell().add(new Paragraph(labelFormat).setFont(font)));
        table.addCell(new Cell().add(new Paragraph(textoFormat).setFont(font)));
    }

    private static String getDateToString(final Date date) {
        if (date != null) {
            SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
            return dt.format(date);
        }
        return "";
    }

    public static File createTempFile() throws IOException {
        final File tempFile = File.createTempFile("arquivo-temp", ".pdf");
        tempFile.deleteOnExit();
        return tempFile;
    }

}
