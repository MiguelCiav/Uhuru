package Views;
import javax.swing.*;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

public class JPanelTransparent extends JPanel {

    private float tran= 0.2f;

    public JPanelTransparent(){
        setBackground(new Color(0,0,0,0));
        setLayout(new GridBagLayout());
        add(new CertificatePopUp());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite old = (AlphaComposite) g2.getComposite(); //salva composición actual del panel
        g2.setComposite(AlphaComposite.SrcOver.derive(getTran())); //le damos nueva info
        super.paintComponent(g); //para que los componentes agregados se dibujen
        g2.setComposite(old); //restaura la composición
    }
    
    public float getTran() {
        return tran;
    }
    
    public void setTran(float tran) {
        this.tran = tran;
    }
    
    
}
