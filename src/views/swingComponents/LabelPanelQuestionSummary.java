package views.swingComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utils.ViewsStyles;

public class LabelPanelQuestionSummary extends LabelPanel{

    private int questionID;
    private String questionDescription;
    private JTextArea questionDescriptionText;

    public LabelPanelQuestionSummary(String questionDescription, int questionID){

        constraints = new GridBagConstraints();
        this.questionDescription = questionDescription;
        this.questionID = questionID;

        setLayout(new GridBagLayout());
        setBackground(ViewsStyles.LIGHT_GRAY);

        setLabel();
        addLabel();
        
    }

    @Override
    protected void setLabel() {

        questionDescriptionText = new JTextArea();

<<<<<<< HEAD:src/views/swingComponents/LabelPanelWithTitle.java
        questionSummary.setBackground(ViewsStyles.LIGHT_GRAY);
        questionSummary.setFont(new Font("Futura", Font.PLAIN, 12));
        questionSummary.setEditable(false);
        questionSummary.setFocusable(false);
        questionSummary.setLineWrap(true);
        questionSummary.setText(text);
=======
        questionDescriptionText.setBackground(new Color(216,233,241));
        questionDescriptionText.setFont(new Font("Futura", Font.PLAIN, 12));
        questionDescriptionText.setEditable(false);
        questionDescriptionText.setFocusable(false);
        questionDescriptionText.setLineWrap(true);
        questionDescriptionText.setText(questionDescription);
>>>>>>> answerTestController:src/views/swingComponents/LabelPanelQuestionSummary.java

    }

    @Override
    protected void addLabel() {

        JLabel questionTitle = new JLabel("Pregunta " + questionID);
        questionTitle.setFont(ViewsStyles.SMALL_TITLE_FONT);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(16, 16, 8, 16);

        add(questionTitle, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(0, 16, 16, 16);

        JScrollPane auxiliarPane = new JBlueScrollPane(questionDescriptionText);
        auxiliarPane.setBorder(null);
        auxiliarPane.setMinimumSize(new Dimension(250,40));
        auxiliarPane.setPreferredSize(new Dimension(250, 40));
        
        auxiliarPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        auxiliarPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(auxiliarPane, constraints);
        
    }
    
}
