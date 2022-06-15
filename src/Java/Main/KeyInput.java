package Java.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @since 1.2
 */
public class KeyInput implements KeyListener {
    private final GUI gPanel;
    private boolean up;
    private boolean left;
    private boolean down;
    private boolean right;
    private boolean drawDebug = false;
    private String lastPressed = "left";

    public KeyInput (GUI gPanel){
        this.gPanel = gPanel;
    }

    public void keyTyped(KeyEvent e) {
    }

    /**
     * @param e The int for a specific key on the keyboard
     * @updated 2.1.4, 2.1.5, 3.1.0
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (gPanel.gameState == gPanel.titleState){
            if (key == KeyEvent.VK_W || key == (KeyEvent.VK_UP)) {
                gPanel.getUserI().commandNum --;
                if (gPanel.getUserI().commandNum < 0){
                    gPanel.getUserI().commandNum = 2;
                }
            }
            if (key == KeyEvent.VK_S || key == (KeyEvent.VK_DOWN)) {
                gPanel.getUserI().commandNum ++;
                if (gPanel.getUserI().commandNum > 2){
                    gPanel.getUserI().commandNum = 0;
                }
            }
            if (key == KeyEvent.VK_ENTER) {
                switch (gPanel.getUserI().commandNum){
                    case (0) -> {
                        gPanel.gameState = gPanel.playState;
                        gPanel.playAudio(8);
                    }
                    case (1) -> {}
                    case (2) -> System.exit(0);
                }
            }
        }

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


        //Open Debug text
        if (key == KeyEvent.VK_F4) {
            drawDebug = true;
        }

//        if (key == KeyEvent.VK_1) {
//        }
//        if (key == KeyEvent.VK_2) {
//        }
//        if (key == KeyEvent.VK_3) {
//        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (gPanel.gameState == gPanel.playState) {
                gPanel.gameState = gPanel.pauseState;
            }
            else if (gPanel.gameState == gPanel.pauseState) {
                gPanel.gameState = gPanel.playState;
            }
        }

        if (!gPanel.hasFocus()){
            up = false;
            left = false;
            down = false;
            right = false;
        }
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
        if (key == KeyEvent.VK_F4 ){
            drawDebug = false;
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

    public boolean isDrawDebug() {
        return drawDebug;
    }
}
