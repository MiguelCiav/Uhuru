package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.*;

import views.swingComponents.JFramePopUp;
import views.useCaseFrames.SolutionsView;

public class OpenCertificatePopUp implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        new JFramePopUp();
    }

}
