package views.swingComponents;
import javax.swing.*;

import controllers.GenerateCertificateController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.ViewsStyles;

public class CertificateCourseBox extends JPanel implements ActionListener{
    JTextArea courseTitle = new JTextArea ();
    BlueButton generateCertificateButton;
    JPanelRound courseTitlePanel = new JPanelRound();
    GridBagConstraints constraints = new GridBagConstraints();

    public CertificateCourseBox(String Title){
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(null);
        generateCertificateButton = new BlueButton("Generar Certificado", 250, 3);
        addCourseTitle(Title);
        addGenerateCertificateButton();
    }

    private void addCourseTitle(String Title){
        courseTitle.setFont(new Font("Futura", Font.BOLD, 16));
        courseTitle.setForeground(Color.BLACK);
        courseTitle.setText(Title);
        courseTitle.setEditable (false); 
        courseTitle.setLineWrap(true);
        courseTitle.setWrapStyleWord(true);
        courseTitle.setBackground(ViewsStyles.ULTRA_LIGHT_BLUE);
        
        courseTitlePanel.setLayout(new GridBagLayout());
        courseTitlePanel.setRoundBackgroundColor(ViewsStyles.ULTRA_LIGHT_BLUE);
        courseTitlePanel.setPreferredSize(new Dimension(400,60));

        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets= new Insets(20,20,20,10);
        constraints.weightx = 1;
        courseTitlePanel.add(courseTitle, constraints);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        
        constraints.insets= new Insets(5,10,5,10);

        add(courseTitlePanel, constraints);

    }
    
    private void addGenerateCertificateButton (){

        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(10,10,10,10);

        generateCertificateButton.addActionListener(this);

        add(generateCertificateButton, constraints);

        //llamar al controlador para obtener el certificado
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Si escucha manín");
        GenerateCertificateController.generatePDF(courseTitle.getText());
    }
}