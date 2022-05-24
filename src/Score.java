import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score extends Rectangle{

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int plyrScore;
    Score(int GAME_WIDTH, int GAME_HEIGHT){
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;

    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.setFont(new Font("Consolas", Font.PLAIN, 40));
        g.drawString(String.valueOf(plyrScore), GAME_WIDTH/2, GAME_HEIGHT-60);
    }
}
