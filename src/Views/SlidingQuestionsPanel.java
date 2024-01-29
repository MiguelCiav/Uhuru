package Views;

import javax.swing.*;
import java.awt.*;

public class SlidingQuestionsPanel extends JPanel{

    JLabel questionNumber = new JLabel("Pregunta 1");
    JLabel questionSummary = new JLabel("Soy un resumen");

    SlidingQuestionsPanel(){
        setBackground(new Color(152,193,217));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        questionNumber.setFont(new Font("Futura", Font.BOLD, 15));
        questionSummary.setFont(new Font("Futura", Font.PLAIN, 12));
        
        constraints.insets = new Insets(5, 30, 5, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        add(questionNumber, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(0, 30, 30, 10);

        add(questionSummary, constraints);

    }
}