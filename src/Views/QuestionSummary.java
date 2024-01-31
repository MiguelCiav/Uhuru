package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionSummary extends JPanel implements MouseListener{

    int questionNumber;
    String questionSummary;
    JLabel questionSummaryLabel = new JLabel();

    QuestionSummary(int questionNumber, String questionSummary){
        
        this.questionNumber = questionNumber;
        this.questionSummary = questionSummary;

        setBackground(new Color(216,233,241));
        questionSummaryLabel.setBackground(new Color(216,233,241));
        addMouseListener(this);
        questionSummaryLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        questionSummaryLabel.setHorizontalAlignment(JLabel.LEFT);

        setQuestionText();

    }

    private void setQuestionText(){
        
        questionSummaryLabel.setText("<html>" + "<strong>" + "Pregunta " + String.valueOf(questionNumber) + "</strong>"
        + "<br>" + questionSummary + "</html>");
        
        add(questionSummaryLabel);

    }
    
    @Override public void mouseClicked(MouseEvent e){
        setBackground(new Color(143, 179, 227));
        questionSummaryLabel.setBackground(new Color(143, 179, 227));
    }

    @Override public void mousePressed(MouseEvent e){}
    @Override public void mouseReleased(MouseEvent e){}
    @Override public void mouseEntered(MouseEvent e){}
    @Override public void mouseExited(MouseEvent e){}
}