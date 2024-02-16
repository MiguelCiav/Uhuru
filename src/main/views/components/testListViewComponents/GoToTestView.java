package main.views.components.testListViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import main.views.frames.TestView;

import java.awt.Component;

public class GoToTestView extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
            
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new TestView();
        topFrame.dispose();
            
    }
}
