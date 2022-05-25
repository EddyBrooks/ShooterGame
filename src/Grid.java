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
        for (int i = 0; i < temp.length; i++){
            System.out.println();
            for (int k = 0; k < temp[i].length; k++){
                if (temp[i][k] != null){
                    System.out.print(temp[i][k].color + " ");
                }
                else {
                    System.out.print("NULL ");
                }
            }
        }

        //TROUBLESHOOT HERE
        System.out.println(temp.toString());
        for (int i = ShapeGrid.length; i < temp.length; i++){
            for (int k = ShapeGrid[0].length; k < temp[i].length; k++){
                temp[i][k] = new Shapes(k*123, 0*123);
                System.out.println(temp[i][k]);
            }
        }
        ShapeGrid = temp;
        System.out.println("HERE" + ShapeGrid.length);
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
