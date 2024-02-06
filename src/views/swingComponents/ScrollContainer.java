package views.swingComponents;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

public class ScrollContainer extends JPanelRound{

    private String title;
    private String buttonTitle;
    private JLabel titleLabel;
    private GridBagConstraints constraints;
    private ScrollablePanel scrollablePanel;

    public ScrollContainer(String title, ScrollablePanel scrollablePanel){

        this.title = title;
        this.scrollablePanel = scrollablePanel;
        
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);
        constraints = new GridBagConstraints();

        addTitle();
        addScrollablePanel();

    }

    public ScrollContainer(String title, ScrollablePanel scrollablePanel, String buttonTitle){

        this.title = title;
        this.scrollablePanel = scrollablePanel;
        this.buttonTitle = buttonTitle;

        setLayout(new GridBagLayout());
        setRoundBackgroundColor(new Color(255,255,255));
        constraints = new GridBagConstraints();

        addTitle();
        addScrollablePanel();
        addButton();

    }

    private void addTitle() {

        titleLabel = new JLabel(title);

        titleLabel.setFont(new Font("Futura", Font.BOLD, 32));
        titleLabel.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(16, 20, 16, 80);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;

        add(titleLabel, constraints);

    }

    private void addScrollablePanel(){

        JScrollPane auxiliarPanel = new JBlueScrollPane(scrollablePanel);

        constraints.insets = new Insets(0, 20, 0, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;

        auxiliarPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        auxiliarPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        auxiliarPanel.setBorder(null);

        add(auxiliarPanel, constraints);

    }

    private void addButton() {

        JLabel button = new JLabel();

        button.setFont(ViewsStyles.SMALL_TITLE_FONT);
        button.setForeground(Color.BLACK);
        button.setText(buttonTitle);
        button.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/UsersListView/addIcon.png")));
        button.setIconTextGap(16);

        constraints.gridy = 2;
        constraints.weighty = 0.0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(0, 20, 20, 20);

        add(button,constraints);
    }
}
