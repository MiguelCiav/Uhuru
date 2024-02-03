package views.swingComponents;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;

// Esta clase se hizo con el fin de crear etiquetas (JLabel) con interacciones

public class InteractiveIcon extends JLabel{

    InteractiveIcon(String imageURL){ 
        this.setIcon(new ImageIcon(getClass().getResource(imageURL)));
    }

    InteractiveIcon(String label, String imageURL, MouseAdapter action){
        this.setIcon(new ImageIcon(getClass().getResource(imageURL)));
        this.setText(label); 
        addMouseListener(action);
    }
}
