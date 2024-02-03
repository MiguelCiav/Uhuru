package Views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Component;
import javax.swing.*;

import Views.useCaseFrames.TestListView;

public class TestListViewAction extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new TestListView();
        topFrame.dispose();
    }

}
