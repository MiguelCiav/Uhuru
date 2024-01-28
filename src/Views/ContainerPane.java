package Views;

import javax.swing.*;
import java.awt.*;

public class ContainerPane extends JPanel{

    ContainerPane(Color c){
        setBackground(c);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
    }
}
