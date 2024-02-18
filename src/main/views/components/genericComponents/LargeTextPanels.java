package main.views.components.genericComponents;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

public class LargeTextPanels extends JPanelRound{
    
    JScrollPane textScrollPane;
    public JTextArea textArea;
    GridBagConstraints constraints = new GridBagConstraints();

    public LargeTextPanels(String text, Color c){
        setRoundBackgroundColor(c);
        setLayout(new GridBagLayout());
        textArea = new JTextArea();

        textArea.setText(text);
        textArea.setBorder(null);
        textArea.setBackground(c);
        textArea.setLineWrap(true);
        textArea.setFont(ViewsStyles.TEXT_FONT);

        textScrollPane = new JScrollPane(textArea);
        
        textScrollPane.setBorder(null);
        textScrollPane.setLayout(new ScrollPaneLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(10, 15, 15, 15);

        add(textScrollPane, constraints);

    }

    public String getText(){
        return textArea.getText();
    }

    public void setText(String input){
        textArea.setText(input);
    }
}
