import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.util.Random;


public class Character extends Rectangle{

    int xVelocity;
    int speed = 6;
    public static Color currColor = new ColorUIResource(Color.red);
    public static int x1;
    public static int y1;
    public static int width;
    public static boolean visible;
    Random rand = new Random();
    Projectile projectile;
    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white};

    Character(int x, int y, int CHARACTER_WIDTH, int CHARACTER_HEIGHT){
        super(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
        x1 = x;
        y1 = y;
        width = CHARACTER_WIDTH;
        visible = false;
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
            if (projectile.y1 <= 20){
                setColor();
            }

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
        if (visible){
            g.setColor(currColor);
            g.fillRect(x, y, width, height);
            g.fillRect(x+(width/2)-(height/2), y-width/4, height+1, width/4);
            g.setColor(Color.gray);
            g.drawLine(x+(width/2), y, x+(width/2), -100);
        }
    }

}
