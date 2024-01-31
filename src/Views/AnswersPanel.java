package Views;

import javax.swing.*;
import java.awt.*;

public class AnswersPanel extends JPanel{

    GridBagConstraints constraints = new GridBagConstraints();
    JTextField option;
    JLabel checkBox;
    JTextArea justification;
    
    AnswersPanel(){

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));

        addOption();
        addIcon();
        addJustification();

    }

    private void addOption(){

        option = new JTextField("Opcion 1");

        option.setBackground(new Color(255,255,255));
        option.setMinimumSize(new Dimension(600,50));
        option.setPreferredSize(new Dimension(600,50));
        option.setEditable(false);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(16, 16, 16, 0);

        option.setBorder(null);
        
        add(option, constraints);

    }

    private void addIcon(){

        checkBox = new JLabel(new ImageIcon("Views/img/solutionsView/answerCheckBox.png"));

        constraints.gridx = 1;
        constraints.weightx = 0.0;
        constraints.insets = new Insets(0, 16, 0, 16);

        add(checkBox, constraints);

    }

    private void addJustification(){

        justification = new JTextArea();
        justification.setText("DJFOAHFLKASFHKJASHFKJLADFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFHFHKLADSFAKSJDFHAKJSDFHKAJSDFHKLJADFHKJASDHFKJLASDFHKLJASDFH");
        justification.setEditable(false);
        justification.setBackground(new Color(216,233,241));
        justification.setLineWrap(true);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        justification.setBorder(null);
        constraints.insets = new Insets(16, 16, 16, 16);
        constraints.fill = GridBagConstraints.BOTH;
        
        JScrollPane justificationScrollPane = new JScrollPane(justification);
        justificationScrollPane.setBorder(null);
        add(justificationScrollPane, constraints);
        
    }
}
