package main.views.components.createTestViewComponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import main.controllers.CreateTestController;
import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.listeners.AddOptionListener;
import main.views.listeners.CreateTestListener;
import main.views.listeners.DeleteOptionListener;
import main.views.listeners.NextOptionListener;
import main.views.listeners.PreviousOptionListener;
import utils.PathManager;
import utils.ViewsStyles;

public class AnswerDataPanel extends JPanelRound implements ActionListener{

    private static AnswerDataPanel instance;
    private static JCheckBox isCorrect = new JCheckBox("¿Es la opción correcta?",new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
    private static JLabel statement = new JLabel("Opcion #1");
    private GridBagConstraints constraints = new GridBagConstraints();

    private static Container containerPane = new Container();
    private static CardLayout card = new CardLayout();
    private static int optionIndex = 0;
    
    private AnswerDataPanel(){
        
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);
        containerPane.setLayout(card);

        addStatementText();
        addIsCorrectButton();
        addOptionToContainer(0);
        addContainer();
        addArrowButtons();
        addDeleteOptionButton();
        addNewQuestionButton();
        addCreateTestButton();
    }

    public static AnswerDataPanel getInstance(){
        if(instance == null){
            instance = new AnswerDataPanel();
        }

        return instance;
    }

    public void addStatementText(){

        statement.setFont(ViewsStyles.TITLE_FONT);
        statement.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(statement, constraints);
        
    }

    public static void setStatementText(int questionNum){
        statement.setText("Opcion #" + questionNum);
    }
    
    public void addIsCorrectButton(){
        
        isCorrect.setBackground(Color.WHITE);
        isCorrect.setHorizontalTextPosition(SwingConstants.LEFT);
        isCorrect.setBorder(null);
        isCorrect.setFocusPainted( false );
        constraints.insets = new Insets(10, 100, 10, 0);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        isCorrect.addActionListener(this);

        add(isCorrect, constraints);
        
    }

    public static void addOptionToContainer(int index){

        AnswerStatement option = new AnswerStatement();
        addOptionToList(option, index);
        containerPane.add(option, index);
        
    }

    public static void addOptionToList(AnswerStatement option, int index){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).addOption(option, index);
    }

    public static void addOptionToContainerFromList(AnswerStatement option){
        containerPane.add(option);
    }

    public static void deleteOptionInContainer(int index){
        containerPane.remove(index);
        deleteOptionInList(index);
    }

    public static void deleteOptionInList(int index){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().remove(index);
    }

    public static int getOptionIndex(){
        return optionIndex;
    }
    public static void setOptionIndex(int num){
        optionIndex = num;
    }

    public void addContainer(){
        
        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 5;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;

        add(containerPane, constraints);
    }

    public static Container getContainer(){
        return containerPane;
    } 

    public static CardLayout getCardLayout(){
        return card;
    }

    public void addArrowButtons(){
        
        JLabel leftArrow = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/LeftArrow.png")));
        JLabel rightArrow = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/RightArrow.png")));

        constraints.insets = new Insets(0, 20, 20, 0);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        leftArrow.addMouseListener(PreviousOptionListener.getInstance());

        add(leftArrow, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 20, 0);
        rightArrow.addMouseListener(NextOptionListener.getInstance());

        add(rightArrow, constraints);
    }

    public void addDeleteOptionButton(){

        JLabel deleteOptionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/DeleteQuestion.png")));
        constraints.gridx = 2;
        constraints.insets = new Insets(0, 20, 20,0);
        deleteOptionButton.addMouseListener(DeleteOptionListener.getInstance());

        add(deleteOptionButton, constraints);
    }

    public void addNewQuestionButton(){

        JLabel newOptionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/NewQuestion.png")));
        constraints.gridx = 3;
        constraints.insets = new Insets(0, 10, 20, 10);
        newOptionButton.addMouseListener(AddOptionListener.getInstance());

        add(newOptionButton, constraints);

    }

    public void addCreateTestButton(){

        BlueButton createTestButton = new BlueButton("Crear Examen", 232, 1);

        constraints.gridx = 4;
        constraints.insets = new Insets(0, 10, 20, 20);
        constraints.fill = GridBagConstraints.BOTH;

        createTestButton.addActionListener(CreateTestListener.getInstance());

        add(createTestButton, constraints);

    }

    public static JCheckBox getBox(){
        return isCorrect;
    }

    @Override public void actionPerformed(ActionEvent e){
        JCheckBox box = (JCheckBox) e.getSource();
        if(box.isSelected()){
            isCorrect.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
            QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(optionIndex).getJustification().getTextArea().setEditable(true);
        }
        else{
            isCorrect.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
            QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(optionIndex).getJustification().getTextArea().setText("La opcion debe ser correcta para ingresar una justificacion");
            QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(optionIndex).getJustification().getTextArea().setEditable(false);
        }
    }
}