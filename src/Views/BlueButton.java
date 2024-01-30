package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlueButton extends JButton implements ActionListener{

    BlueButton(String buttonName, int width){
        super(buttonName);
        setBackground(new Color(61,90,128));
        setFont(new Font("Futura", Font.BOLD, 16));
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setPreferredSize(new Dimension(width, 65));
        setMinimumSize(new Dimension(width, 65));
    }

    @Override public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
    }
}