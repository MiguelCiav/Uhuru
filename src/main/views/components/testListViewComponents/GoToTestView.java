package main.views.components.testListViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import main.controllers.AnswerTestController;
import main.views.frames.TestView;

import java.awt.Component;

public class GoToTestView extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
            
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        JLabel source = (JLabel) e.getSource();
        LabelPanelTest sourcePanel = (LabelPanelTest) source.getParent();

        AnswerTestController.setCurrentTest(sourcePanel.getCourseID(), sourcePanel.getTestID());
        new TestView();
        topFrame.dispose();
            
    }
}
