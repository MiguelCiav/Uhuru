package main.views.components;

import javax.swing.*;

import java.awt.*;

public abstract class ScrollablePanel extends JPanel{

    public ScrollablePanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.WHITE);

    }

    protected abstract void addScrollableElements();

}
