package main.views.components.createTestViewComponents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.views.components.genericComponents.LargeTextPanels;
import main.views.listeners.AddImageListener;
import utils.ViewsStyles;

public class QuestionStatement extends JPanel{

    private GridBagConstraints constraints = new GridBagConstraints();
    private LargeTextPanels statement = new LargeTextPanels("Ingrese el enunciado de la pregunta", ViewsStyles.ULTRA_LIGHT_BLUE);
    private LargeTextPanels code = new LargeTextPanels("Ingrese el codigo", ViewsStyles.LIGHT_BLACK);
    private ArrayList<AnswerStatement> optionsList = new ArrayList<AnswerStatement>();
    private String imagePath;
    private String domain;

    public QuestionStatement(){
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        addQuestionStatement();
        addCode();
    }

    public void addQuestionStatement(){

        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.6;
        constraints.fill = GridBagConstraints.BOTH;

        add(statement, constraints);

    }

    public void addCode(){

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.4;
        constraints.fill = GridBagConstraints.BOTH;
        code.getTextArea().setForeground(Color.WHITE);
        code.getTextArea().setEditable(false);

        add(code, constraints);
    }

    public ArrayList<AnswerStatement> getOptionList(){
        return optionsList;
    }

    public LargeTextPanels getStatement(){
        return statement;
    }

    public LargeTextPanels getCode(){
        return code;
    }

    public void addOption(AnswerStatement option, int index){
        optionsList.add(index, option);
    }

    public void setImagePath(String path){
        imagePath = path;
    }

    public String getImagePath(){
        return imagePath;
    }

    public void setDomain(LargeTextPanels domain){
        this.domain = domain.getTextArea().getText();
    }

    public String getDomain(){
        return domain;
    }
}
