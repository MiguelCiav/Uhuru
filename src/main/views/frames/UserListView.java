package main.views.frames;

import java.awt.Dimension;

import javax.swing.JFrame;

import main.views.components.DoublePanel;
import main.views.components.ScrollContainer;
import main.views.components.userListViewComponents.ScrollableAdminTestPanel;
import main.views.components.userListViewComponents.ScrollableUsersPanel;

public class UserListView extends JFrame{

    private ScrollContainer usersContainer;
    private ScrollContainer adminTestsContainer;
    private DoublePanel doublePanel;

    public UserListView(){

        usersContainer = new ScrollContainer("Usuarios", new ScrollableUsersPanel(), "Añadir Usuario");
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
