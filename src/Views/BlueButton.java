package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlueButton extends JButton implements ActionListener{

    BlueButton(String buttonName){
        super(buttonName);
        setBackground(new Color(61,90,128));
    }

    @Override public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
    }
}