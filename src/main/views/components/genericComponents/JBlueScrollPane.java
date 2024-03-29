package main.views.components.genericComponents;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import utils.ViewsStyles;


public class JBlueScrollPane extends JScrollPane{

    private double height = 0;
    private int amountOfResize = 0;
    private Component component;

    public JBlueScrollPane(Component panel){
        component=panel;
        setViewportView(panel);
 
        getVerticalScrollBar().setUI(new BasicScrollBarUI(){   
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
    
            @Override    
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = ViewsStyles.DARK_BLUE;
            }
    
            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });

        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBorder(null);
        getVerticalScrollBar().setBackground(Color.WHITE);
        getVerticalScrollBar().setUnitIncrement(6);

        setResizable();
    }

    private void setResizable(){

        addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {


                if(amountOfResize > 1){
                    if(height == 0){
                        height = component.getHeight() * 1.75;
                    }
    
                    component.setPreferredSize(new Dimension(getWidth() - 20, (int) height));
                    component.validate();
                    component.repaint();
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

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAmountOfResize(int amountOfResize) {
        this.amountOfResize = amountOfResize;
    }

    public int getAmountOfResize() {
        return amountOfResize;
    }
    
}