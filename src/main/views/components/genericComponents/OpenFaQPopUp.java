package main.views.components.genericComponents;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.faqPopUp.FaQPopUp;
import main.views.components.certificatePopUpComponents.JFramePopUp;

public class OpenFaQPopUp extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        new JFramePopUp(new FaQPopUp());
    }

}