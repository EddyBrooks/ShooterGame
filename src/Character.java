import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.util.Random;


public class Character extends Rectangle{

    int xVelocity;
    int speed = 2;
    public static Color currColor = new ColorUIResource(230, 25, 25);
    public static int x1;
    public static int y1;
    public static int width;
    Random rand = new Random();
    Projectile projectile;
    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white, Color.pink};

    Character(int x, int y, int CHARACTER_WIDTH, int CHARACTER_HEIGHT){
        super(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
        x1 = x;
        y1 = y;
        width = CHARACTER_WIDTH;
    }

    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_A){
            setXDirection(-speed);
            move();
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            setXDirection(speed);
            move();
        }
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            setColor();
        }
    }
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_A){
            setXDirection(0);
            move();
        }
        if (e.getKeyCode()==KeyEvent.VK_D){
            setXDirection(0);
            move();
        }
    }
    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }
    public void move(){
        x = x + xVelocity;
        x1 = x;
    }

    public void setColor(){
        int rand_int1 = rand.nextInt(list.length);
        currColor = list[rand_int1];
    }

    public void draw(Graphics g){
        g.setColor(currColor);
        g.fillRect(x, y, width, height);
    }

}
