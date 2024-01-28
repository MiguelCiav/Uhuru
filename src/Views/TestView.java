package Views;

import javax.swing.*;
import java.awt.*;

public class TestView extends JFrame{

    TestView(){
        super("Uhuru");
        setSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        add(new PrincipalPanel());

        setVisible(true);
    }
}
