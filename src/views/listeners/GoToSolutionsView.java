package views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.*;

import views.useCaseFrames.SolutionsView;

public class GoToSolutionsView implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        new SolutionsView();
        topFrame.dispose();
    }

}
