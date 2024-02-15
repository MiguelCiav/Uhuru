package main.views.listeners;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.ViewsStyles;

import utils.ViewsStyles;

public class ChangeBackground extends MouseAdapter{

    Component settableComponent;

    public ChangeBackground(Component settableComponent){
        this.settableComponent = settableComponent;
    }

    @Override 
    public void mouseClicked(MouseEvent e){

        settableComponent.setBackground(ViewsStyles.LIGHT_SKY_BLUE);
        settableComponent.repaint();

        System.out.println("Hola");

    }
    
}
