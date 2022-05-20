import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Character extends Rectangle{

    int xVelocity;

    Character(int x, int y, int CHARACTER_WIDTH, int CHARACTER_HEIGHT){
        super(x, y, CHARACTER_WIDTH, CHARACTER_HEIGHT);
    }

    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
    public void setXDirection(int xDirection){

    }
    public void move(){

    }

    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

}
