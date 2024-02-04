package views.swingComponents;
import javax.swing.*;

import java.awt.*;

public class ScrollableQuestionsPanel extends JPanel {

    private GridBagConstraints constraints;

    public ScrollableQuestionsPanel(){

        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        setBorder(null);
        constraints = new GridBagConstraints();
        addQuestions();

    }

    private void addQuestions(){
 
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(0,20,25,20);

        for (int i = 1; i <= 5; i++) {
            constraints.gridy = i;
            QuestionPanel auxiliarQuestionPanel = new QuestionPanel(i);

            if(i == 5){
                constraints.weighty = 1.0;
            }
            
            this.add(auxiliarQuestionPanel, constraints);
        }
        
    }

}
