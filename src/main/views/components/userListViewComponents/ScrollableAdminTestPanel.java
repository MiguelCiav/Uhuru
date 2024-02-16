package main.views.components.userListViewComponents;

import java.awt.Dimension;
import javax.swing.Box;

import main.views.components.ScrollablePanel;

public class ScrollableAdminTestPanel extends ScrollablePanel{

    public ScrollableAdminTestPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements(){
        for(int i = 0; i < 5; i++){
            add(new LabelPanelAdminTest("Test " + String.valueOf(i)));
            add(Box.createRigidArea(new Dimension(0,20)));
        } 
    }
}
