package views.swingComponents;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

import utils.ViewsStyles;

public class AnswersSummaryPanel extends JPanelRound{

    GridBagConstraints constraints = new GridBagConstraints();
    JLabel answersTitle;
    ScrollableAnswersPanel answersPanel = new ScrollableAnswersPanel();
    
    public AnswersSummaryPanel(){

        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);
        addAnswerTitle();
        addAnswerPanel();

    }

    private void addAnswerTitle(){

        answersTitle = new JLabel("Respuestas");

        answersTitle.setFont(new Font("Futura", Font.BOLD, 32));
        answersTitle.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(16, 20, 16, 0);
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
        constraints.insets = new Insets(0, 0, 0, 0);

        add(answersPanel, constraints);

    }
    
}