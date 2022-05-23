import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;

public class Grid {

    static final int GAME_WIDTH = 615;
    static final int GAME_HEIGHT = 780;
    //ArrayList<ArrayList> ArrayRows;
    //ArrayList<Shapes> ShapeGrid;
    Shapes[][] ShapeGrid;
    Random rand = new Random();
    public final Color[] list = {Color.BLACK, Color.BLUE, Color.GREEN, Color.orange, Color.red, Color.white, Color.pink};

    Grid(){
        //ArrayRows = new ArrayList<>();
        //ShapeGrid = new ArrayList<Shapes>();
        ShapeGrid = new Shapes[1][5];
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                ShapeGrid[i][k] = new Shapes(k*123, (ShapeGrid.length-1)*123);
            }
        }
        /*
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                int rand_int1 = rand.nextInt(list.length);
                ShapeGrid[i][k].setColor(list[rand_int1]);
                //System.out.println(ShapeGrid[i][k].toString());
            }
        }

         */
        /*
        for (int i = 0; i < 5; i++){
            Shapes newShape = new Shapes(i*123, ArrayRows.size()*123);
            ShapeGrid.add(newShape);
        }
        ArrayRows.add(ShapeGrid);
         */
    }
    /*
    public void drawGrid(Graphics g){
        for (int i = 0; i < ArrayRows.size(); i++){
            for (int k = 0; k < ArrayRows.get(i).size(); k++){
                System.out.println(ArrayRows.get(i).get(k).toString());
                ShapeGrid.get(k).draw(g);
            }
        }
    }

     */

    public void drawGrid(Graphics g){
        for (int i = 0; i < ShapeGrid.length; i++){
            for (int k = 0; k < ShapeGrid[i].length; k++){
                ShapeGrid[i][k].draw(g);

                //ShapeGrid[i][k].setColor();
                //System.out.println(ShapeGrid[i][k].toString());
            }
        }
    }
}
