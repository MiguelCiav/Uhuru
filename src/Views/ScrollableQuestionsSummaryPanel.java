package Views;

import javax.swing.*;
import java.awt.*;

public class ScrollableQuestionsSummaryPanel extends JPanel{

    ScrollableQuestionsSummaryPanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(255,255,255));
        setBackground(new Color(255,255,255));
        addQuestionsPanels();
    }
    
    public void addQuestionsPanels(){
        for(int i = 0; i < 5; i++){
            add(new QuestionSummary(i, "AFSFAWFQASFQWFDASFWASFQWFASFWQXFAWFQWSFDASFASFASFRASFAFQFAFWASFQWFASFWQFASFWQQASFWQASFWASFWAFS"));
            add(Box.createRigidArea(new Dimension(0,20)));
        }   
    }

}
