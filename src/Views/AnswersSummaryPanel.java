package Views;

import javax.swing.*;
import java.awt.*;

public class AnswersSummaryPanel extends JPanel{

    GridBagConstraints constraints = new GridBagConstraints();
    JLabel answersTitle = new JLabel("Respuestas");
    ScrollableAnswersPanel answersPanel = new ScrollableAnswersPanel();
    
    AnswersSummaryPanel(){

        setLayout(new GridBagLayout());
        setBackground(new Color(255,255,255));

        addAnswerTitle();
        addAnswerPanel();

    }

    private void addAnswerTitle(){

        answersTitle.setFont(new Font("Futura", Font.BOLD, 32));
        answersTitle.setForeground(new Color(61,90,128));

        constraints.insets = new Insets(16, 16, 16, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;

        add(answersTitle, constraints);

    }

    private void addAnswerPanel(){

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 16, 16, 16);

        add(answersPanel, constraints);

    }
}