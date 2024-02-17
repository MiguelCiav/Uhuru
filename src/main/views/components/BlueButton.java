package main.views.components;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import utils.ViewsStyles;

public class BlueButton extends JButton implements ActionListener{

    private Color primaryColor;
    private Color secondaryColor;

    public BlueButton(String buttonName, int width, int type){
        
        super(buttonName);

        setFont(new Font("Futura", Font.BOLD, 18));
        setFocusPainted(false);
        setPreferredSize(new Dimension(width, 65));
        setMinimumSize(new Dimension(width, 65));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        if (type==1) {
            setForeground(Color.WHITE);
            primaryColor = ViewsStyles.DARK_BLUE;
            secondaryColor = ViewsStyles.LIGHT_BLUE;
        }
        else if (type==2){
            setForeground(ViewsStyles.DARK_BLUE);
            primaryColor = ViewsStyles.LIGHT_BLUE;
            secondaryColor = ViewsStyles.ULTRA_LIGHT_BLUE;
        }
        else if(type==3){
            setForeground(ViewsStyles.DARK_BLUE);
            primaryColor = Color.WHITE;
            secondaryColor = ViewsStyles.LIGHT_BLUE;
        }
        else if(type == 4){
            setForeground(ViewsStyles.DARK_BLUE);
            primaryColor = Color.GREEN;
            secondaryColor = Color.WHITE;
        }

    }

    @Override public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
    }

    protected void paintComponent(Graphics graphic) {
        Color colorOne,colorTwo;
        Graphics2D mainGraphic = (Graphics2D) graphic;
        mainGraphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel buttonModel = getModel();

        Paint oldPaint = mainGraphic.getPaint();

        if (buttonModel.isArmed() || !buttonModel.isEnabled()){
           colorOne=secondaryColor;
           colorTwo=secondaryColor;
        }else{
           colorTwo=primaryColor;
           colorOne=primaryColor;
        }
        
        RoundRectangle2D.Float roundRectangle = new RoundRectangle2D.Float( 0,0,getWidth(),getHeight()-1,40,40);
        mainGraphic.clip(roundRectangle);
        mainGraphic.setPaint(new GradientPaint(0.0f, 0.0f, colorOne,0.0f, getHeight(), colorTwo));
        mainGraphic.fillRect(0,0,getWidth(),getHeight());
        mainGraphic.setStroke(new BasicStroke(0));
        mainGraphic.drawRoundRect(0, 0, getWidth()-2 , getHeight() -2, 18, 18);

        mainGraphic.setPaint(oldPaint);
        super.paintComponent(graphic);
    }
}
