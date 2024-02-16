package main.views.components.solutionsViewComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.views.components.genericComponents.JBlueScrollPane;
import main.views.components.genericComponents.LabelPanel;
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

        questionDescriptionText.setBackground(new Color(216,233,241));
        questionDescriptionText.setFont(new Font("Futura", Font.PLAIN, 12));
        questionDescriptionText.setEditable(false);
        questionDescriptionText.setFocusable(false);
        questionDescriptionText.setLineWrap(true);
        questionDescriptionText.setText(questionDescription);

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
