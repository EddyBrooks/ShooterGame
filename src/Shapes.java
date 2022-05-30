import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Shapes extends Rectangle{

    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white};
    public Color color;
    public int x1;
    public int y1;
    public static int cubeWidth = 123;
    Random rand = new Random();
    Projectile projectile;

    public Shapes(int x1, int y1){
        super(x1, y1, cubeWidth, cubeWidth);
        this.x1 = x1;
        this.y1 = y1;
        int rand_int1 = rand.nextInt(list.length);
        color = list[rand_int1];
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y+10, cubeWidth-10, cubeWidth-10);
    }
}
