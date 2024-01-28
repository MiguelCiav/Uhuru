package Views;

import javax.swing.*;
import java.awt.*;

public class TestView extends JFrame{

    PrincipalPanel testViewPanel = new PrincipalPanel();
    JPanel panelito = new JPanel();

    TestView(){
        super("Uhuru");
        setSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        panelito.add(new BlueButton("Hola",500));

        testViewPanel.setContentPanel(panelito);
        add(testViewPanel);

        setVisible(true);
    }
}
