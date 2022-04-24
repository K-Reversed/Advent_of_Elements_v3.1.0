package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @since 1.2
 */
public class KeyInput implements KeyListener {
    private boolean up;
    private boolean left;
    private boolean down;
    private boolean right;
    private String lastPressed = "left";

    public KeyInput() {
    }

    public void keyTyped(KeyEvent e) {
    }

    /**
     * @param e The int for a specific key on the keyboard
     * @updated 2.1.4, 2.1.5, 3.1.0
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //Basic Sprite Movement
        if (key == (KeyEvent.VK_W) || key == (KeyEvent.VK_UP)) {
            up = true;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            lastPressed = ("left");
            left = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            lastPressed = ("right");
            right = true;
        }

        //Others.Spell Attack Implementation
//        if (key == KeyEvent.VK_1) {
//        }
//        if (key == KeyEvent.VK_2) {
//        }
//        if (key == KeyEvent.VK_3) {
//        }
//        if (key == KeyEvent.VK_ESCAPE) {
//            System.exit(0);
//        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
            up = false;
        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            left = false;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
            down = false;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            right = false;
        }
    }

    public boolean isUp() {
        return up;
    }
    public boolean isLeft() {
        return left;
    }
    public boolean isDown() {
        return down;
    }
    public boolean isRight() {
        return right;
    }
    public String getLastPressed() {
        return lastPressed;
    }
}
