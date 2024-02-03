package Views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class LabelListener extends MouseAdapter {

    @Override
    public abstract void mouseClicked(MouseEvent e);

}
