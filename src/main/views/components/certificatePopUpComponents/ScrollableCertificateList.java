package main.views.components.certificatePopUpComponents;
import javax.swing.*;

import main.controllers.GenerateCertificateController;
import main.models.Course;
import main.models.User;
import main.views.components.genericComponents.JPanelRound;

import java.awt.*;

public class ScrollableCertificateList extends JPanel {
    
    private GridBagConstraints constraints;

    public ScrollableCertificateList(){
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(null);
        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(0,20,10,30);

        //Añadir el controlador de certificado(Pedir ID aprobado de user y recorrer en el if)
        GenerateCertificateController controller = GenerateCertificateController.getInstace();
        Course []course = GenerateCertificateController.getUserCourseList();
        
        for (int i = 1; i <= User.getUserInstance().getCoursesCount(); i++) {
            constraints.gridy = i;
            
            String courseName = course[i-1].getCourseName();

            CertificateCourseBox auxiliarQuestionPanel = new CertificateCourseBox(courseName);

            if(i == 5){
                constraints.weighty = 1.0;
            }
            
            this.add(auxiliarQuestionPanel, constraints);
        }
    }

    
}
