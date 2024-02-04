package views.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.*;

import views.useCaseFrames.TestListView;

public class TestListViewAction implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new TestListView();
        topFrame.dispose();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}
