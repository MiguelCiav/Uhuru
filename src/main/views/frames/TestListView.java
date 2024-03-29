package main.views.frames;

import java.awt.Dimension;
import javax.swing.JFrame;

import main.views.components.genericComponents.DoublePanel;
import main.views.components.genericComponents.ScrollContainer;
import main.views.components.testListViewComponents.ScrollableCoursesPanel;
import main.views.components.testListViewComponents.TestListPanel;

public class TestListView extends JFrame{

    private ScrollContainer scrollableCoursesPanel;
    private TestListPanel testListPanel = new TestListPanel();
    private DoublePanel doublePanel;

    public TestListView (){

        scrollableCoursesPanel = new ScrollContainer("Cursos Activos", ScrollableCoursesPanel.getInstance());
        doublePanel = new DoublePanel(scrollableCoursesPanel, testListPanel);

        setTitle("Uhuru: Available Tests");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(doublePanel);

        setVisible(true);

    }

}
