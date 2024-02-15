package main.views.components;
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
 

        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setBorder(null);
        getVerticalScrollBar().setBackground(Color.WHITE);
        getVerticalScrollBar().setUnitIncrement(6);

        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = ViewsStyles.DARK_BLUE;
            }
        });

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