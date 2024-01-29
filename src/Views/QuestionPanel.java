package Views;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class QuestionPanel extends JPanel{
    JLabel questionNumber = new JLabel();
    JLabel questionDomain = new JLabel();
    JLabel questionDescription = new JLabel();
    JTextField optionText = new JTextField ();
    JCheckBox optionBox = new JCheckBox();

    QuestionPanel (){
        setBackground(new Color(152, 193, 217));
        setLayout(new GridBagLayout());
        setBorder(null);
        //numero
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,10,10,10);

        questionNumber.setFont(new Font("Futura", Font.BOLD, 30));
        questionNumber.setForeground(new Color(61,90,128));
        questionNumber.setText("1");
        add(questionNumber, constraints);
        
        //dominio
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;

        questionDomain.setFont(new Font("Futura", Font.BOLD, 24));
        questionDomain.setForeground(new Color(0,0,0));
        questionDomain.setText("Dominio: xxxxxxxxx");
        add(questionDomain, constraints);

        //pregunta
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;

        questionDescription.setFont(new Font("Futura", Font.ITALIC, 16));
        questionDescription.setForeground(new Color(0,0,0));
        questionDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at elit eget dui gravida suscipit. Mauris et ipsum id felis venenatis consectetur. Etiam ac nibh sit amet quam aliquam sodales vel sed quam.");
        add(questionDescription, constraints);

    }

}
