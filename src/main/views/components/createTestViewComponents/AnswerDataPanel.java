package main.views.components.createTestViewComponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.listeners.AddAndDeleteOptionsListener;
import main.views.listeners.NextOptionListener;
import main.views.listeners.PreviousOptionListener;
import utils.PathManager;
import utils.ViewsStyles;

public class AnswerDataPanel extends JPanelRound implements ActionListener{

    private static JCheckBox isCorrect = new JCheckBox("¿Es la opción correcta?", new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
    private static JLabel statement = new JLabel("Opcion #1");
    private GridBagConstraints constraints = new GridBagConstraints();
    private static Container cPane = new Container();
    private CardLayout card = new CardLayout();


    
    public AnswerDataPanel(){
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);

        addStatementText();
        addIsCorrectButton();
        addOptionStatement();
        addArrowButtons();
        addDeleteOptionButton();
        addNewOptionButton();
        addInsertImageButton();

    }

    public void addStatementText(){
        statement.setFont(ViewsStyles.TITLE_FONT);
        statement.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 4;
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
        constraints.insets = new Insets(10, 100, 10, 0);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        isCorrect.addActionListener(this);

        add(isCorrect, constraints);
    }

    public void addOptionStatement(){
        constraints.insets = new Insets(10, 20, 10, 20);
        AnswerStatement option = new AnswerStatement();
        cPane.setLayout(card);
        QuestionStatement.optionsList.add(option);
        cPane.add(option);

        
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
        leftArrow.addMouseListener(new PreviousOptionListener(cPane, card));

        add(leftArrow, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0, 10, 20, 0);
        rightArrow.addMouseListener(new NextOptionListener(cPane, card));

        add(rightArrow, constraints);
    }

    public void addDeleteOptionButton(){

        JLabel deleteQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/DeleteQuestion.png")));
        deleteQuestionButton.setName("DeleteOption");
        constraints.gridx = 2;
        constraints.insets = new Insets(0, 20, 20,0);
        deleteQuestionButton.addMouseListener(AddAndDeleteOptionsListener.getInstance(cPane, card));

        add(deleteQuestionButton, constraints);
    }

    public void addNewOptionButton(){
        JLabel newQuestionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/NewQuestion.png")));
        newQuestionButton.setName("AddOption");
        constraints.gridx = 3;
        constraints.insets = new Insets(0, 10, 20, 10);
        newQuestionButton.addMouseListener(AddAndDeleteOptionsListener.getInstance(cPane, card));

        add(newQuestionButton, constraints);
    }

    public void addInsertImageButton(){
        BlueButton insertImageButton = new BlueButton("Crear Examen", 232, 1);

        constraints.gridx = 4;
        constraints.insets = new Insets(0, 10, 20, 20);
        constraints.fill = GridBagConstraints.BOTH;

        add(insertImageButton, constraints);
    }

    public static JCheckBox getBox(){
        return isCorrect;
    }

    public static ArrayList<AnswerStatement> getOptionList(){
        return QuestionStatement.optionsList;
    }

    public static Container getContainer(){
        return cPane;
    }

    @Override public void actionPerformed(ActionEvent e){
        JCheckBox box = (JCheckBox) e.getSource();

        if(box.isSelected()){
            isCorrect.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/answerCheckBox.png")));
        }
        else{
            isCorrect.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }
}