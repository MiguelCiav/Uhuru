package Controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

public class GenerateCertificate {
    String name;
    String lastname;
    String date;
    String course;

    Document document;
    FileOutputStream file;
    Paragraph title;
    private static final BaseColor blue = new BaseColor(61, 90, 128); //Hexa: 3D5A80
    private static final BaseColor cyan = new BaseColor(152, 193, 217); //Hexa: 98C1D9
    //Tipos de fuentes a usar
    private static final Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 25, Font.BOLDITALIC, blue);
    private static final Font subTitlehFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
    private static final Font paragrathFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static final Font paragrathBoldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final String pathImage = "src\\Controller\\img\\iconDark.png";
    
    public GenerateCertificate(String inputname, String inputlastname, String inputdate, String inputcourse){
        name = inputname;
        lastname = inputlastname;
        date = inputdate;
        course = inputcourse;

        document = new Document(PageSize.LETTER.rotate());
        title = new Paragraph("Certificado de Participación", titleFont);
    }

    public void newPDF(){
        try {
            file = new FileOutputStream ("Certificado " + course + " "+ name + " " + lastname + ".pdf");
            PdfWriter.getInstance(document, file);
            document.open();
            title.setAlignment(1); //centrado

            document.add(title);
            
            Image image;
            try {
                image = Image.getInstance(pathImage);
                image.setAbsolutePosition(50, 520);
                document.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            Paragraph titlecourse = new Paragraph("course: " + course, subTitlehFont);
            titlecourse.setAlignment(Element.ALIGN_CENTER);
            document.add(titlecourse);
            
            //Añado 2 espacios
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("name: " + name, paragrathBoldFont));
            document.add(new Paragraph("lastname: " + lastname, paragrathBoldFont));

            document.add(Chunk.NEWLINE); //Crea una nueva linea en blanco

            Paragraph principalParagraph = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit." 
                + "Vivamus euismod massa non metus lacinia egestas eget nec purus. In molestie," 
                + "nisi id pretium malesuada, nisi metus vestibulum diam, et auctor purus velit" 
                + "vel ante. Pellentesque tempor ante nec orci feugiat, et tempus nisi pharetra." 
                + "Duis congue purus sit amet eros venenatis suscipit. Fusce nibh enim, tincidunt" 
                + "eget blandit in, vulputate ut sem. Proin a nisl eget arcu elementum laoreet."
                + "Morbi id consequat sem. Vivamus eget libero justo.", paragrathFont);
            
            principalParagraph.setAlignment(Element.ALIGN_JUSTIFIED); //Alinear el texto de forma justificada
            document.add(principalParagraph);

            document.add(Chunk.NEWLINE);

            document.add(new Paragraph ("date: " + date));

            document.close();
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (DocumentException e){
            System.err.println(e.getMessage());
        }
    }
}
