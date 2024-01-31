package Views;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class QuestionsListPanel extends JPanelRound{

    private GridBagConstraints constraints;
    private double height = 0;
    private int amountOfResize = 0;
    private ScrollableQuestionsPanel scroll;
    private JScrollPane scrollPanel;

    QuestionsListPanel(){

        setRoundBackgroundColor(new Color(255,255,255));
        setLayout(new GridBagLayout());
        
        constraints = new GridBagConstraints();

        addTestInfoPanel();
        setScrollableQuestionsPanel();
        addScrollablePanel();

    }

    private void addTestInfoPanel(){

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(10,0,10,10);

        add(new TestInfoPanel(), constraints);
    }

    private void setScrollableQuestionsPanel(){

        scroll = new ScrollableQuestionsPanel();
        scrollPanel = new JScrollPane(scroll);

        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setBorder(null);
        scrollPanel.getVerticalScrollBar().setBackground(new Color(255,255,255));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(6);

        scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(61, 90, 128);
            }
        });

        setResizable();

    }

    private void setResizable(){

        scrollPanel.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {

                System.out.println("resiziao");

                if(amountOfResize > 1){
                    if(height == 0){
                        height = scroll.getHeight() * 1.75;
                    }
    
                    scroll.setPreferredSize(new Dimension(scrollPanel.getWidth() - 20, (int) height));
                    scroll.validate();
                    scroll.repaint();
                }

                amountOfResize++;
                
            }

            @Override
            public void componentMoved(ComponentEvent e) {}

            @Override
            public void componentShown(ComponentEvent e) {}

            @Override
            public void componentHidden(ComponentEvent e) {}
            
        });

    }

    private void addScrollablePanel(){

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets= new Insets(20,20,20,20);
        
        add(scrollPanel, constraints);

    }
    
}

