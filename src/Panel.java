import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable, ActionListener{

    Shapes shapes;
    Grid grid;
    Character character;

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;



    Panel(){

    }

    public void newBoxes(){

    }


    public void move() {

    }

    public void checkCollision(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
                System.out.println("TEST");
            }
        }
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){

        }
    }


}
