package main.views.components.testViewComponents;
import javax.swing.*;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.JPanelRound;
import utils.ViewsStyles;

import java.awt.*;

public class QuestionPanel extends JPanelRound{

    GridBagConstraints constraints;
    private String questionNumber;
    private String questionID;
    private String testID;
    private String courseID;
    private String[] answerIDs;

    public QuestionPanel (String questionNumber, String courseID, String testID, String questionID){

        this.questionNumber = String.valueOf(questionNumber);
        this.questionID = questionID;
        this.testID = testID;
        this.courseID = courseID;

        constraints = new GridBagConstraints();

        setRoundBackgroundColor(ViewsStyles.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        setBorder(null);
        
        addQuestionNumber();
        addQuestionDomain();
        addQuestionDescription();
        loadAnswers();
        addOptionBox();

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
        questionNumberLabel.setForeground(ViewsStyles.DARK_BLUE);
        questionNumberLabel.setText(questionNumber);
        add(questionNumberLabel, constraints);

    }

    private void addQuestionDomain(){

        JLabel questionDomain = new JLabel();

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        questionDomain.setFont(new Font("Futura", Font.BOLD, 24));
        questionDomain.setForeground(Color.BLACK);
        questionDomain.setText("Dominio: Ejemplo");

        add(questionDomain, constraints);

    }

    private void addQuestionDescription(){

        JTextArea questionDescription = new JTextArea();
        ;
        String description = AnswerTestController.getInstance().getQuestionDescription(courseID,testID,questionID);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.insets= new Insets(0,0,10,20);

        questionDescription.setLineWrap(true);
        questionDescription.setWrapStyleWord(true);
        questionDescription.setFont(new Font("Futura", Font.ITALIC, 16));
        questionDescription.setForeground(Color.BLACK);
        questionDescription.setText(description);
        questionDescription.setBackground(ViewsStyles.LIGHT_GRAY);

        add(questionDescription, constraints);

    }

    private void loadAnswers(){

        String currentTestID = AnswerTestController.getCurrentTestID();
        String currentCourseID = AnswerTestController.getCurrentCourseID();

        answerIDs = AnswerTestController.getInstance().getAnswersIDs(currentCourseID, currentTestID, questionID);

    }
    
    private void addOptionBox(){

        constraints = new GridBagConstraints();
        ButtonGroup groupOne = new ButtonGroup();

        for (int i=0; i < answerIDs.length; i++){

            OptionBox newOption = new OptionBox(questionID,answerIDs[i]);
            constraints.gridx = 1;
            constraints.gridy = 1 + (i+1);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets= new Insets(5,10,5,20);
            newOption.addToGroup(groupOne);
            add(newOption,constraints);

        }

    }

}
