package Views;
import javax.swing.*;
import java.awt.*;

public class OptionBox extends JPanel{
    JTextArea optionText = new JTextArea ();
    JCheckBox optionBox = new JCheckBox(" ");

    OptionBox   (){
        setBackground(new Color(152, 193, 217));
        setLayout(new GridBagLayout());
        setBorder(null);

        //check
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,10,10,10);
        
        add(optionBox, constraints);

        //text
        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        optionText.setFont(new Font("Futura", Font.ITALIC, 16));
        optionText.setForeground(new Color(0,0,0));
        optionText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at elit eget dui gravida suscipit. Mauris et ipsum id felis venenatis consectetur. Etiam ac nibh sit amet quam aliquam sodales vel sed quam.");
        optionText.setEditable (false); 
        optionText.setLineWrap(true);
        optionText.setWrapStyleWord(true);


        add(optionText, constraints);
    }
}
