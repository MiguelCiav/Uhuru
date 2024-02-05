package views.swingComponents;
import javax.swing.*;
import java.awt.*;

public class JFramePopUp extends JFrame {

    public JFramePopUp(JPanel input){
        add(input);
        
        setPreferredSize(new Dimension(863,550));
        setResizable(false);
        setUndecorated(true); 
        pack();
        setLocationRelativeTo(null);
        setBackground(new Color(255,255,255,0));

        setVisible(true);

    }
    
}
