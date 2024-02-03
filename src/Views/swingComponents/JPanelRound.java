package views.swingComponents;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints; 
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class JPanelRound extends JPanel{

    private Color roundBackgroundColor = new Color(217,233,241);
    private int horizontalAngle=30;
    private int verticalAngle=30;
   
    public JPanelRound() {
        super();
        setOpaque(false);
    }
   
     @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D mainGraphic = (Graphics2D) graphic;
        mainGraphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
       
        Paint oldPaint = mainGraphic.getPaint();
        RoundRectangle2D.Float roundRectangle = new RoundRectangle2D.Float(0,0,getWidth(),getHeight()-1,gethorizontalAngle(),getverticalAngle());
        mainGraphic.clip(roundRectangle);
        mainGraphic.setPaint(oldPaint);
        mainGraphic.setPaint(roundBackgroundColor);
        mainGraphic.fillRect(0,0,getWidth(),getHeight());
        mainGraphic.setStroke(new BasicStroke(0));
        mainGraphic.setPaint(new GradientPaint(0.0f, 0.0f,getRoundBackgroundColor(),0.0f, getHeight(), getRoundBackgroundColor()));
        mainGraphic.drawRoundRect(0, 0, getWidth()-2 , getHeight() -2, 18, 18);
       
        mainGraphic.setPaint(oldPaint);
        super.paintComponent(graphic);
    }

    public Color getRoundBackgroundColor() {
        return roundBackgroundColor;
    }

    public void setRoundBackgroundColor(Color color) {
        this.roundBackgroundColor = color;
    }

    public int gethorizontalAngle() {
        return horizontalAngle;
    }

    public void sethorizontalAngle(int horizontalAngle) {
        this.horizontalAngle = horizontalAngle;
    }

    public int getverticalAngle() {
        return verticalAngle;
    }

    public void setverticalAngle(int verticalAngle) {
        this.verticalAngle = verticalAngle;
    }
}