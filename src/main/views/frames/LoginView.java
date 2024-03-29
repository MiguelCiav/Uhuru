package main.views.frames;

import javax.swing.*;

import main.views.components.loginViewComponents.LoginPopUp;
import utils.PathManager;
import utils.ViewsStyles;

import java.awt.*;

public class LoginView extends JFrame{

    private static LoginView instance;
    
    private ImageIcon uhuruLogo = new ImageIcon(PathManager.getInstance().getStringURL("/src/img/loginView/loginBackground.jpg"));
    private ImageIcon iconLogo = new ImageIcon(PathManager.getInstance().getStringURL("/src/img/iconWhiteMini.png"));
    private JLabel background = new JLabel();
    private JPanel iconPanel = new JPanel();
    private JLabel icon = new JLabel();
    private GridBagConstraints constraints = new GridBagConstraints();
    
    private LoginView(){
    
        super("Uhuru");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

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

        background.add(new LoginPopUp(),constraints);

        add(background, BorderLayout.CENTER);
        Image image3 = iconLogo.getImage();
        icon.setIcon(new ImageIcon(image3));
        iconPanel.setLayout(new GridBagLayout());
        iconPanel.setBackground(ViewsStyles.DARK_BLUE);

        constraints.insets=new Insets(20,20,0,0);
        constraints.weightx=1;
        constraints.anchor=GridBagConstraints.WEST;

        iconPanel.add(icon,constraints);

        add(iconPanel, BorderLayout.NORTH);

        setVisible(true);

    }

    public static LoginView getInstance(){

        if(instance == null){
            instance = new LoginView();
        }

        return instance;
    }

    public void disposeFrame(){

        instance.dispose();
        
    }
}
