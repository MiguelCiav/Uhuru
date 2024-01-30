package Views;
import javax.swing.*;
import java.awt.*;

public class ScrollableQuestionsPanel extends JPanel {

    ScrollableQuestionsPanel (){
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        setBorder(null);
        initializePanel();
    }

    private void initializePanel(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(0,20,25,20);

        QuestionPanel panel = new QuestionPanel();
        add(panel, constraints);

        
        for (int i = 1; i <= 5; i++) {
            constraints.gridy = i;
            QuestionPanel panel2 = new QuestionPanel();
            panel2.questionNumber.setText(""+ i);
            this.add(panel2, constraints);
        }
    }
}
