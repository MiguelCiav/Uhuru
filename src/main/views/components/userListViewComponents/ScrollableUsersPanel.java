package main.views.components.userListViewComponents;

import java.awt.Dimension;
import javax.swing.Box;

import main.views.components.genericComponents.ScrollablePanel;


public class ScrollableUsersPanel extends ScrollablePanel {

    public ScrollableUsersPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements() {
        for(int i = 0; i < 5; i++){
            add(new LabelPanelUser("Username " + String.valueOf(i)));
            add(Box.createRigidArea(new Dimension(0,20)));
        } 
    }
    
}
