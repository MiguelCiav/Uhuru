package views.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.ViewsStyles;

public class SlidingQuestionsPanel extends JPanel implements MouseListener{

    GridBagConstraints constraints = new GridBagConstraints();
    JLabel questionNumber = new JLabel("Pregunta 1");
    JLabel questionSummary = new JLabel();

    public SlidingQuestionsPanel(String summary){
        
        setBackground(ViewsStyles.LIGHT_GRAY);
        questionSummary.setBackground(ViewsStyles.LIGHT_GRAY);
        setLayout(new GridBagLayout());

        addMouseListener(this);

        questionSummary.setText("<html>" + summary + "</html>");

        questionNumber.setFont(new Font("Futura", Font.BOLD, 15));
        questionSummary.setFont(new Font("Futura", Font.PLAIN, 12));
    }

    public void addQuestion(){
        
        constraints.insets = new Insets(5, 30, 5, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        add(questionNumber, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(0, 30, 30, 10);

        add(questionSummary, constraints);
    }

    
    @Override public void mouseClicked(MouseEvent e){
        setBackground(ViewsStyles.LIGHT_SKY_BLUE);
        questionSummary.setBackground(ViewsStyles.LIGHT_SKY_BLUE);
    }

    @Override public void mousePressed(MouseEvent e){}
    @Override public void mouseReleased(MouseEvent e){}
    @Override public void mouseEntered(MouseEvent e){}
    @Override public void mouseExited(MouseEvent e){}
}