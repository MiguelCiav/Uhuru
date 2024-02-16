package main.views.frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.PathManager;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class StartView extends JFrame{

    private ImageIcon uhuruLogo = new ImageIcon(PathManager.getInstance().getStringURL("/src/img/mainView/mainFrameImage.jpg"));
    private JLabel uhuruLogoButton = new JLabel();

    public StartView(){

        super("Uhuru");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image image1 = uhuruLogo.getImage();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Image image2 = image1.getScaledInstance(width, height, DO_NOTHING_ON_CLOSE);

        uhuruLogoButton.setIcon(new ImageIcon(image2));
        add(uhuruLogoButton);

        setVisible(true);

        try {
            TimeUnit.SECONDS.sleep(1);
            LoginView.getInstance();
            dispose();
        } catch (InterruptedException e){ }
        
    }
}