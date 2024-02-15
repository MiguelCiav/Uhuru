package main.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.views.components.CertificatePopUp;
import main.views.components.JFramePopUp;

public class OpenCertificatePopUp implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        new JFramePopUp(new CertificatePopUp());
    }

}
