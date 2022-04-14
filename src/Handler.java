import java.awt.*;
import java.util.LinkedList;

/**
 * @since 1.1
 */
public class Handler {
    LinkedList<GameObject> gameObjects = new LinkedList<>();

    public void tick(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject temp = gameObjects.get(i);

            temp.tick();
        }
    }
    public void render(Graphics2D g){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject temp = gameObjects.get(i);

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
