package main.views.frames;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import main.views.components.genericComponents.DoublePanel;
import main.views.components.genericComponents.OpenUserRegisterPopUp;
import main.views.components.genericComponents.ScrollContainer;
import main.views.components.userListViewComponents.ScrollableAdminTestPanel;
import main.views.components.userListViewComponents.ScrollableUsersPanel;
import main.views.listeners.GoToCreateTestView;

public class UserListView extends JFrame{

    private static UserListView instance;

    private ScrollContainer usersContainer;
    private ScrollContainer adminTestsContainer;
    private DoublePanel doublePanel;

    public UserListView(){

        usersContainer = new ScrollContainer("Usuarios", new ScrollableUsersPanel(), "Añadir Usuario");
        JLabel button = usersContainer.getButton();
        button.addMouseListener(new OpenUserRegisterPopUp());

        adminTestsContainer = new ScrollContainer("Examenes", new ScrollableAdminTestPanel(), "Añadir Examen");
        button = adminTestsContainer.getButton();
        button.addMouseListener(new GoToCreateTestView());

        doublePanel = new DoublePanel(usersContainer, adminTestsContainer);

        setTitle("Uhuru: Available Tests");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(doublePanel);

        setVisible(true);
    }

    public static UserListView getInstance(){

        if(instance == null){
            instance = new UserListView();
        }

        return instance;
    }

    public void disposeFrame(){

        instance.dispose();   
    }
}
