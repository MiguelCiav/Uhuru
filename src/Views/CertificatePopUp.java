package Views;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;


public class CertificatePopUp extends JPanelRound{

    GridBagConstraints constraints;
    private ScrollableCertificateList scroll;
    private JScrollPane scrollPanel;
    private double height = 0;
    private int amountOfResize = 0;

    CertificatePopUp(){
        constraints = new GridBagConstraints();

        setRoundBackgroundColor(new Color(255,255,255));
        setLayout(new GridBagLayout());
        setBorder(null);
        setMinimumSize(new Dimension(863,550));
        addExitButton();
        addTitle();
        
        setScrollableCertificateList();
        addScrollablePanel();

    }

    public void addTitle(){
        JLabel title = new JLabel();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets= new Insets(50,35,30,10);

        title.setFont(new Font("Futura", Font.BOLD, 30));
        title.setForeground(new Color(61,90,128));
        title.setText("Obtener Certificado");

        add(title, constraints);
    }

    public void addExitButton(){

        PathManager exitButtonImageURL = new PathManager();
        JLabel exitButton = new JLabel();
        
        constraints.gridx=1;
        constraints.weightx=0.0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(10,0,10,30);
        exitButton.setIcon(new ImageIcon(exitButtonImageURL.setFileLink("img\\testView\\reloj.png")));
        add(exitButton, constraints);
    }

    private void setScrollableCertificateList (){
        scroll = new ScrollableCertificateList();
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
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.gridheight = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets= new Insets(20,10,20,10);
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPanel, constraints);

    }

}
