package main.views.listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.ModifyUserPopUp;
import main.views.components.certificatePopUpComponents.JFramePopUp;

public class OpenEditPopUp extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        new JFramePopUp(new ModifyUserPopUp());
    }

}