package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollableQuestionsSummaryPanel extends JPanel{

    private GridBagConstraints constraints;

    ScrollableQuestionsSummaryPanel(){

        setLayout(new GridBagLayout());

        setBackground(new Color(255,255,255));
        setBackground(new Color(255,255,255));
        addQuestionsPanels();
    }
    
    public void addQuestionsPanels(){

        constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 0, 10, 0);

        for(int i = 0; i < 5; i++){
            constraints.gridy = i;
            add(new QuestionSummary(i, "Hola"), constraints);
        }   
    }
}
