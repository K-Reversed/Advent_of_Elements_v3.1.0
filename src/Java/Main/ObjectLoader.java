package Java.Main;

import Java.Objects.*;

import java.util.Arrays;

public class ObjectLoader{
    private final GUI gPanel;
    private String currentMap;
    private final GameObjects[] gameObjects;

    public ObjectLoader (GUI gPanel){
        this.gPanel = gPanel;
        currentMap = gPanel.getTileL().getCurrentMap();
        gameObjects = new GameObjects[20];
        loadObjects();
        System.out.println(Arrays.toString(gameObjects));
    }

    public void loadObjects() {
        gameObjects[0] = new HPPotion();
        gameObjects[1] = new MPPotion();
        gameObjects[2] = new Key();
        gameObjects[3] = new Lock();
        setObjectCords();
    }

    public void setObjectCords (){
       gameObjects[0].setWorldCords(14 * gPanel.getTileSize(), 14 * gPanel.getTileSize());
       gameObjects[1].setWorldCords(16 * gPanel.getTileSize(), 16 * gPanel.getTileSize());
       gameObjects[2].setWorldCords(28 * gPanel.getTileSize(), 16 * gPanel.getTileSize());
       gameObjects[3].setWorldCords(27 * gPanel.getTileSize(), 7 * gPanel.getTileSize());
    }

    public GameObjects[] getGameObjects() {
        return gameObjects;
    }

}
