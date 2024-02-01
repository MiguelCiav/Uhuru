package Views;

public class TestListView extends abstractDoublePanel{

    private LabelContainer courseContainer;
    private TestListPanel testListPanel = new TestListPanel();

    TestListView (){
        super();
        courseContainer = new LabelContainer("Cursos Activos", LabelContainer.COURSES_CONTAINER);
        addPanels();
    }

    @Override
    protected void addPanels() {
        
        setContainerPanel();
        addFirstPanel(courseContainer);
        addSecondPanel(testListPanel);
        addContainerPanel();

    }

}
