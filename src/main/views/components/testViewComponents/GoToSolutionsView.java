package main.views.components.testViewComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.*;

import main.views.frames.SolutionsView;

public class GoToSolutionsView implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new SolutionsView();
        topFrame.dispose();
    }

}
