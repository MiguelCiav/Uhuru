package Views;
import javax.swing.*;

import java.awt.*;

public class QuestionPanel extends JPanelRound{

    GridBagConstraints constraints;
    private String questionNumber;

    QuestionPanel (int questionNumber){

        this.questionNumber = String.valueOf(questionNumber);
        constraints = new GridBagConstraints();

        setRoundBackgroundColor(new Color(216,233,241));
        setLayout(new GridBagLayout());
        setBorder(null);
        
        addQuestionNumber();
        addQuestionDomain();
        addQuestionDescription();
        addOptionBox(4);

    }


    private void addQuestionNumber(){

        JLabel questionNumberLabel = new JLabel();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,20,10,10);

        questionNumberLabel.setFont(new Font("Futura", Font.BOLD, 30));
        questionNumberLabel.setForeground(new Color(61,90,128));
        questionNumberLabel.setText(questionNumber);
        add(questionNumberLabel, constraints);

    }

    private void addQuestionDomain(){

        JLabel questionDomain = new JLabel();

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        questionDomain.setFont(new Font("Futura", Font.BOLD, 24));
        questionDomain.setForeground(new Color(0,0,0));
        questionDomain.setText("Dominio: xxxxxxxxx");

        add(questionDomain, constraints);

    }

    private void addQuestionDescription(){

        JTextArea questionDescription = new JTextArea();

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.insets= new Insets(0,0,10,20);

        questionDescription.setLineWrap(true);
        questionDescription.setWrapStyleWord(true);
        questionDescription.setFont(new Font("Futura", Font.ITALIC, 16));
        questionDescription.setForeground(new Color(0,0,0));
        questionDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at elit eget dui gravida suscipit. Mauris et ipsum id felis venenatis consectetur. Etiam ac nibh sit amet quam aliquam sodales vel sed quam.");
        questionDescription.setBackground(new Color(216,233,241));

        add(questionDescription, constraints);

    }
    
    private void addOptionBox(int numberOptions){

        constraints = new GridBagConstraints();
        
        for (int i=1 ; i<=numberOptions; i++){
            
            constraints.gridx = 1;
            constraints.gridy = 1+i;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets= new Insets(5,10,5,20);
            add(new OptionBox(),constraints);

        }

    }

}
