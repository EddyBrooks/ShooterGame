import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;

public class Grid {

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;
    Shapes[][] ShapeGrid;
    Random rand = new Random();
    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white};

    Grid(){

        ShapeGrid = new Shapes[2][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                ShapeGrid[i][k] = new Shapes(k*123, (ShapeGrid.length-i-1)*123);
            }
        }
    }

    public void newRow(){
        Shapes[][] temp = new Shapes[ShapeGrid.length+1][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                if (ShapeGrid[i][k] != null){
                    ShapeGrid[i][k].y += 123;
                }
                temp[i][k] = ShapeGrid[i][k];
            }
        }
        for (int i = ShapeGrid.length; i < temp.length; i++){
            for (int k = 0; k < temp[i].length; k++){
                temp[i][k] = new Shapes(k*123, 0);
            }
        }
        ShapeGrid = new Shapes[temp.length][5];
        for (int i = 0; i < temp.length; i++){
            for (int k = 0; k < temp[i].length; k++){
                ShapeGrid[i][k] = temp[i][k];
            }
        }

    }

    public void updateRows(){
        boolean containsAny = false;
        for (int i = 0; i < 5; i++){
            if (ShapeGrid[0][i] != null){
                containsAny = true;
            }
        }
        if (!containsAny){
            Shapes[][] temp = new Shapes[ShapeGrid.length-1][5];
            for (int i = 0; i < temp.length; i++){
                for (int k = 0; k < ShapeGrid[i].length; k++){
                    temp[i][k] = ShapeGrid[i+1][k];
                }
            }
            ShapeGrid = temp;
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
    }

}
