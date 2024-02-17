package main.views.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.views.components.genericComponents.DoublePanel;
import main.views.components.genericComponents.OpenUserRegisterPopUp;
import main.views.components.genericComponents.ScrollContainer;
import main.views.components.userListViewComponents.ScrollableAdminTestPanel;
import main.views.components.userListViewComponents.ScrollableUsersPanel;

public class UserListView extends JFrame{

    private ScrollContainer usersContainer;
    private ScrollContainer adminTestsContainer;
    private DoublePanel doublePanel;

    public UserListView(){

        usersContainer = new ScrollContainer("Usuarios", new ScrollableUsersPanel(), "Añadir Usuario");
        JLabel button = usersContainer.getButton();
        button.addMouseListener(new OpenUserRegisterPopUp());

        adminTestsContainer = new ScrollContainer("Examenes", new ScrollableAdminTestPanel(), "Añadir Examen");
        doublePanel = new DoublePanel(usersContainer, adminTestsContainer);

        setTitle("Uhuru: Available Tests");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(doublePanel);

        setVisible(true);
        
    }
}
