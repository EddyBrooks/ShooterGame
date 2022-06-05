import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Frame extends JFrame{

    JButton button;
    Panel panel;

    Frame(){
        /*
        JLabel label = new JLabel();
        ImageIcon background = new ImageIcon("background.png");
        label.setIcon(background);
        label.setBounds(0, 0, 615, 780);
        label.setVerticalAlignment(JLabel.BOTTOM);
        */

        this.setTitle("Game");
        this.setResizable(false);
        this.setSize(615, 780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //this.setLayout(null);
        this.setVisible(true);
        this.setBackground(new Color(185,150,102));

        /*
        button = new JButton();
        button.setBounds(0, 0, 615/2, 50);
        button.setBackground(new ColorUIResource(143, 125, 99));
        button.setText("Click to start game");
        button.addActionListener(this);
        */
        panel = new Panel();

        //this.add(button);
        //this.add(label);
        this.add(panel);
        panel.setBackground(new Color(185,150,102));
        panel.run();
    }

}
