package Java.Main;

import Java.Entity.Entity;
import Java.Entity.NPC;
import Java.Objects.*;

import java.util.Arrays;

public class ObjectLoader{
    private final GUI gPanel;
    private String currentMap;
    private final GameObjects[] gameObjects;
    private final Entity[] npc = new Entity[10];

    public ObjectLoader (GUI gPanel){
        this.gPanel = gPanel;
        currentMap = gPanel.getTileL().getCurrentMap();
        gameObjects = new GameObjects[20];
        loadObjects();
        System.out.println(Arrays.toString(gameObjects));
    }

    public void loadObjects() {
        gameObjects[0] = new HPPotion(gPanel);
        gameObjects[1] = new MPPotion(gPanel);
        gameObjects[2] = new Lock(gPanel);
        gameObjects[3] = new Lock(gPanel);
        gameObjects[4] = new Lock(gPanel);
        gameObjects[5] = new Lock(gPanel);
        gameObjects[6] = new Lock(gPanel);
        gameObjects[7] = new Lock(gPanel);
        gameObjects[8] = new Lock(gPanel);

        setObjectCords();
    }

    public void loadNPCs () {
        npc[0] = new NPC(gPanel);
    }

    public void setObjectCords (){
       gameObjects[0].setWorldCords(13 * gPanel.getTileSize(), 14 * gPanel.getTileSize());
       gameObjects[1].setWorldCords(16 * gPanel.getTileSize(), 16 * gPanel.getTileSize());
       gameObjects[2].setWorldCords(6 * gPanel.getTileSize(), 5 * gPanel.getTileSize());
       gameObjects[3].setWorldCords(17 * gPanel.getTileSize(), 5 * gPanel.getTileSize());
       gameObjects[4].setWorldCords(11 * gPanel.getTileSize(), 12 * gPanel.getTileSize());
       gameObjects[5].setWorldCords(21 * gPanel.getTileSize(), 12 * gPanel.getTileSize());
       gameObjects[6].setWorldCords(20 * gPanel.getTileSize(), 9 * gPanel.getTileSize());
       gameObjects[7].setWorldCords(27 * gPanel.getTileSize(), 17 * gPanel.getTileSize());
       gameObjects[8].setWorldCords(7 * gPanel.getTileSize(), 19 * gPanel.getTileSize());
    }

    public void setNPCCords () {
        npc[0].setWorldCords(16 * gPanel.getTileSize(), 16 * gPanel.getTileSize());
    }

    public GameObjects[] getGameObjects() {
        return gameObjects;
    }

    public Entity[] getNpc() {return npc;}
}
