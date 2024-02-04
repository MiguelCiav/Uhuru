package views.swingComponents;

import javax.swing.*;
import java.awt.*;

public class CorrectAnswerPanel extends JPanelRound{

    GridBagConstraints constraints = new GridBagConstraints();
    JTextArea option;
    JLabel checkBox;
    JTextArea justification;
    
    public CorrectAnswerPanel(){

        setLayout(new GridBagLayout());
        setRoundBackgroundColor(new Color(216,233,241));
        addIcon();
        addOptionDescription();
        addJustification();   
        
    }

    private void addIcon(){

        checkBox = new JLabel(new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/solutionsView/answerCheckBox.png"))));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(checkBox, constraints);

    }
    
    private void addOptionDescription(){

        option = new JTextArea("");
        option.setBackground(new Color(255,255,255));
        option.setLineWrap(true);
        option.setEditable(false);
        option.setBorder(null);
        option.setFocusable(false);

        constraints.gridx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(16, 0, 16, 16);

        JBlueScrollPane auxiliarPanel = new JBlueScrollPane(option);
        auxiliarPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        auxiliarPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(auxiliarPanel, constraints);

    }

    private void addJustification(){

        justification = new JTextArea();
        justification.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quis odio vitae velit pretium ultrices. Nam ut velit ac dui elementum pharetra. Morbi id egestas ex. Proin ac iaculis orci, at viverra ex. Vestibulum eget feugiat ligula, et ultrices purus. Aliquam dignissim ligula nibh, sed gravida mi mollis eget. Morbi.");
        justification.setEditable(false);
        justification.setBackground(new Color(216,233,241));
        justification.setLineWrap(true);

        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(0, 16, 16, 16);

        justification.setBorder(null);
        JScrollPane justificationScrollPane = new JBlueScrollPane(justification);
        justificationScrollPane.setBorder(null);
        add(justificationScrollPane, constraints);
        
    }
}
