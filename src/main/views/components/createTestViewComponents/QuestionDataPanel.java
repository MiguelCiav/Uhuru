package main.views.components.createTestViewComponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;
import main.views.listeners.AddImageListener;
import main.views.listeners.AddQuestionListener;
import main.views.listeners.DeleteQuestionListener;
import main.views.listeners.NextQuestionListener;
import main.views.listeners.PreviousQuestionListener;
import utils.PathManager;
import utils.ViewsStyles;

public class QuestionDataPanel extends JPanelRound implements ActionListener{

    private static QuestionDataPanel instance;
    private static JCheckBox isCode = new JCheckBox("¿Contiene código?", new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
    private static JLabel statement = new JLabel("Enunciado #1");
    private static LargeTextPanels domain = new LargeTextPanels("Dominio", Color.WHITE);

    private GridBagConstraints constraints = new GridBagConstraints();

    private static Container containerPane = new Container();
    private static CardLayout card = new CardLayout();

    private static ArrayList<QuestionStatement> questionList = new ArrayList<QuestionStatement>();
    private static int questionIndex = 0;
    
    private QuestionDataPanel(){
        
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);
        containerPane.setLayout(card);

        addStatementText();
        addDomainTextField();
        addIsCodeButton();
        addQuestionToContainer(0);
        addContainer();
        addArrowButtons();
        addDeleteQuestionButton();
        addNewQuestionButton();
        addInsertImageButton();
    }

    public static QuestionDataPanel getInstance(){
        if(instance == null){
            instance = new QuestionDataPanel();
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
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(statement, constraints);
        
    }

    public static void setStatementText(int questionNum){
        statement.setText("Enunciado #" + questionNum);
    }

    public void addDomainTextField(){
        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 2;
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.BOTH;

        add(domain, constraints);
    }
    public static LargeTextPanels getDomain(){
        return domain;
    }

    public static void setDomain(String domain){
        QuestionDataPanel.domain.getTextArea().setText(domain);
    }

    public void addIsCodeButton(){
        
        isCode.setBackground(Color.WHITE);
        isCode.setHorizontalTextPosition(SwingConstants.LEFT);
        isCode.setBorder(null);
        isCode.setFocusPainted( false );
        isCode.setSelected(false);
        constraints.insets = new Insets(10, 100, 10, 0);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        isCode.addActionListener(this);

        add(isCode, constraints);
        
    }

    public static void addQuestionToContainer(int index){

        QuestionStatement question = new QuestionStatement();
        addQuestionToList(question, index);
        containerPane.add(question, index);
        
    }

    public static void addQuestionToList(QuestionStatement question, int index){
        questionList.add(index, question);
    }

    public static void deleteQuestionInContainer(int index){
        containerPane.remove(index);
        deleteQuestionInList(index);
    }

    public static void deleteQuestionInList(int index){
        questionList.remove(index);
    }

    public static int getQuestionIndex(){
        return questionIndex;
    }
    public static void setQuestionIndex(int num){
        questionIndex = num;
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
        leftArrow.addMouseListener(PreviousQuestionListener.getInstance());

        add(leftArrow, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 20, 0);
        rightArrow.addMouseListener(NextQuestionListener.getInstance());

        add(rightArrow, constraints);
    }

    public void addDeleteQuestionButton(){

        JLabel deleteQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/DeleteQuestion.png")));
        constraints.gridx = 2;
        constraints.insets = new Insets(0, 20, 20,0);
        deleteQuestionButton.addMouseListener(DeleteQuestionListener.getInstance());

        add(deleteQuestionButton, constraints);
    }

    public void addNewQuestionButton(){

        JLabel newQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/NewQuestion.png")));
        constraints.gridx = 3;
        constraints.insets = new Insets(0, 10, 20, 10);
        newQuestionButton.addMouseListener(AddQuestionListener.getInstance());

        add(newQuestionButton, constraints);

    }

    public void addInsertImageButton(){

        BlueButton insertImageButton = new BlueButton("Insertar imagen", 232, 1);
        insertImageButton.addActionListener(AddImageListener.getInstance());
        constraints.gridx = 4;
        constraints.insets = new Insets(0, 10, 20, 20);
        constraints.fill = GridBagConstraints.BOTH;

        add(insertImageButton, constraints);

    }

    public static JCheckBox getBox(){
        return isCode;
    }

    public static ArrayList<QuestionStatement> getQuestionList(){
        return questionList;
    }

    @Override public void actionPerformed(ActionEvent e){
        JCheckBox box = (JCheckBox) e.getSource();
        if(box.isSelected()){
            isCode.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
            questionList.get(questionIndex).getCode().getTextArea().setEditable(true);
        }
        else{
            isCode.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
            questionList.get(questionIndex).getCode().getTextArea().setText("Ingrese el codigo");
            questionList.get(questionIndex).getCode().getTextArea().setEditable(false);
        }
    }
}
