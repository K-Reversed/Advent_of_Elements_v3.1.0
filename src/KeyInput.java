import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @since 1.2
 */
public class KeyInput extends KeyAdapter {

    private final Handler handler;
    private final HUD hud;
    private boolean up;
    private boolean left;
    private boolean down;
    private boolean right;

    public KeyInput (Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    /**
     * @updated 1.4, 1.5
     * @param e The int for a specific key on the keyboard
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObjects.size(); i ++){
            GameObject temp = handler.gameObjects.get(i);
            if (temp.getId() == ID.Character){
                //Basic Sprite Movement
                if (key == (KeyEvent.VK_W) || key == (KeyEvent.VK_UP)){
                    temp.setVY(-5 * Wind.mod);
                    up = true;
                    Character.setDirection("up");
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
                    temp.setVX(-5 * Wind.mod);
                    left = true;
                    Character.setDirection("left");
                }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
                    temp.setVY(5 * Wind.mod);
                    down = true;
                    Character.setDirection("down");
                }
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
                    temp.setVX(5 * Wind.mod);
                    right = true;
                    Character.setDirection("right");
                }

                //Multiple Pressed Keys Conditions
                if (up && left || down && left){
                    Character.setDirection("left");
                }
                if (up && right || down && right) {
                    Character.setDirection("right");
                }

                if (left && right) {
                    temp.setVX(0);
                }
                if (up && down){
                    temp.setVY(0);
                }

                if (left && right && up){
                    Character.setDirection("up");
                }
                if (left && right && down){
                    Character.setDirection("down");
                }
                if (up && down && left){
                    Character.setDirection("left");
                }
                if (up && down && right){
                    Character.setDirection("right");
                }

                if (up && down && left && right){
                    Character.setDirection("spin");
                }

                //Spell Attack Implementation
                if (key == KeyEvent.VK_1){
                    HUD.setMana(HUD.getMana() - 1);
                    handler.addObject(new Fire (temp.x, temp.y, ID.FireBall, handler, hud));
                }
                if (key == KeyEvent.VK_2){
                    HUD.setMana(HUD.getMana() - 3);
                    handler.addObject(new Ice (temp.x, temp.y, ID.IceSpear, handler, hud));
                }
                if (key == KeyEvent.VK_3){
                    Wind.mod ++;
                    HUD.setMana(HUD.getMana() - 10);
                    handler.addObject(new Wind (temp.x, temp.y, ID.TailWind, handler, hud));
                }
            }
        }


        if (key == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.gameObjects.size(); i ++){
            GameObject temp = handler.gameObjects.get(i);
            if (temp.getId() == ID.Character){
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
                    temp.setVY(0);
                    up = false;
                }
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
                    temp.setVX(0);
                    left = false;
                }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN){
                    temp.setVY(0);
                    down = false;
                }
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
                    temp.setVX(0);
                    right = false;
                }
            }
        }
    }
}
