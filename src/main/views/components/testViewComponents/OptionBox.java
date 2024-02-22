package main.views.components.testViewComponents;
import javax.swing.*;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.JPanelRound;
import utils.PathManager;
import utils.ViewsStyles;

import java.awt.*;

public class OptionBox extends JPanelRound{

    String questionID;
    String answerID;
    JTextArea optionText = new JTextArea ();
    JRadioButton optionButton = new JRadioButton();
    JPanelRound optionTextPanel = new JPanelRound();
    GridBagConstraints constraints = new GridBagConstraints();

    public OptionBox (String questionID, String answerID){

        this.questionID = questionID;
        this.answerID = answerID;

        setBackground(ViewsStyles.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        setBorder(null);

        addOptionButton();
        addOptionText();
        
    }

    public boolean isSelected(){
        return optionButton.isSelected();
    }

    public void setSelected(boolean selected){
        optionButton.setSelected(selected);
    }

    public String getQuestionID(){
        return questionID;
    }

    public String getAnswerID(){
        return answerID;
    }

    private void addOptionButton(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,10,10,10);
        
        optionButton.setBackground(ViewsStyles.LIGHT_GRAY);
        optionButton.setSelected(true);
        optionButton.setBorder(null);
        optionButton.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/OptionBox/sin pulsar.png")));
        optionButton.setSelectedIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/OptionBox/pulsado.png")));
        optionButton.setSelected(false);
        optionButton.addMouseListener(new AnswerQuestion());

        add(optionButton, constraints);

    }

    private void addOptionText(){

        String currentCourseID = AnswerTestController.getCurrentCourseID();
        String currentTestID = AnswerTestController.getCurrentTestID();
        String description = AnswerTestController.getInstance().getAnswerDescription(currentCourseID,currentTestID,questionID,answerID);

        optionTextPanel.setLayout(new GridBagLayout());
        optionTextPanel.setRoundBackgroundColor(Color.WHITE);
        constraints.insets= new Insets(20,10,20,10);
        constraints.weightx = 1;
        optionTextPanel.add(optionText, constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        optionText.setFont(new Font("Futura", Font.ITALIC, 16));
        optionText.setForeground(Color.BLACK);
        optionText.setText(description);
        optionText.setEditable (false); 
        optionText.setLineWrap(true);
        optionText.setWrapStyleWord(true);
        constraints.insets= new Insets(10,10,10,10);

        add(optionTextPanel, constraints);

    }
}
