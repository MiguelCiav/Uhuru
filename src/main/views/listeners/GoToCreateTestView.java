package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.*;

import main.views.frames.CreateTestView;
import main.views.frames.UserListView;



public class GoToCreateTestView extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        UserListView.getInstance().disposeFrame();
        CreateTestView.getInstance();
    }

}