package Main;
/*
TODO:
 1. Add inventory,
 2. Add items to inventory,
 3. Try to find a way to add sprites (done)
 4. Link keys to attacks (done)
 5. Find a way to use 2d arrays in the project. (Possible implementation found in Others.Inventory)
 6. Find a way to use arrayList. (Possible implementation found in Others.Inventory)
 7. Find a way to use sorting algorithms.
*/

import javax.swing.*;
import java.awt.*;


/**
 * @author Kevin Jiang
 * @version 3.1.0
 * @since 1.0
 */
public class Main extends Canvas{
    /**
     * @updated 1.1, 1.2
     */
    public Main(){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Advent of Elements v3.1.0");

        GUI gPanel = new GUI();
        window.add(gPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gPanel.start();
    }

    public static int clamp(int var, int min, int max){
        if (var >= max){
            return (max);
        } else {
            return Math.max(var, min);
        }
    }

    /**
     * @param args the main method
     */
    public static void main(String[] args){
        new Main();
    }


}
