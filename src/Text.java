import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Text extends Rectangle{
    
    static int GAME_WIDTH = 615;
    static int GAME_HEIGHT = 780;
    public static String WASD = " to Shoot";
    public static String spaceText = "SPACEBAR \nTo Shoot";
    public static String lose = "You Lose!";

    Text(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;

    }
    
    public void drawFirst(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.BOLD, 70));
        g.drawString("BLOCK BRIGADE", GAME_WIDTH/2-260, GAME_HEIGHT/3);

        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.BOLD, 30));
        g.drawString("W", GAME_WIDTH/8-20, GAME_HEIGHT/2);
        g.drawString("ASD", GAME_WIDTH/8-38, GAME_HEIGHT/2+25);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString("To Move", GAME_WIDTH/8+20, GAME_HEIGHT/2+10);

        g.setFont(new Font("Consolas", Font.BOLD, 30));
        g.drawString("SPACEBAR", GAME_WIDTH/8*5, GAME_HEIGHT/2+10);

        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString("To Shoot", GAME_WIDTH/8*5, GAME_HEIGHT/2+40);
    
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        g.drawString("CLICK SPACEBAR", GAME_WIDTH/2-160, GAME_HEIGHT/4*3);
        g.drawString("TO START", GAME_WIDTH/2-100, GAME_HEIGHT/4*3+40);
    }

    public void drawLast(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.BOLD, 70));
        g.drawString("YOU LOST", GAME_WIDTH/2-150, GAME_HEIGHT/2);
    }

}
