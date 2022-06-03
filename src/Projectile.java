import com.sun.security.jgss.GSSUtil;

import java.awt.*;
import java.awt.event.*;
import java.io.CharArrayReader;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Projectile extends Rectangle{

    int avSpeed = 10;
    double ySpeed;
    double xSpeed;
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
        Point mousePos = MouseInfo.getPointerInfo().getLocation();

        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            x = character.x1+(character.width/2-(width/2));
            y = character.y1;
            lastColor = currColor;
            currColor = character.currColor;

            int xDiff = (int) (mousePos.getX() - x);
            int yDiff = (int) (mousePos.getY() - y);

            System.out.println("MousePos : " + mousePos.getX() + ", " + mousePos.getY() + ", CharPos : " + x + ", " + character.y1);

            double r = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));

            xSpeed = xDiff / r;
            ySpeed = yDiff / r;
            System.out.println("R: " + r + ", diff: " + xDiff + ", " + yDiff + " Speed: " + xSpeed + ", " + ySpeed);
        }
    }

    public void draw(Graphics g){
        g.setColor(currColor);
        g.fillOval(x, y, width, height);

    }
    public void move() {
        this.y = this.y - (int) ySpeed;
        this.x = this.x - (int) xSpeed;
    }

}
