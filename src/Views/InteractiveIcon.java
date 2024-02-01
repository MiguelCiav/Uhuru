package Views;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.*;

// Esta clase se hizo con el fin de crear etiquetas (JLabel) con interacciones

public class InteractiveIcon extends JLabel{

    InteractiveIcon(String imageURL){
        PathManager interactiveIconImageURL = new PathManager(); 
        this.setIcon(new ImageIcon(interactiveIconImageURL.setFileLink(imageURL)));
    }

    InteractiveIcon(String label, String imageURL, IconListener action){
        PathManager interactiveIconImageURL = new PathManager();
        this.setIcon(new ImageIcon(interactiveIconImageURL.setFileLink(imageURL)));
        this.setText(label); 
        addMouseListener(action);
    }
}
