package Views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ScrollableQuestionsSummaryPanel extends JScrollPane{
 
    JPanel scrollPanel = new JPanel();

    ScrollableQuestionsSummaryPanel(){

        scrollPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        setBorder(null);

        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 0, 10, 10);

        for(int i = 0; i < 20; i++){
            constraints.gridy = i;
            scrollPanel.add(new SlidingQuestionsPanel(), constraints);
        }
        setViewportView(scrollPanel);
    }
}
