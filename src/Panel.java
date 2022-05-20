import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable, ActionListener{

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int PROJECTILE_DIAMETER = 10;
    static final int CHARACTER_WIDTH = 30;
    static final int CHARACTER_HEIGHT = 10;
    Thread gameThread;
    Image image;
    Random random;
    Shapes shapes;
    Grid grid;
    Projectile projectile;
    Score score;
    Character character;
    Graphics graphics;

    Panel(){
        newCharacter();
        //newShapes();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newCharacter(){
        character = new Character((GAME_WIDTH/2)-(CHARACTER_WIDTH/2), (GAME_HEIGHT/2)-(CHARACTER_HEIGHT/2), CHARACTER_WIDTH, CHARACTER_HEIGHT);
    }

    public void newBoxes(){

    }

    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    public void draw(Graphics g){
        character.draw(g);
    }

    public void move() {

    }

    public void checkCollision(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    /*
    public void setIcon(ImageIcon image){
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);
    }*/

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
                //System.out.println(character.getX()+" " + character.getY());
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
