package views.useCaseFrames;

import javax.swing.*;
import views.swingComponents.LoginPopUp;
import views.swingComponents.PathManager;
import java.awt.*;

public class LoginFrame extends JFrame{

    private ImageIcon uhuruLogo = new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/loginView/loginBackground.jpg")));
    private JLabel background = new JLabel();
    private GridBagConstraints constraints = new GridBagConstraints();
    
    LoginFrame(){

        super("Uhuru");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());

        Image image1 = uhuruLogo.getImage();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Image image2 = image1.getScaledInstance(width, height, DO_NOTHING_ON_CLOSE);
        background.setIcon(new ImageIcon(image2));
        
        background.setLayout(new GridBagLayout());

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;

        background.add(new LoginPopUp(), constraints);

        add(background);

        setVisible(true);
    }
}
