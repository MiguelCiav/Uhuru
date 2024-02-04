package views.useCaseFrames;

import views.swingComponents.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
    
    private ImageIcon uhuruLogo = new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/mainView/mainFrameImage.jpg")));
    private JButton uhuruLogoButton = new JButton();

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
        uhuruLogoButton.addActionListener(this);
        add(uhuruLogoButton);

        setVisible(true);
    }

    @Override public void actionPerformed(ActionEvent e){
        setVisible(false);
        new LoginFrame();
    }
}