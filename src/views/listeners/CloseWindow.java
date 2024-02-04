package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.*;



public class CloseWindow extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        topFrame.dispose();
    }

}
