package main.views.components.testListViewComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.views.components.genericComponents.JBlueScrollPane;
import main.views.components.genericComponents.LabelPanel;
import utils.ViewsStyles;

public class LabelPanelCourse extends LabelPanel{

    private String courseName;
    private JTextArea courseNameText;
    private String courseID;

    public LabelPanelCourse(String courseName, String courseID){

        constraints = new GridBagConstraints();
        this.courseName = courseName;
        this.courseID = courseID;

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));

        setLabel();
        addLabel();
        
    }

    @Override
    protected void setLabel() {

        courseNameText = new JTextArea();

        courseNameText.setBackground(new Color(216,233,241));
        courseNameText.setFont(new Font("Futura", Font.PLAIN, 12));
        courseNameText.setEditable(false);
        courseNameText.setFocusable(false);
        courseNameText.setLineWrap(true);
        courseNameText.setText(courseName);

    }

    @Override
    protected void addLabel() {

        JLabel courseTitle = new JLabel("Curso " + courseID);
        courseTitle.setFont(ViewsStyles.SMALL_TITLE_FONT);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(16, 16, 8, 16);

        add(courseTitle, constraints);

        constraints.gridy = 1;
        constraints.insets = new Insets(0, 16, 16, 16);

        JScrollPane auxiliarPane = new JBlueScrollPane(courseNameText);
        auxiliarPane.setBorder(null);
        auxiliarPane.setMinimumSize(new Dimension(250,40));
        auxiliarPane.setPreferredSize(new Dimension(250, 40));
        
        auxiliarPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        auxiliarPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(auxiliarPane, constraints);
        
    }
    
}
