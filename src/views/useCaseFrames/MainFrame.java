package views.useCaseFrames;

import views.swingComponents.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame{
    
    private ImageIcon uhuruLogo = new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/mainView/mainFrameImage.jpg")));
    private JLabel uhuruLogoButton = new JLabel();

    public MainFrame(){

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
            new LoginFrame();
            this.dispose();
        } catch (InterruptedException e){ }
        
    }
}