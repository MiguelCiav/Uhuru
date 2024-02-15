package main.views.components;
import javax.swing.*;
import javax.swing.border.LineBorder;

import main.views.listeners.CloseWindow;

import java.awt.*;

import utils.ViewsStyles;


public class CertificatePopUp extends JPanelRound{

    GridBagConstraints constraints;
    private ScrollableCertificateList scroll;
    private JScrollPane scrollPanel;

    public CertificatePopUp(){
        constraints = new GridBagConstraints();

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(ViewsStyles.CYAN, 20,true));
        setMinimumSize(new Dimension(863,550));
        addExitButton();
        addTitle();
        
        setScrollableCertificateList();
        addScrollablePanel();

    }

    public void addTitle(){
        JLabel title = new JLabel();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets= new Insets(50,35,30,10);

        title.setFont(new Font("Futura", Font.BOLD, 30));
        title.setForeground(ViewsStyles.DARK_BLUE);
        title.setText("Obtener Certificado");

        add(title, constraints);
    }

    public void addExitButton(){

        JLabel exitButton = new JLabel();
        
        constraints.gridx = 1;
        constraints.weightx = 0.0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(10,0,10,30);
        exitButton.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testListView/close.png")));
        
        exitButton.addMouseListener(new CloseWindow());
        add(exitButton, constraints);
    }

    private void setScrollableCertificateList (){
        scroll = new ScrollableCertificateList();
        scrollPanel = new JBlueScrollPane(scroll);
    }
    private void addScrollablePanel(){
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets= new Insets(20,10,20,10);
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPanel, constraints);

    }

}
