package Others;

import java.awt.*;
import java.util.LinkedList;

/**
 * @since 1.1
 */
public class Handler {
    LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void tick(){
        for (GameObject temp : gameObjects) {
            temp.tick();
        }
    }
    public void render(Graphics2D g){
        for (GameObject temp : gameObjects) {
            temp.render(g);
        }
    }
    public void addObject(GameObject object){
        gameObjects.add(object);
    }
    public void removeObject(GameObject object){
        gameObjects.remove(object);
    }
}
