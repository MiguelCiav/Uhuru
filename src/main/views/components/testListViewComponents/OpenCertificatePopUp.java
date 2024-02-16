package main.views.components.testListViewComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.views.components.certificatePopUpComponents.CertificatePopUp;
import main.views.components.certificatePopUpComponents.JFramePopUp;

public class OpenCertificatePopUp implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        new JFramePopUp(new CertificatePopUp());
    }

}
