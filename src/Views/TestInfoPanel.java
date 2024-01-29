package Views;
import javax.swing.*;
import java.awt.*;

public class TestInfoPanel extends JPanel{
    
    JLabel clock = new JLabel();
    JLabel answeredQuestions = new JLabel();
    JLabel testName = new JLabel();
    BlueButton endButton = new BlueButton("Terminar Examen",233);
    
    TestInfoPanel(){
        //defino color y tipo de layout
        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        initializePanel();
    }

    private void initializePanel(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy=0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,32,10,30);

        testName.setText("Curso - Nombre del Examen");
        testName.setFont(new Font("Futura", Font.BOLD, 25));
        testName.setForeground(new Color(61,90,128));
        add (testName, constraints);

        //reloj
        constraints.gridx=1;
        constraints.weightx=0;
        constraints.anchor = GridBagConstraints.CENTER;
        clock.setIcon(new ImageIcon(getClass().getResource("img/testView/reloj.png")));
        clock.setText("11:11");
        clock.setFont(new Font("Futura", Font.BOLD, 16));
        clock.setForeground(new Color(61,90,128));
        add (clock, constraints);

        //bandera
        constraints.gridx=2;
        answeredQuestions.setIcon(new ImageIcon(getClass().getResource("img/testView/bandera.png")));
        answeredQuestions.setText("1/20");
        answeredQuestions.setFont(new Font("Futura", Font.BOLD, 20));
        answeredQuestions.setForeground(new Color(61,90,128));
        add (answeredQuestions, constraints);
        
        //boton
        constraints.gridx=3;
        constraints.gridwidth = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(5,5,5,5);

        add(endButton, constraints);
        
    }
}
