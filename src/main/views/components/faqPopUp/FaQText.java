package main.views.components.faqPopUp;
import main.views.components.genericComponents.JPanelRound;
import utils.ViewsStyles;
import java.awt.*;
import javax.swing.*;

public class FaQText extends JPanelRound{
    private GridBagConstraints constraints;
    private JLabel text;
    
    public FaQText(){
        setBackground(ViewsStyles.LIGHT_SKY_BLUE);
        setLayout(new GridBagLayout());
        setBorder(null);
        constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(0,20,10,30);
        generateText("Pregunta 1");
        add(text,constraints);

        generateText("Pregunta 2");
        constraints.gridy = 1;
        add(text,constraints);

        generateText("Pregunta 3");
        constraints.gridy = 2;
        add(text,constraints);

        generateText("Pregunta 4");
        constraints.gridy = 3;
        add(text,constraints);

        generateText("Pregunta 5");
        constraints.gridy = 4;
        add(text,constraints);

    }

    private void generateText(String Title){
        text=new JLabel();
        text.setFont(new Font("Futura", Font.PLAIN, 16));
        String contenido = new String(
            "<html>" +
            "<h1>"+ Title + "</h1>\n" + 
            "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas mattis venenatis metus, et ornare risus <br>" + 
            "finibus et. Nunc ac purus nisi. Vivamus ultricies nisi nec rhoncus facilisis. Integer libero diam, tincidunt <br>" + 
            "sit amet cursus non, imperdiet tincidunt leo. Donec eget dolor a nulla dignissim ullamcorper. Proin tempor <br>" +
            "augue ac nulla pharetra, in pulvinar diam volutpat. Sed in dui risus. Integer et mauris pharetra quam tincidunt<br>" + 
            "commodo. Vivamus lacinia dolor sed libero efficitur eleifend. Aenean tincidunt ut purus vel scelerisque.</p>" + 
            "</html>");
        
        text.setText(contenido);
    }
}
