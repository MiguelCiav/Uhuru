package views.swingComponents;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class OptionBox extends JPanelRound{
    JTextArea optionText = new JTextArea ();
    JRadioButton optionButton = new JRadioButton();
    JPanelRound optionTextPanel = new JPanelRound();
    GridBagConstraints constraints = new GridBagConstraints();

    public OptionBox (){
        setBackground(new Color(216,233,241));
        setLayout(new GridBagLayout());
        setBorder(null);

        addOptionButton();
        addOptionText();
        
    }

    private void addOptionButton(){
        PathManager optionButtonImageURL = new PathManager();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,10,10,10);
        
        optionButton.setBackground(new Color(216,233,241));
        optionButton.setSelected(true);
        optionButton.setBorder(null);
        optionButton.setIcon(new ImageIcon(new PathManager().setFileLink("ProyectoIS2023_Grupo_2" + File.separator + "src" + File.separator + "Views" + File.separator + "img" + File.separator + "OptionBox" + File.separator + "sin pulsar.png")));
        optionButton.setSelectedIcon(new ImageIcon(new PathManager().setFileLink("ProyectoIS2023_Grupo_2" + File.separator + "src" + File.separator + "Views" + File.separator + "img" + File.separator + "OptionBox" + File.separator + "pulsado.png")));
        optionButton.setSelected(false);
        
        add(optionButton, constraints);
    }

    private void addOptionText(){
        optionTextPanel.setLayout(new GridBagLayout());
        optionTextPanel.setRoundBackgroundColor(Color.WHITE);
        constraints.insets= new Insets(20,10,20,10);
        constraints.weightx = 1;
        optionTextPanel.add(optionText, constraints);

        constraints.gridx = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        optionText.setFont(new Font("Futura", Font.ITALIC, 16));
        optionText.setForeground(new Color(0,0,0));
        optionText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at elit eget dui gravida suscipit. Mauris et ipsum id felis venenatis consectetur. Etiam ac nibh sit amet quam aliquam sodales vel sed quam.");
        optionText.setEditable (false); 
        optionText.setLineWrap(true);
        optionText.setWrapStyleWord(true);
        constraints.insets= new Insets(10,10,10,10);

        add(optionTextPanel, constraints);
    }

    public void addToGroup (ButtonGroup group){
        group.add(optionButton);
        
    }
}
