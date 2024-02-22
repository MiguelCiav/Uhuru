package main.views.components.testViewComponents;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.controllers.AnswerTestController;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.genericComponents.JPanelRound;
import utils.ViewsStyles;

import java.awt.*;

public class QuestionPanel extends JPanelRound{

    GridBagConstraints constraints;
    private String[] answerIDs;
    private String questionNumber;
    private String questionID;
    private String testID;
    private String courseID;
    private OptionBox[] optionsArray;
    private int correctAnswersAmount;
    private int selectedAmount;
    private ImageIcon questionImage;
    boolean test = false;

    public QuestionPanel (String questionNumber, String courseID, String testID, String questionID){

        this.questionNumber = String.valueOf(questionNumber);
        this.questionID = questionID;
        this.testID = testID;
        this.courseID = courseID;
        selectedAmount = 0;
        setCorrectAnswerAmount();

        constraints = new GridBagConstraints();

        setRoundBackgroundColor(ViewsStyles.LIGHT_GRAY);
        setLayout(new GridBagLayout());
        setBorder(null);
        
        addQuestionNumber();
        addQuestionDomain();
        addQuestionDescription();
        addQuestionCode();
        addImage();
        loadAnswers();
        addOptionBox();

    }

    public void selectAnswer(String answerID){

        for(OptionBox option : optionsArray){
            
            if(option.getAnswerID().equals(answerID)){

                if(option.isSelected()){

                    if(selectedAmount < correctAnswersAmount){

                        selectedAmount++;
                        AnswerTestController.getInstance().answerQuestion(questionID, answerID, true);

                    } else {

                        option.setSelected(false);

                    }

                } else {

                    selectedAmount--;
                    AnswerTestController.getInstance().answerQuestion(questionID, answerID, false);
                    
                }

            }
        }
    }

    private void setCorrectAnswerAmount(){
        correctAnswersAmount = AnswerTestController.getInstance().getCorrectAnswersAmount(questionID);
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
        String domain = AnswerTestController.getInstance().getQuestionDomain(questionID);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.0;

        questionDomain.setFont(new Font("Futura", Font.BOLD, 24));
        questionDomain.setForeground(Color.BLACK);
        questionDomain.setText("Dominio: " + domain);

        add(questionDomain, constraints);

    }

    private void addQuestionDescription(){

        JTextArea questionDescription = new JTextArea();
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

    private void addQuestionCode(){

        JTextArea questionCode = new JTextArea();
        String code = AnswerTestController.getInstance().getQuestionCode(questionID);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        
        questionCode.setLineWrap(true);
        questionCode.setWrapStyleWord(true);
        questionCode.setFont(new Font("Futura", Font.ITALIC, 16));
        questionCode.setForeground(Color.WHITE);
        questionCode.setText(code);
        questionCode.setBackground(Color.DARK_GRAY);

        if(code.equals("")){
            questionCode.setVisible(false);
        } else {
            test = true;
        }

        add(questionCode, constraints);

    }

    private void addImage(){

        JLabel imageLabel = new JLabel();
        final String URL = AnswerTestController.getInstance().getQuestionImage(questionID);

        if(URL != null){

            questionImage = new ImageIcon(URL);
            imageLabel.setIcon(questionImage);

            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.gridwidth = 1;
            constraints.weightx = 1.0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.anchor = GridBagConstraints.CENTER;

            add(imageLabel, constraints);
        }

    }

    private void loadAnswers(){

        String currentTestID = AnswerTestController.getCurrentTestID();
        String currentCourseID = AnswerTestController.getCurrentCourseID();

        answerIDs = AnswerTestController.getInstance().getAnswersIDs(currentCourseID, currentTestID, questionID);

    }
    
    private void addOptionBox(){

        constraints = new GridBagConstraints();
        optionsArray = new OptionBox[answerIDs.length];

        for (int i=0; i < answerIDs.length; i++){

            optionsArray[i] = new OptionBox(questionID,answerIDs[i]);
            constraints.gridx = 1;
            constraints.gridy = 3 + (i+1);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets= new Insets(5,10,5,20);
            add(optionsArray[i],constraints);

        }

    }

}
