package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelSummary extends JPanel implements MouseListener{

    static final int QUESTION_SUMMARY = 0;
    static final int COURSE_SUMMARY = 1;
    
    int questionNumber;
    String questionSummary;
    JTextArea questionSummaryLabel = new JTextArea();
    JLabel testLabel = new JLabel();
    GridBagConstraints constraints = new GridBagConstraints();

    LabelSummary(int questionNumber, String questionSummary){
        
        this.questionNumber = questionNumber;
        this.questionSummary = questionSummary;

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));
        addMouseListener(this);

        setQuestionSummaryLabel();
        addQuestionSummaryLabel();

    }

    LabelSummary(String testTitle){

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));

        setTestLabel();
        addTestLabel();

    }

    private void setTestLabel(){

        testLabel.setBackground(new Color(216,233,241));
        testLabel.setOpaque(true);
        testLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        testLabel.setFocusable(false);
        testLabel.setText("TEST");

    }

    private void addTestLabel(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(16, 16, 16, 16);

        JScrollPane auxiliarPane = new JScrollPane(testLabel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        auxiliarPane.setBorder(null);

        add(auxiliarPane, constraints);

    }

    private void setQuestionSummaryLabel(){

        questionSummaryLabel.setBackground(new Color(216,233,241));
        questionSummaryLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        questionSummaryLabel.setEditable(false);
        questionSummaryLabel.setFocusable(false);
        questionSummaryLabel.setLineWrap(true);
        questionSummaryLabel.setText("AGUACATE CON GUACHAFITA ASFOJAOIFSJAOIFSJASIFOJAIOFJAOISFJASIOFJAOISFJAOISFASIFOJ");

    }
    
    private void addQuestionSummaryLabel(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(16, 16, 16, 16);

        JScrollPane auxiliarPane = new JScrollPane(questionSummaryLabel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        auxiliarPane.setBorder(null);
        auxiliarPane.setPreferredSize(new Dimension(176,60));

        add(auxiliarPane, constraints);

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