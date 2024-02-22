package main.views.components.testViewComponents;
import javax.swing.*;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.BlueButton;
import utils.PathManager;
import utils.ViewsStyles;

import java.awt.*;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Timer;

public class TestInfoPanel extends JPanel{
    
    private GridBagConstraints constraints;
    private JLabel clock = new JLabel();
    private JLabel answeredQuestions = new JLabel();
    private JLabel testName = new JLabel();
    private BlueButton endButton = new BlueButton("Terminar Examen",233,1);
    private static TestInfoPanel testInfoPanel;
    private int totalAnswered = 0;
    private ArrayList<String> answeredQuestionIDs = new ArrayList<String>();
    private int questionsAmount = 0;
    private int testDuration;
    ScheduledExecutorService executor;

    private TestInfoPanel(){

        setBackground(Color.WHITE);
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

        totalAnswered++;
        answeredQuestions.setText(String.valueOf(totalAnswered) + "/" + questionsAmount);
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
        testName.setForeground(ViewsStyles.DARK_BLUE);

        add (testName, constraints);

    }

    private void addClock(){

        constraints.gridx=1;
        constraints.weightx=0.0;
        constraints.anchor = GridBagConstraints.CENTER;

        clock.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testView/reloj.png")));
        clock.setText("11:11");
        clock.setFont(new Font("Futura", Font.BOLD, 30));
        clock.setForeground(ViewsStyles.DARK_BLUE);
        clock.setIconTextGap(16);

        add (clock, constraints);

    }

    private void addAmountOfAnsweredQuestions(){
        
        constraints.gridx=2;

        answeredQuestions.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testView/bandera.png")));
        answeredQuestions.setText("0" + "/" + questionsAmount);
        answeredQuestions.setFont(new Font("Futura", Font.BOLD, 30));
        answeredQuestions.setForeground(ViewsStyles.DARK_BLUE);
        answeredQuestions.setIconTextGap(16);

        add (answeredQuestions, constraints);

    }

    public void updateTestInfo(){
        int testTime = AnswerTestController.getCurrentTestTime();
        questionsAmount = AnswerTestController.getCurrentTestQuestionsAmount();
        answeredQuestionIDs.clear();
        totalAnswered = 0;

        answeredQuestions.setText("0" + "/" + questionsAmount);
        updateTimer(testTime);
        this.testName.setText(AnswerTestController.getCurrentTestName());
    }

    public boolean updateAnsweredQuestions(String questionID){

        for(String ID : answeredQuestionIDs){
            if(ID.equals(questionID)){
                return false;
            }
        }

        answeredQuestionIDs.add(questionID);
        increaseAnswers();
        return true;

    }

    private void addEndButton(){
        
        constraints.gridx=3;
        constraints.gridwidth = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.insets= new Insets(5,5,5,5);

        endButton.addActionListener(new EndTest());

        add(endButton, constraints);
        
    }

    private void updateTimer(int minutesInput) {
        final int TIME_UNIT = 1;

        setDuration(minutesInput);
        

        if(executor != null && !executor.isShutdown()){
            executor.shutdown();
        }

        executor = Executors.newSingleThreadScheduledExecutor();
        
        executor.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                int totalSeconds = getDuration();
                int hours = totalSeconds / 3600;
                int minutes = (totalSeconds % 3600) / 60;
                int seconds = totalSeconds % 60;

                clock.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));

                decreaseDuration();

                if (totalSeconds <= 0) {
                    executor.shutdown();
                    clock.setText("Tiempo Agotado");
                }
            }
        }, 0, TIME_UNIT, TimeUnit.SECONDS);

    }

    private void setDuration(int minutesInput){
        testDuration = 60 * minutesInput;
    }
    
    private void decreaseDuration(){
        testDuration--;
    }

    private int getDuration(){
        return testDuration;
    }


    /*¨private void updateTimer(int minutesInput) {
        final int TIME_UNIT = 1000;
        final long DELAY = 0;

        if(timer.)
        
        timer.scheduleAtFixedRate(new TestTimer(minutesInput, timer), DELAY, TIME_UNIT);
    }
    
    private class TestTimer extends TimerTask {
        private Timer timer;
        private int totalSeconds;
        private int minutes;
        private int hours;
        private int seconds;
    
        TestTimer(int minutesInput, Timer timer) {
            totalSeconds = minutesInput * 60;
            this.timer = timer;
        }
    
        public void run() {
            convertTime();
    
            clock.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    
            totalSeconds--;
    
            if (totalSeconds <= 0) {
                timer.cancel();
                clock.setText("Tiempo Agotado");
            }
        }
    
        private void convertTime() {
            hours = totalSeconds / 3600;
            minutes = (totalSeconds % 3600) / 60;
            seconds = totalSeconds % 60;
        }
    }*/
    
    
    /*private void updateTimer (int minutesInput){
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
        private int seconds;

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
                clock.setText(hours + ":" + minutes);
                minutesTOTAL--; 
            }
            
            if (minutesTOTAL <= 0) {
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

    }*/

    public void setAnsweredQuestions (String input){
        answeredQuestions.setText(input);
    }

}
