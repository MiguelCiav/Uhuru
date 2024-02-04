package Views.swingComponents;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.*;

import Views.listeners.IconListener;

// Esta clase se hizo con el fin de crear etiquetas (JLabel) con interacciones

public class InteractiveIcon extends JLabel{

    InteractiveIcon(String imageURL){
        PathManager interactiveIconImageURL = new PathManager(); 
        this.setIcon(new ImageIcon(new PathManager().setFileLink(imageURL)));
    }

    InteractiveIcon(String label, String imageURL, IconListener action){
        PathManager interactiveIconImageURL = new PathManager();
        this.setIcon(new ImageIcon(new PathManager().setFileLink(imageURL)));
        this.setText(label); 
        addMouseListener(action);
    }
}
