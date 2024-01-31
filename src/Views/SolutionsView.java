package Views;

public class SolutionsView extends PrincipalDoublePanel{
    
    private QuestionsSummaryPanel questionsPanel = new QuestionsSummaryPanel();
    private AnswersSummaryPanel answersPanel = new AnswersSummaryPanel();

    SolutionsView (){
        super();
        addPanels();
    }

    @Override
    protected void addPanels() {
        
        setContainerPanel();
        addFirstPanel(questionsPanel);
        addSecondPanel(answersPanel);
        addContainerPanel();

    }

}