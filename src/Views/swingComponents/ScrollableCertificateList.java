package Views.swingComponents;
import javax.swing.*;

import java.awt.*;

public class ScrollableCertificateList extends JPanel {
    
    private GridBagConstraints constraints;

    public ScrollableCertificateList(){
        setBackground(new Color(255,255,255));
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
        for (int i = 1; i <= 10; i++) {
            constraints.gridy = i;
            CertificateCourseBox auxiliarQuestionPanel = new CertificateCourseBox("Cursito");

            if(i == 5){
                constraints.weighty = 1.0;
            }
            
            this.add(auxiliarQuestionPanel, constraints);
        }
    }

    
}
