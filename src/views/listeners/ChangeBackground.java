package views.listeners;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangeBackground extends MouseAdapter{

    Component settableComponent;

    public ChangeBackground(Component settableComponent){
        this.settableComponent = settableComponent;
    }

    @Override 
    public void mouseClicked(MouseEvent e){

        settableComponent.setBackground(new Color(143, 179, 227));
        settableComponent.repaint();

        System.out.println("Hola");

    }
    
}
