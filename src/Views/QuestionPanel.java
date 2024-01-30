package Views;
import javax.swing.*;

import java.awt.*;

public class QuestionPanel extends JPanel{
    JLabel questionNumber = new JLabel();
    JLabel questionDomain = new JLabel();
    JTextArea questionDescription = new JTextArea();
    

    QuestionPanel (){
        setBackground(new Color(216,233,241));
        setLayout(new GridBagLayout());
        setBorder(null);
        
        //numero
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,20,10,10);

        questionNumber.setFont(new Font("Futura", Font.BOLD, 30));
        questionNumber.setForeground(new Color(61,90,128));
        questionNumber.setText("1");
        add(questionNumber, constraints);
        
        //dominio
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        questionDomain.setFont(new Font("Futura", Font.BOLD, 24));
        questionDomain.setForeground(new Color(0,0,0));
        questionDomain.setText("Dominio: xxxxxxxxx");
        add(questionDomain, constraints);

        //pregunta
        constraints.gridx = 1;
        constraints.gridy = 1;

        questionDescription.setFont(new Font("Futura", Font.ITALIC, 16));
        questionDescription.setForeground(new Color(0,0,0));
        questionDescription.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at elit eget dui gravida suscipit. Mauris et ipsum id felis venenatis consectetur. Etiam ac nibh sit amet quam aliquam sodales vel sed quam.");
        questionDescription.setEditable (false); 
        questionDescription.setLineWrap(true);
        questionDescription.setWrapStyleWord(true);
        questionDescription.setMinimumSize(new Dimension(200,400));
        questionDescription.setBackground(new Color(216,233,241));

        add(questionDescription, constraints);

        //cajas
        addOptionBox(4);

    }
    
    private void addOptionBox(int numberOptions){
        GridBagConstraints constraints = new GridBagConstraints();
        for (int i=1 ; i<=numberOptions; i++){
            constraints.gridx = 1;
            constraints.gridy = 1+i;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets= new Insets(10,10,5,20);
            add(new OptionBox(),constraints);
        }
    }
}
