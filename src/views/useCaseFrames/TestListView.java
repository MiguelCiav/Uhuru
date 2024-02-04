package views.useCaseFrames;

import java.awt.Dimension;
import javax.swing.JFrame;

import views.swingComponents.DoublePanel;
import views.swingComponents.ScrollContainer;
import views.swingComponents.ScrollableCoursesPanel;
import views.swingComponents.TestListPanel;

public class TestListView extends JFrame{

    private ScrollContainer scrollContainer;
    private TestListPanel testListPanel = new TestListPanel();
    private DoublePanel doublePanel;

    public TestListView (){
        scrollContainer = new ScrollContainer("Cursos Activos", new ScrollableCoursesPanel());
        doublePanel = new DoublePanel(scrollContainer, testListPanel);

        setTitle("Uhuru: Available Tests");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(doublePanel);

        setVisible(true);
    }

}
