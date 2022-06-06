import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;

public class Grid {

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;
    Shapes[][] ShapeGrid;
    Random rand = new Random();
    Health health;
    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white};
    public static boolean changing = false;

    Grid(){

        ShapeGrid = new Shapes[1][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                ShapeGrid[i][k] = new Shapes(k*123, (ShapeGrid.length-i-1)*123);
            }
        }
        health = new Health(GAME_WIDTH, GAME_HEIGHT);
    }

    public void newRow(){
        //Creates new temporary 2D array
        //Copies contents of original array
        //Moves the shapes down one space
        Shapes[][] temp = new Shapes[ShapeGrid.length+1][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                if (ShapeGrid[i][k] != null){
                    ShapeGrid[i][k].y += 123;
                }
                temp[i][k] = ShapeGrid[i][k];
            }
        }
        //Creates new Shapes in empty slots
        for (int i = ShapeGrid.length; i < temp.length; i++){
            for (int k = 0; k < temp[i].length; k++){
                temp[i][k] = new Shapes(k*123, 0);
            }
        }
        //Copies temp to ShapeGrid
        ShapeGrid = new Shapes[temp.length][5];
        for (int i = 0; i < temp.length; i++){
            for (int k = 0; k < temp[i].length; k++){
                ShapeGrid[i][k] = temp[i][k];
            }
        }

    }

    public void updateRows(){
        if (ShapeGrid.length == 1 && ShapeGrid[0][0] == null  && ShapeGrid[0][1] == null && ShapeGrid[0][2] == null && ShapeGrid[0][3] == null && ShapeGrid[0][4] == null){
            ShapeGrid = new Shapes[1][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                ShapeGrid[i][k] = new Shapes(k*123, (ShapeGrid.length-i-1)*123);
            }
        }
        }

        //checks if first row is empty
        boolean containsAny = false;
        for (int i = 0; i < 5; i++){
            if (ShapeGrid.length != 0 && ShapeGrid[0][i] != null){
                containsAny = true;
            }
        }
        //if first row is empty, updates it so that next row is first row
        //To prevent array from getting too long
        if (!containsAny && ShapeGrid.length != 1){
            Shapes[][] temp = new Shapes[ShapeGrid.length-1][5];
            for (int i = 0; i < temp.length; i++){
                for (int k = 0; k < ShapeGrid[i].length; k++){
                    temp[i][k] = ShapeGrid[i+1][k];
                }
            }
            ShapeGrid = temp;
        }

        //HELP HERE ITS FUCKED
        
        //Resets board and loses life if row gets too far down
        for (int i = 0; i < ShapeGrid.length; i++){
            if (ShapeGrid[0][i] != null && ShapeGrid[0][i].y > 492){
                ShapeGrid = new Shapes[1][5];
                for (int j = 0; i < ShapeGrid.length; i++){
                    for (int k = 0; k < ShapeGrid[j].length; k++){
                        changing = true;
                        ShapeGrid[j][k] = new Shapes(k*123, (ShapeGrid.length-j-1)*123);
                    }
                }

                health.lostLife();
                changing = false;
                i = 100;
            }
        }
    }

    public void drawGrid(Graphics g){
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                if (ShapeGrid[i][k] != null){
                    ShapeGrid[i][k].draw(g);
                }
            }
        }
        health.draw(g);
    }

}
