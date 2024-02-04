package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.swingComponents.JFramePopUp;

public class OpenCertificatePopUp implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        new JFramePopUp();
    }

}
