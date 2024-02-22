package main.views.components.testViewComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.*;

import main.controllers.AnswerTestController;
import main.views.frames.SolutionsView;

public class endTest implements ActionListener{

    private int calification;

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());

        calculateCalification();

        System.out.println("La calificación es " + AnswerTestController.getInstance().getCalification());

        new SolutionsView();
        topFrame.dispose();
    }

    private void calculateCalification(){
        AnswerTestController.getInstance().calculateCalification();
    }

}
