package views.useCaseFrames;

import java.awt.Dimension;
import javax.swing.JFrame;

import views.swingComponents.DoublePanel;
import views.swingComponents.LabelContainer;
import views.swingComponents.NavBar;
import views.swingComponents.TestListPanel;

public class TestListView extends JFrame{

    private LabelContainer courseContainer;
    private TestListPanel testListPanel = new TestListPanel();
    private DoublePanel doublePanel;

    public TestListView (){
        courseContainer = new LabelContainer("Cursos Activos", LabelContainer.COURSES_CONTAINER);
        doublePanel = new DoublePanel(courseContainer, testListPanel);

        setTitle("Uhuru: Available Tests");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(doublePanel);

        setVisible(true);
    }

}
