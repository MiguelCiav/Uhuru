package views.swingComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelPanelUser extends LabelPanel{

    private String username;

    public LabelPanelUser(String username){
        constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));
        setLabel();
        addLabel();
    }

    @Override
    protected void setLabel() {
        JLabel textLabel = new JLabel();

        textLabel.setBackground(new Color(216,233,241));
        textLabel.setOpaque(true);
        textLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        textLabel.setFocusable(false);
        textLabel.setText(username);
    }

    @Override
    protected void addLabel() {
        
    }
    
}
