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
            Paragraph titlecourse = new Paragraph("Curso: " + course, subTitlehFont);
            titlecourse.setAlignment(Element.ALIGN_CENTER);
            document.add(titlecourse);
            
            //Añado 2 espacios
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            document.add(new Paragraph("Nombre: " + name, paragrathBoldFont));
            document.add(new Paragraph("Apellido: " + lastname, paragrathBoldFont));

            document.add(Chunk.NEWLINE); //Crea una nueva linea en blanco

            Paragraph principalParagraph = new Paragraph(
            "El alumno ha demostrado una excelente participación al presentar el examen de la asignatura. " + 
            "Ha respondido correctamente a todas las preguntas, mostrando un dominio profundo y actualizado " + 
            "de los contenidos teóricos y prácticos. Su capacidad de análisis, síntesis y argumentación ha sido sobresaliente, así como su expresión oral y escrita. " +
            "El examen ha evidenciado las habilidades adquiridas por el alumno a lo largo del curso, tales como la investigación, " + 
            "el pensamiento crítico, la creatividad y la resolución de problemas. El alumno ha sabido aplicar los conocimientos a " + 
            "situaciones reales y complejas, proponiendo soluciones innovadoras y eficaces. Ha demostrado también una actitud positiva," + 
            "colaborativa y responsable ante el aprendizaje. Por todo ello, se le otorga este certificado de participación, que acredita " +
            "su excelente desempeño académico y su amplia competencia en la materia. Se le felicita por su esfuerzo y dedicación, y se le anima a seguir formándose y creciendo profesionalmente..", paragrathFont);
            
            principalParagraph.setAlignment(Element.ALIGN_JUSTIFIED); //Alinear el texto de forma justificada
            document.add(principalParagraph);

            document.add(Chunk.NEWLINE);

            document.add(new Paragraph ("Expedido el día: " + date));

            document.close();
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (DocumentException e){
            System.err.println(e.getMessage());
        }
    }
}
