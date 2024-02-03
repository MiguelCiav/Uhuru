package Views.useCaseFrames;

import javax.swing.JFrame;

import Views.swingComponents.NavBar;
import Views.swingComponents.TestInfoPanel;

public class testFrame extends JFrame {
    
    public testFrame (){

        add(new NavBar());
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
