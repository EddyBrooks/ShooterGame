import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Frame extends JFrame{

    Frame(){
        JLabel label = new JLabel();
        ImageIcon Background = new ImageIcon("background.png");
        label.setIcon(Background);
        label.setBounds(0, 0, 615, 780);


        this.setTitle("Game");
        this.setResizable(false);
        this.setSize(615, 780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(label);
        Panel panel = new Panel();
        panel.run();
    }
}
