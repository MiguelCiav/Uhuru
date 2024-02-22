package main.views.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.controllers.CreateTestController;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.genericComponents.BlueButton;
import main.views.frames.AddQuestionsFrame;
import main.views.frames.UserListView;

public class AddImageListener implements ActionListener{
    
    private static AddImageListener instance;
    private static String filePath;

    private AddImageListener(){
    }

    public static AddImageListener getInstance(){
        if(instance == null){
            instance = new AddImageListener();
        }

        return instance;
    }

    public static String getFilePath(){
        return filePath;
    }

    @Override public void actionPerformed(ActionEvent e){
        if(!QuestionDataPanel.getBox().isSelected()){
            JFileChooser jf = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG & JPG & JPEG", "png" ,"jpg" , "jpeg");
            jf.setFileFilter(filter);
            
            int response = jf.showOpenDialog(jf);
    
            if(response == JFileChooser.APPROVE_OPTION){
                filePath = jf.getSelectedFile().getPath();
                QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).setImagePath(filePath);
            }
        }
    }
}