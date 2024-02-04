package Views.useCaseFrames;

import java.awt.Dimension;
import javax.swing.JFrame;

import Views.swingComponents.DoublePanel;
import Views.swingComponents.JPanelTransparent;
import Views.swingComponents.LabelContainer;
import Views.swingComponents.TestListPanel;
import Views.swingComponents.NavBar;

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
