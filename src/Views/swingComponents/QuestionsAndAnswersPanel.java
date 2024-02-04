package Views.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class QuestionsAndAnswersPanel extends JPanelRound implements ActionListener{
    
    private JLabel questionsAndAnswersText;
    private JComboBox<String> domainSelection = new JComboBox<String>();
    private JPanelRound addQuestionPanel = new JPanelRound();
    private JLabel addQuestionLabel = new JLabel("Añadir pregunta");
    private JButton addQuestionButton = new JButton(new ImageIcon(new PathManager().setFileLink("src" + File.separator + "Views" + File.separator + "img" + File.separator + "createTestView" + File.separator + "Add_Ico.png")));
    private BlueButton cancelTestButton = new BlueButton("Cancelar examen", 200, 2);
    private BlueButton createTestButton = new BlueButton("Crear examen", 50, 1);
    private GridBagConstraints constraints = new GridBagConstraints();
    private AddQuestionsPanel question = new AddQuestionsPanel();

    public QuestionsAndAnswersPanel(){
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(new Color(255,255,255));
        
        questionsAndAnswersText = new JLabel();
        questionsAndAnswersText.setText("Preguntas y Respuestas");
        questionsAndAnswersText.setFont(new Font("Futura", Font.BOLD, 32));
        questionsAndAnswersText.setForeground(new Color(61,90,128));

        constraints.insets = new Insets(30, 20, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.6;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(questionsAndAnswersText, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.4;
        addDomainOptions();
        add(domainSelection, constraints);

        addQuestionPanel.setLayout(new GridBagLayout());
        constraints.insets = new Insets(0, 20, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 2;
        constraints.weighty = 0.5;
        constraints.weightx = 1.0;
        
        addQuestionPanel.add(addQuestionLabel, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        addQuestionButton.setBackground(new Color(152,193,217));
        addQuestionButton.setBorder(null);
        addQuestionButton.addActionListener(this);
        
        addQuestionPanel.add(addQuestionButton, constraints);

        constraints.insets = new Insets(30, 20, 0, 20);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0;

        add(question, constraints);

        constraints.insets = new Insets(10, 20, 0, 20);

        constraints.weighty = 0.0;
        constraints.gridy = 2;        
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        addQuestionPanel.setPreferredSize(new Dimension(600,50));
        addQuestionPanel.setRoundBackgroundColor(new Color(152,193,217));

        add(addQuestionPanel, constraints);

        constraints.insets = new Insets(10, 0, 30, 20);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.SOUTHEAST;

        add(cancelTestButton, constraints);

        constraints.gridx = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.SOUTH;

        add(createTestButton, constraints);
    }

    public void addDomainOptions(){
        domainSelection.addItem("Java");
        domainSelection.addItem("Java");
        domainSelection.addItem("Java");
        domainSelection.addItem("Java");
        domainSelection.addItem("Java");
    }

    @Override public void actionPerformed(ActionEvent e){
    }
}
