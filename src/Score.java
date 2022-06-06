import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    public static int plyrScore;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;

    }

    public void draw(Graphics g){

        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 30));
        g.drawString("Score: " + String.valueOf(plyrScore), GAME_WIDTH-200, GAME_HEIGHT-60);
    }
}
