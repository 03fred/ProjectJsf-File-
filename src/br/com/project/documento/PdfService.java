package br.com.project.documento;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class PdfService implements Serializable {

    public void gerarPdf(String document) {

        try {

            try {

                try {
                    Date date = new Date();
                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                    String dataFormatada = formatador.format(date);

                    Document documento = new Document(PageSize.A4, 72, 72, 72, 72);
                    PdfWriter.getInstance(documento, new FileOutputStream("C:\\pdf\\pdfTeste.pdf"));

                    documento.open();

                    Paragraph par0 = new Paragraph();
                    Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);

                    par0.add(new Phrase(document, font));
                    par0.setAlignment(Element.ALIGN_CENTER);
                    par0.add(new Phrase(Chunk.NEWLINE));
                    par0.add(new Phrase(Chunk.NEWLINE));

                    documento.add(par0);


                   

                    documento.close();
                } catch (Exception ex) {
                    ex.getMessage();
                }

            } catch (Exception ex) {
                ex.getMessage();
            }

        } finally {
        }

    }

}
