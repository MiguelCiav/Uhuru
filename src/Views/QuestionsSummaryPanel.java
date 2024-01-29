package Views;

import javax.swing.*;
import java.awt.*;

public class QuestionsSummaryPanel extends JPanel{

    JLabel questionsText = new JLabel("Preguntas");

    QuestionsSummaryPanel(){
        
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        questionsText.setFont(new Font("Futura", Font.BOLD, 32));
        questionsText.setForeground(new Color(61,90,128));

        constraints.insets = new Insets(0, 30, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.WEST;

        add(questionsText, constraints);

        constraints.anchor = GridBagConstraints.CENTER;

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(new ScrollableQuestionsSummaryPanel(), constraints);

    }
}
