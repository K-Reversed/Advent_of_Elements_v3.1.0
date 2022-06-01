package Main;
/*
TODO:
 1. Fix sticky collision
*/

import javax.swing.*;
import java.awt.*;


/**
 * @author Kevin Jiang
 * @version 3.1.0
 * @since 1.0
 */
public class Main extends Canvas{
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

    public static void main(String[] args){
        new Main();
    }


}
