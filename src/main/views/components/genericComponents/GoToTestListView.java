package main.views.components.genericComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.*;

import main.views.frames.TestListView;

public class GoToTestListView extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new TestListView();
        topFrame.dispose();
    }

}
