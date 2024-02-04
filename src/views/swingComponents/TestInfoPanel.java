package views.swingComponents;
import javax.swing.*;

import views.listeners.GoToSolutionsView;

import java.awt.*;
import java.nio.file.Path;
import java.util.TimerTask;
import java.util.Timer;

public class TestInfoPanel extends JPanel{
    
    private GridBagConstraints constraints;
    private JLabel clock = new JLabel();
    private JLabel answeredQuestions = new JLabel();
    private JLabel testName = new JLabel();
    private BlueButton endButton = new BlueButton("Terminar Examen",233,1);
    private static TestInfoPanel testInfoPanel;
    private int amountOfAnswers = 0;

    private TestInfoPanel(){

        setBackground(new Color(255,255,255));
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        addTitle();
        addClock();
        addAmountOfAnsweredQuestions();
        addEndButton();
        updateTimer(60);

    }

    public static TestInfoPanel getTestInfoPanel(){

        if(testInfoPanel == null){
            testInfoPanel = new TestInfoPanel();
        }

        return testInfoPanel;
    }

    public void increaseAnswers(){

        amountOfAnswers++;
        answeredQuestions.setText(String.valueOf(amountOfAnswers) + "/" + 20);
        repaint();
        
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

        clock.setIcon(new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/testView/reloj.png"))));
        clock.setText("11:11");
        clock.setFont(new Font("Futura", Font.BOLD, 30));
        clock.setForeground(new Color(61,90,128));
        clock.setIconTextGap(16);

        add (clock, constraints);

    }

    private void addAmountOfAnsweredQuestions(){
        
        constraints.gridx=2;

        answeredQuestions.setIcon(new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/testView/bandera.png"))));
        answeredQuestions.setText("1/20");
        answeredQuestions.setFont(new Font("Futura", Font.BOLD, 30));
        answeredQuestions.setForeground(new Color(61,90,128));
        answeredQuestions.setIconTextGap(16);

        add (answeredQuestions, constraints);

    }

    private void addEndButton(){
        
        constraints.gridx=3;
        constraints.gridwidth = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(5,5,5,5);

        endButton.addActionListener(new GoToSolutionsView());

        add(endButton, constraints);
        
    }

    private void updateTimer (int minutesInput){
        final int TIME_UNIT = 60000;
        final long DELAY = 0;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TestTimer(minutesInput, timer), DELAY, TIME_UNIT);
    }

    private class TestTimer extends TimerTask {
        private Timer timer;
        private int minutesTOTAL;
        private int minutes;
        private int hours;

        TestTimer(int minutesInput, Timer timer) {
            minutesTOTAL= minutesInput;
            this.timer = timer;

        }

        public void run() {
            convertTime();
            if (minutes <= 9) {
                clock.setText(hours + ":0" + minutes);
                minutesTOTAL--;        
            }
            else{
                clock.setText(hours+ ":" + minutes);
                minutesTOTAL--; 
            }
            
            if (minutesTOTAL < 0) {
                timer.cancel();
                clock.setText("Tiempo Agotado");
            }
        }

        private void convertTime(){
            if(minutesTOTAL >= 60){
                hours = minutesTOTAL/60;
                minutes = minutesTOTAL%60;
            }
            else{
                minutes=minutesTOTAL;
                hours = 0;
            }

        }

    }

    public void setAnsweredQuestions (String input){
        answeredQuestions.setText(input);
    }

}
