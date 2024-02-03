package views.swingComponents;

import javax.swing.*;

import java.awt.*;

public abstract class ScrollablePanel extends JPanel{

    public ScrollablePanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255));

    }

    protected abstract void addScrollableElements();

}
