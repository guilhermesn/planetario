/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetario;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.jfree.chart.JFreeChart;

public class PDF {

    private String texto;

    public void setTexto(String ptexto) {
        this.texto = ptexto;
    }

    public void setImage(String ptexto) {
        this.texto = ptexto;
    }

    public void setGrafico(String ptexto) {
        this.texto = ptexto;
    }

    public void criarPDF(String camilho, ArrayList dados) throws Exception {
        Document doc = null;
        OutputStream os = null;

        try {
            //cria o documento tamanho A4, margens de 2,54cm
            doc = new Document(PageSize.A4, 72, 72, 72, 72);

            //cria a stream de saída
            os = new FileOutputStream(camilho);

            //associa a stream de saída ao 
            PdfWriter.getInstance(doc, os);

            //abre o documento
            doc.open();

            for (Object obj : dados) {
                if (obj instanceof String) {
                    Paragraph p = new Paragraph((String) obj);
                    doc.add(p);
                } else if (obj instanceof JFreeChart) {
                    JFreeChart grafico = (JFreeChart) obj;
                    BufferedImage bufferedImage = grafico.createBufferedImage(400, 300);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "png", baos);
                    Image iTextImage = Image.getInstance(baos.toByteArray());
                    doc.add(iTextImage);
                }
            }

            //adiciona o texto ao PDF
           /* Paragraph p = new Paragraph("");
             doc.add(p);
            
             doc.add(p);
             Image img1 = Image.getInstance("As_galáxias-2.jpg");
             img1.scaleAbsolute(50f, 50f);
             doc.add(img1);
             Image img2 = Image.getInstance("As_galáxias-2.jpg");
             img2.scaleToFit(100f, 100f);
             doc.add(img2);*/
        } finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
                //fechamento da stream de saída
                os.close();
            }
        }
    }
}
