import java.awt.*;
import java.awt.event.*;
import java.io.CharArrayReader;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Projectile extends Rectangle{

    int speed = 5;
    Character character;
    Panel panel;
    Color currColor = new ColorUIResource(230, 25, 25);

    Projectile(int x, int y, int PROJ_WIDTH, int PROJ_HEIGHT){
        super(0, 0, PROJ_WIDTH, PROJ_HEIGHT);
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            x = character.x1+(character.width/2-(width/2));
            y = character.y1;
            currColor = character.currColor;
        }
    }
    /*
    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    */
    public void draw(Graphics g){
        g.setColor(currColor);
        g.fillOval(x, y, width, height);

    }
    public void move(){
        this.y = this.y - speed; 
    }

}
