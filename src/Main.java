import Views.useCaseFrames.TestListView;
import Controller.generateCertificate;

public class Main {
    public static void main (String args[]){
        new TestListView();
        generateCertificate PDF = new generateCertificate("Pablo", "Perez", "Enero 2024", "Java");
        PDF.newPDF();
    }

}