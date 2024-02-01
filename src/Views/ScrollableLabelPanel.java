package Views;

import javax.swing.*;
import java.awt.*;

public class ScrollableLabelPanel extends JPanel{

    static final int QUESTIONS_SCROLL = 0;
    static final int COURSES_SCROLL = 1;
    static final int TEST_SCROLL = 2;

    ScrollableLabelPanel(int type){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(255,255,255));
        setBackground(new Color(255,255,255));

        if(type == QUESTIONS_SCROLL){
            addQuestionsScroll();
        }

        if(type == COURSES_SCROLL){
            addCoursesScroll();
        }

        if(type == TEST_SCROLL){
            addTestScroll();
        }

    }
    
    private void addQuestionsScroll(){
        for(int i = 0; i < 5; i++){
            add(new LabelSummary(i, "AFSFAWFQASFQWFDASFWASFQWFASFWQXFAWFQWSFDASFASFASFRASFAFQFAFWASFQWFASFWQFASFWQQASFWQASFWASFWAFS"));
            add(Box.createRigidArea(new Dimension(0,20)));
        }   
    }

    private void addTestScroll(){
        for(int i = 0; i < 5; i++){
            add(new LabelSummary("Test " + String.valueOf(i)));
            add(Box.createRigidArea(new Dimension(0,20)));
        } 
    }

    public void addCoursesScroll(){

    }

}
