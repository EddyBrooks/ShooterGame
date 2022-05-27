import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Health extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int plyrLives;

    Health(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
        plyrLives = 3;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 40));
        g.drawString(String.valueOf(plyrLives), GAME_WIDTH/5, GAME_HEIGHT-60);
    }

    public void lostLife(){
        plyrLives--;
    }
}
