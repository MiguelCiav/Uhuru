package Views;

import javax.swing.*;
import java.awt.*;

public class ScrollableAnswersPanel extends JPanel{

    GridBagConstraints constraints;
    AnswersPanel answersPanel;
    JLabel questionDescription;

    ScrollableAnswersPanel(){

        constraints = new GridBagConstraints();
        answersPanel = new AnswersPanel();
        questionDescription = new JLabel();

        setLayout(new GridBagLayout());
        setBackground(new Color(255,255,255));

        addQuestionDescription();
        addAnswerPanel();

    }

    private void addQuestionDescription(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0,16,16,16);

        questionDescription.setBackground(new Color(216,233,241));
        questionDescription.setBorder(null);
        questionDescription.setText("<html> JASFLKASJFASKJFLA LKFAJFASKFLJQOWI HNASFNHA HFNOIAN SFNHQO IHOAISHNF O OAJFOIAJSFOIA JSOIFJAOIFJ AOISFJOJ ASFIOA SJFOIAJS FOIAJS FOIAJSF OIJASFOIJOSIF JSOIFJ AOSFJ OISJA FOAJSFIOAFSJOIAFSJOIASFJOAISJF OIASJF OIAJS OFIAJSF OIAJS FOASJIF AJOFIJMASIOFJAIO AOISFJAOISFJAOISFJOI ASJOIFAOIFSJ O</html>");

        add(questionDescription, constraints);

    }

    private void addAnswerPanel(){

        constraints.gridy = 1;    
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        
        add(answersPanel, constraints);

    }
}
