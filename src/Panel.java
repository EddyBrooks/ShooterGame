import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Panel extends JPanel implements Runnable, ActionListener{

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int PROJECTILE_DIAMETER = 10;
    static final int CHARACTER_WIDTH = 100;
    static final int CHARACTER_HEIGHT = 10;
    static int timesShot;
    static int firstShot;
    public static int timer = 0;

    Thread gameThread;
    Image image;
    Random random;
    Shapes shapes;
    Grid grid;
    Projectile projectile;
    Score score;
    Character character;
    Graphics graphics;
    Text text;
    Health health;

    Panel(){
        newCharacter();
        //newShapes();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        text = new Text(GAME_WIDTH, GAME_HEIGHT);
        health = new Health(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        timesShot = 0;
        firstShot = 0;

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newCharacter(){
        character = new Character((GAME_WIDTH/2)-(CHARACTER_WIDTH/2), ((GAME_HEIGHT/4)*3+45)-(CHARACTER_HEIGHT/2), CHARACTER_WIDTH, CHARACTER_HEIGHT);
        projectile = new Projectile((GAME_WIDTH/2)-(CHARACTER_WIDTH/2), ((GAME_HEIGHT/4)*3+30)-(CHARACTER_HEIGHT/2), PROJECTILE_DIAMETER, PROJECTILE_DIAMETER);
        
        grid = new Grid();
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
        projectile.draw(g);
        grid.drawGrid(g);

        if (!character.visible){
            text.drawFirst(g);
        }
        if (health.plyrLives == 0){
            text.drawLast(g);
        }

        score.draw(g);
    }

    public void move() {
        if (character.moveRight){
            character.setXDirection(character.speed);
            character.move();
        }
        if (character.moveLeft){
            character.setXDirection(-character.speed);
            character.move();
        }

        //character.move();
        projectile.move();
    }

    public void checkCollision(){
        //stops guy at edge
        if (character.x <= 0){
            character.x = 0;
        }
        if (character.x >= (GAME_WIDTH-CHARACTER_WIDTH-15)){
            character.x = (GAME_WIDTH-CHARACTER_WIDTH-15);
        }
        //checks if ball hits correct shape
        for (int i = 0; i < grid.ShapeGrid.length; i++){
            for (int k = 0; k < grid.ShapeGrid[i].length; k++){
                if (grid.ShapeGrid[i][k] != null && projectile.intersects(grid.ShapeGrid[i][k]) && projectile.currColor == grid.ShapeGrid[i][k].color){
                    grid.ShapeGrid[i][k] = null;
                    projectile.x = -20;
                    score.plyrScore++;
                }
                if (grid.ShapeGrid[i][k] != null && projectile.intersects(grid.ShapeGrid[i][k])){
                    projectile.x = -20;
                }
            }
        }
        grid.updateRows();

    }

    public void keyPressed1(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_SPACE){
            timesShot++;
            firstShot++;
        }
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

        while(gameThread != null && health.plyrLives!=0){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1){
                move();
                repaint();
                checkCollision();
                delta--;
                if (character.visible){
                    timer++;
                    if (timer%1050 == 0){
                        if (!grid.changing){
                            grid.newRow();
                        }
                    }
                }


                if (firstShot == 1){
                    character.visible = true;
                    projectile.visible = true;
                    projectile.y = -100;
                }
            }

        }

    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            projectile.keyPressed(e);
            character.keyPressed(e);
            keyPressed1(e);

        }
        public void keyReleased(KeyEvent e){
            character.keyReleased(e);
        }
    }

}
