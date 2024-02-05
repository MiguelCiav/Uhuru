package views.swingComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import utils.ViewsStyles;

public class LabelPanelWithTitle extends LabelPanel{

    private String text;
    private JLabel questionTitle;
    private JTextArea questionSummary;
    private int number;
    private String title;

    public LabelPanelWithTitle(int number, String text, String title){

        constraints = new GridBagConstraints();
        this.text = text;
        this.number = number;
        this.title = title;

        setLayout(new GridBagLayout());
        setBackground(ViewsStyles.LIGHT_GRAY);

        setLabel();
        addLabel();
        
    }

    @Override
    protected void setLabel() {

        questionSummary = new JTextArea();
        questionTitle = new JLabel();

        questionSummary.setBackground(ViewsStyles.LIGHT_GRAY);
        questionSummary.setFont(new Font("Futura", Font.PLAIN, 12));
        questionSummary.setEditable(false);
        questionSummary.setFocusable(false);
        questionSummary.setLineWrap(true);
        questionSummary.setText(text);

        questionTitle.setText(title + " " + String.valueOf(number));
        questionTitle.setFont(new Font("Futura", Font.BOLD, 20));
    }

    @Override
    protected void addLabel() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.insets = new Insets(16, 16, 8, 16);

        add(questionTitle, constraints);

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.insets = new Insets(0, 16, 16, 16);

        JScrollPane auxiliarPane = new JBlueScrollPane(questionSummary);
        auxiliarPane.setBorder(null);
        auxiliarPane.setMinimumSize(new Dimension(250,60));
        auxiliarPane.setPreferredSize(new Dimension(250, 60));
        
        auxiliarPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        auxiliarPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(auxiliarPane, constraints);
        
    }
    
}
