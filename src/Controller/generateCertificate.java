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

public class generateCertificate {
    String nombre;
    String apellido;
    String fecha;
    String curso;

    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;
    private static final BaseColor azulOscuro = new BaseColor(61, 90, 128); //Hexa: 3D5A80
    private static final BaseColor azulClaro = new BaseColor(152, 193, 217); //Hexa: 98C1D9
    //Tipos de fuentes a usar
    private static final Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 25, Font.BOLDITALIC, azulOscuro);
    private static final Font subTitlehFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
    private static final Font paragrathFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    private static final Font paragrathBoldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private static final String rutaImagen = "src\\Controller\\img\\iconDark.png";
    public generateCertificate(String name, String lastname, String date, String course){
        nombre = name;
        apellido = lastname;
        fecha = date;
        curso = course;

        documento = new Document(PageSize.LETTER.rotate());
        titulo = new Paragraph("Certificado de Participación", titleFont);
    }

    public void newPDF(){
        try {
            archivo = new FileOutputStream ("Certificado " + curso + " "+ nombre + " " + apellido + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            titulo.setAlignment(1); //centrado

            documento.add(titulo);
            
            Image image;
            try {
                image = Image.getInstance(rutaImagen);
                image.setAbsolutePosition(50, 520);
                documento.add(image);
            } catch (BadElementException ex) {
                System.out.println("Image BadElementException" +  ex);
            } catch (IOException ex) {
                System.out.println("Image IOException " +  ex);
            }
            Paragraph tituloCurso = new Paragraph("Curso: " + curso, subTitlehFont);
            tituloCurso.setAlignment(Element.ALIGN_CENTER);
            documento.add(tituloCurso);
            
            //Añado 2 espacios
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);

            documento.add(new Paragraph("Nombre: " + nombre, paragrathBoldFont));
            documento.add(new Paragraph("Apellido: " + apellido, paragrathBoldFont));

            documento.add(Chunk.NEWLINE); //Crea una nueva linea en blanco

            Paragraph texto1 = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit." 
                + "Vivamus euismod massa non metus lacinia egestas eget nec purus. In molestie," 
                + "nisi id pretium malesuada, nisi metus vestibulum diam, et auctor purus velit" 
                + "vel ante. Pellentesque tempor ante nec orci feugiat, et tempus nisi pharetra." 
                + "Duis congue purus sit amet eros venenatis suscipit. Fusce nibh enim, tincidunt" 
                + "eget blandit in, vulputate ut sem. Proin a nisl eget arcu elementum laoreet."
                + "Morbi id consequat sem. Vivamus eget libero justo.", paragrathFont);
            
            texto1.setAlignment(Element.ALIGN_JUSTIFIED); //Alinear el texto de forma justificada
            documento.add(texto1);

            documento.add(Chunk.NEWLINE);

            documento.add(new Paragraph ("Fecha: " + fecha));

            documento.close();
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        } catch (DocumentException e){
            System.err.println(e.getMessage());
        }
    }
}
