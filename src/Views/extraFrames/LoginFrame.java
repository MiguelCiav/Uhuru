package Views.extraFrames;

import javax.swing.*;
import Views.swingComponents.PathManager;
import java.awt.*;
import java.io.File;

public class LoginFrame extends JFrame{

    private ImageIcon uhuruLogo = new ImageIcon(new PathManager().setFileLink("src" + File.separator + "Views" + File.separator + "img" + File.separator + "loginView" + File.separator + "loginBackground.jpg"));
    private JLabel background = new JLabel();
    
    LoginFrame(){

        super("Uhuru");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image image1 = uhuruLogo.getImage();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Image image2 = image1.getScaledInstance(width, height, DO_NOTHING_ON_CLOSE);

        background.setIcon(new ImageIcon(image2));
        add(background);

        setVisible(true);
    }
}
