package Views;

public class SolutionsView extends abstractDoublePanel{
    
    private LabelContainer questionsSummaryPanel;
    private AnswersSummaryPanel answersSummaryPanel = new AnswersSummaryPanel();

    SolutionsView (){
        super();
        questionsSummaryPanel = new LabelContainer("Preguntas", LabelContainer.QUESTIONS_CONTAINER);
        addPanels();
    }

    @Override
    protected void addPanels() {
        
        setContainerPanel();
        addFirstPanel(questionsSummaryPanel);
        addSecondPanel(answersSummaryPanel);
        addContainerPanel();

    }

}