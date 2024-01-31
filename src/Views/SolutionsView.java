package Views;

import javax.swing.*;
import java.awt.*;

public class SolutionsView extends JFrame{

    PrincipalPanel solutionsViewPanel = new PrincipalPanel();
    JPanel containerPanel = new JPanel();
    QuestionsSummaryPanel questionsPanel = new QuestionsSummaryPanel();
    AnswersSummaryPanel answersPanel = new AnswersSummaryPanel();

    SolutionsView(){
        super("Uhuru");
        setSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        addContainerPanel();
    }

    private void addContainerPanel(){

        GridBagConstraints constraints = new GridBagConstraints();

        containerPanel.setBackground(new Color(61,90,128));
        containerPanel.setLayout(new GridBagLayout());

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.4;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;

        containerPanel.add(questionsPanel, constraints);

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.weightx = 0.6;
        constraints.gridx = 1;

        containerPanel.add(answersPanel, constraints);
        solutionsViewPanel.setContentPanel(containerPanel);
        add(solutionsViewPanel);

        setVisible(true);
    }
}