package main.views.components;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

public class ScrollableAnswersPanel extends JPanel{

    GridBagConstraints constraints;
    CorrectAnswerPanel answersPanel;
    JLabel questionDescription;

    public ScrollableAnswersPanel(){

        constraints = new GridBagConstraints();
        answersPanel = new CorrectAnswerPanel();
        questionDescription = new JLabel();

        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        addQuestionDescription();
        addAnswerPanel();

    }

    private void addQuestionDescription(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0,20,16,20);

        questionDescription.setBackground(ViewsStyles.LIGHT_GRAY);
        questionDescription.setBorder(null);
        questionDescription.setText("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quis odio vitae velit pretium ultrices. Nam ut velit ac dui elementum pharetra. Morbi id egestas ex. Proin ac iaculis orci, at viverra ex. Vestibulum eget feugiat ligula, et ultrices purus. Aliquam dignissim ligula nibh, sed gravida mi mollis eget. Morbi.</html>");

        add(questionDescription, constraints);

    }

    private void addAnswerPanel(){

        constraints.gridy = 1;    
        constraints.weighty = 1.0;
        constraints.insets = new Insets(0,20,20,20);
        constraints.fill = GridBagConstraints.BOTH;
        
        add(answersPanel, constraints);

    }
}
