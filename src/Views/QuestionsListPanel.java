package Views;
import javax.swing.*;
import java.awt.*;

public class QuestionsListPanel extends JPanel{

    QuestionsListPanel(){
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(0,0,10,0);

        add(new TestInfoPanel(), constraints);

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets= new Insets(20,20,20,20);

        ScrollableQuestionsPanel scroll = new ScrollableQuestionsPanel ();
        JScrollPane scrollPanel = new JScrollPane(scroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBorder(null);
        add(scrollPanel, constraints);
        
    }
    
}

