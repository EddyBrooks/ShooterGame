import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Frame extends JFrame{

    Frame(){

        JLabel label = new JLabel();
        ImageIcon background = new ImageIcon("background.png");
        label.setIcon(background);
        label.setBounds(0, 0, 615, 780);
        label.setVerticalAlignment(JLabel.BOTTOM);


        this.setTitle("Game");
        this.setResizable(false);
        this.setSize(615, 780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(new Color(185,150,102));

        Panel panel = new Panel();
        this.add(panel);
        panel.setBackground(new Color(185,150,102));
        panel.run();
        //this.add(label);



    }
}
