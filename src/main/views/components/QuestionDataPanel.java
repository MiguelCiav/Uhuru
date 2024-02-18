package main.views.components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.listeners.AddAndDeleteQuestionListener;
import main.views.listeners.NextQuestionListener;
import main.views.listeners.PreviousQuestionListener;
import utils.PathManager;
import utils.ViewsStyles;

public class QuestionDataPanel extends JPanelRound implements ActionListener{

    private JCheckBox isCode = new JCheckBox("¿Contiene código?");
    private QuestionStatement question = new QuestionStatement();
    private GridBagConstraints constraints = new GridBagConstraints();
    private Container cPane = new Container();
    private CardLayout card = new CardLayout();
    private ArrayList<QuestionStatement> questionList = new ArrayList<QuestionStatement>();

    
    public QuestionDataPanel(){
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);

        addStatementText();
        addIsCodeButton();
        addQuestionStatement();
        addArrowButtons();
        addDeleteQuestionButton();
        addNewQuestionButton();
        addInsertImageButton();

    }

    public void addStatementText(){
        JLabel statement = new JLabel("Enunciado");
        statement.setFont(ViewsStyles.TITLE_FONT);
        statement.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(statement, constraints);
    }
    
    public void addIsCodeButton(){
        isCode.setBackground(Color.WHITE);
        isCode.setHorizontalTextPosition(SwingConstants.LEFT);
        isCode.setBorder(null);
        constraints.insets = new Insets(10, 100, 10, 0);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        isCode.addActionListener(this);

        add(isCode, constraints);
    }

    public void addQuestionStatement(){
        constraints.insets = new Insets(10, 20, 10, 20);
        QuestionStatement question = new QuestionStatement();
        cPane.setLayout(card);
        questionList.add(question);
        cPane.add(question);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 5;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;

        add(cPane, constraints);
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
        leftArrow.addMouseListener(new PreviousQuestionListener(cPane, card));

        add(leftArrow, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 20, 0);
        rightArrow.addMouseListener(new NextQuestionListener(cPane, card));

        add(rightArrow, constraints);
    }

    public void addDeleteQuestionButton(){

        JLabel deleteQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/DeleteQuestion.png")));
        deleteQuestionButton.setName("DeleteQuestion");
        constraints.gridx = 2;
        constraints.insets = new Insets(0, 20, 20,0);
        deleteQuestionButton.addMouseListener(AddAndDeleteQuestionListener.getInstance(cPane, card));

        add(deleteQuestionButton, constraints);
    }

    public void addNewQuestionButton(){
        JLabel newQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/NewQuestion.png")));
        newQuestionButton.setName("AddQuestion");
        constraints.gridx = 3;
        constraints.insets = new Insets(0, 10, 20, 10);
        newQuestionButton.addMouseListener(AddAndDeleteQuestionListener.getInstance(cPane, card));

        add(newQuestionButton, constraints);
    }

    public void addInsertImageButton(){
        BlueButton insertImageButton = new BlueButton("Insertar imagen", 232, 1);

        constraints.gridx = 4;
        constraints.insets = new Insets(0, 10, 20, 20);
        constraints.fill = GridBagConstraints.BOTH;

        add(insertImageButton, constraints);
    }

    @Override public void actionPerformed(ActionEvent e){
        JCheckBox box = (JCheckBox) e.getSource();
        if(box.isSelected()){
            questionList.get(AddAndDeleteQuestionListener.getQuestionIndex()).code.getTextArea().setEditable(true);
        }
        else{
            questionList.get(AddAndDeleteQuestionListener.getQuestionIndex()).code.getTextArea().setEditable(false);
        }
        
    }
}
