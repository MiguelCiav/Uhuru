package main.views.components.genericComponents;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.RegisterUserPopUp;
import main.views.components.certificatePopUpComponents.JFramePopUp;

public class OpenUserRegisterPopUp extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        new JFramePopUp(new RegisterUserPopUp());
    }

}