import java.awt.*;
import java.awt.event.*;
import java.io.CharArrayReader;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Projectile extends Rectangle{

    int speed = 10;
    public static int y1;
    public static boolean visible;
    Character character;
    Panel panel;
    Color currColor = new ColorUIResource(Color.red);
    static Color lastColor = new ColorUIResource(Color.red);


    Projectile(int x, int y, int PROJ_WIDTH, int PROJ_HEIGHT){
        super(0, 0, PROJ_WIDTH, PROJ_HEIGHT);
        lastColor = currColor;
        visible = false;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            if (y <= 20){
                x = character.x1+(character.width/2-(width/2));
                y = character.y1;
                lastColor = currColor;
                currColor = character.currColor;
            }
        }
    }

    public void draw(Graphics g){
        y1 = y;
        g.setColor(currColor);
        g.fillOval(x, y, width, height);

    }
    public void move(){
        this.y = this.y - speed; 
    }

}
