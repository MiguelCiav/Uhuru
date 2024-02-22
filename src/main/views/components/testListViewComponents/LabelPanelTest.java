package main.views.components.testListViewComponents;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.LabelPanel;
import utils.PathManager;
import utils.ViewsStyles;

public class LabelPanelTest extends LabelPanel{

    private String courseID;
    private String testID;
    private JLabel textLabel;
    private JLabel arrowLabel;

    public LabelPanelTest(String courseID, String testID){

        constraints = new GridBagConstraints();
        this.testID = testID;
        this.courseID = courseID;

        setLayout(new GridBagLayout());
        setBackground(ViewsStyles.LIGHT_GRAY);
        setLabel();
        addLabel();

    }

    public String getCourseID(){
        return courseID;
    }

    public String getTestID(){
        return testID;
    }

    @Override
    protected void setLabel() {

        textLabel = new JLabel();
        ;
        String testName = AnswerTestController.getInstance().getTestName(courseID, testID);

        textLabel.setBackground(ViewsStyles.LIGHT_GRAY);
        textLabel.setOpaque(true);
        textLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        textLabel.setFocusable(false);
        textLabel.setText(testName);

        arrowLabel = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testListView/siguiente.png")));

    }

    @Override protected void addLabel() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(textLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;

        add(arrowLabel, constraints);

        arrowLabel.addMouseListener(new GoToTestView());
        
    }
    
}
