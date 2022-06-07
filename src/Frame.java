import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Frame extends JFrame{

    JButton button;
    Panel panel;

    Frame(){

        this.setTitle("Game");
        this.setResizable(false);
        this.setSize(615, 780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(new Color(185,150,102));

        panel = new Panel();
        this.add(panel);
        panel.setBackground(new Color(185,150,102));
        panel.run();

    }

    
}
