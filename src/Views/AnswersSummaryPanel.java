package Views;

import javax.swing.*;
import java.awt.*;

public class AnswersSummaryPanel extends JPanel{

    AnswersSummaryPanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel answersText = new JLabel("Respuesta");
        answersText.setForeground(new Color(61,90,128));

        constraints.insets = new Insets(0, 30, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;


        add(answersText, constraints);

        constraints.anchor = GridBagConstraints.CENTER;


        constraints.gridy = 0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(new ScrollableQuestionsSummaryPanel(), constraints);

    }
}