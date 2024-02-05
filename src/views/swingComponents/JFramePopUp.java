package views.swingComponents;
import javax.swing.*;
import java.awt.*;

public class JFramePopUp extends JFrame {

    public JFramePopUp(){
        add(new CertificatePopUp());
        
        setPreferredSize(new Dimension(863,550));
        setResizable(false);
        setUndecorated(true); 
        pack();
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        setVisible(true);

    }
    
}
