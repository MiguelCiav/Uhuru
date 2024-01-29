package Views;
import javax.swing.*;
import java.awt.*;

public class ScrollableQuestionsPanel extends JPanel {

    ScrollableQuestionsPanel (){
        setBackground(new Color(255,255,255));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initializePanel();
    }

    private void initializePanel(){
        QuestionPanel panel = new QuestionPanel();
        add(panel);
        /*for (int i = 0; i < 10; i++) {
            QuestionPanel panel = new QuestionPanel();
            panel.setBackground(new Color(152 - i, 193, 217)); // Varying colors for visual distinction
            panel.questionNumber.setText("hola" + i);
            this.add(panel);
        }*/
    }
}
