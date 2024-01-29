package Views;

import javax.swing.*;
import java.awt.*;

public class SolutionsView extends JFrame{

    PrincipalPanel solutionsViewPanel = new PrincipalPanel();
    JPanel miniPanel = new JPanel();
    QuestionsSummaryPanel questionsPanel = new QuestionsSummaryPanel();
    AnswersSummaryPanel answersPanel = new AnswersSummaryPanel();

    SolutionsView(){
        super("Uhuru");
        setSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        miniPanel.setBackground(new Color(61,90,128));
        miniPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.8;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;

        miniPanel.add(questionsPanel, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.weightx = 1.0;
        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;

        miniPanel.add(answersPanel, constraints);

        solutionsViewPanel.setContentPanel(miniPanel);

        add(solutionsViewPanel);

        setVisible(true);
    }
}