package Views.swingComponents;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;
import Views.listeners.LabelListener;

// Esta clase se hizo con el fin de crear etiquetas (JLabel) con interacciones

public class InteractiveIcon extends JLabel{

    InteractiveIcon(String imageURL){ 
        this.setIcon(new ImageIcon(getClass().getResource(imageURL)));
    }

    InteractiveIcon(String label, String imageURL, LabelListener action){
        this.setIcon(new ImageIcon(getClass().getResource(imageURL)));
        this.setText(label); 
        addMouseListener(action);
    }
}
