package views.swingComponents;
import javax.swing.*;

import java.awt.*;


public class QuestionsListPanel extends JPanelRound{

    private GridBagConstraints constraints;
    private ScrollableQuestionsPanel scroll;
    private JScrollPane scrollPanel;

    public QuestionsListPanel(){

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        
        constraints = new GridBagConstraints();

        addTestInfoPanel();
        setScrollableQuestionsPanel();
        addScrollablePanel();

    }

    private void addTestInfoPanel(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(10,0,10,10);

        add(TestInfoPanel.getTestInfoPanel(), constraints);
    }

    private void setScrollableQuestionsPanel(){

        scroll = new ScrollableQuestionsPanel();
        scrollPanel = new JBlueScrollPane(scroll);

    }

    private void addScrollablePanel(){

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets= new Insets(20,20,20,20);
        
        add(scrollPanel, constraints);

    }
    
}
