package Java.Main;
/*
TODO:
 1. Fix inverted controls
 2. Create multiple maps
 3. Add enemies
 4. Add Boss
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

        gPanel.initiate();
        gPanel.start();
    }

    public static void main(String[] args){
        new Main();
    }


}
