package Views;
import javax.swing.*;
import java.awt.*;

public class TestInfoPanel extends JPanel{
    
    private GridBagConstraints constraints;
    private JLabel clock = new JLabel();
    private JLabel answeredQuestions = new JLabel();
    private JLabel testName = new JLabel();
    private BlueButton endButton = new BlueButton("Terminar Examen",233);
    
    TestInfoPanel(){

        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        addTitle();
        addClock();
        addAmountOfAnsweredQuestions();
        addEndButton();

    }

    private void addTitle(){

        constraints.gridx = 0;
        constraints.gridy=0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets= new Insets(10,32,10,30);

        testName.setText("Curso - Nombre del Examen");
        testName.setFont(new Font("Futura", Font.BOLD, 30));
        testName.setForeground(new Color(61,90,128));

        add (testName, constraints);

    }

    private void addClock(){

        constraints.gridx=1;
        constraints.weightx=0.0;
        constraints.anchor = GridBagConstraints.CENTER;

        clock.setIcon(new ImageIcon(getClass().getResource("img/testView/reloj.png")));
        clock.setText("11:11");
        clock.setFont(new Font("Futura", Font.BOLD, 30));
        clock.setForeground(new Color(61,90,128));

        add (clock, constraints);

    }

    private void addAmountOfAnsweredQuestions(){

        constraints.gridx=2;

        answeredQuestions.setIcon(new ImageIcon(getClass().getResource("img/testView/bandera.png")));
        answeredQuestions.setText("1/20");
        answeredQuestions.setFont(new Font("Futura", Font.BOLD, 30));
        answeredQuestions.setForeground(new Color(61,90,128));

        add (answeredQuestions, constraints);

    }

    private void addEndButton(){
        
        constraints.gridx=3;
        constraints.gridwidth = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(5,5,5,5);

        add(endButton, constraints);
        
    }
}
