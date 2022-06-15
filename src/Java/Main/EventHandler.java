package Java.Main;

import java.awt.*;

public class EventHandler {
    private final GUI gPanel;
    Rectangle events;
    int eventX, eventY;
    public EventHandler (GUI gPanel){
        this.gPanel = gPanel;

        events = new Rectangle(gPanel.getTileSize()/ 4, gPanel.getTileSize() / 4, gPanel.getTileSize() / 2, gPanel.getTileSize() / 2);
        eventX = events.x;
        eventY = events.y;
    }

    public void checkEvent() {
        if (hit(10, 10, "any")){
            damagePit();
        }
        if (hit(11, 13, "any")) {
            healEvent();
        }
    }

    public boolean hit (int col, int row, String direction) {
        boolean hit = false;
        gPanel.getPlayer().getHitBox().x = gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getHitBox().x;
        gPanel.getPlayer().getHitBox().y = gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getHitBox().y;
        events.x = col*gPanel.getTileSize() + events.x;
        events.y = row*gPanel.getTileSize() + events.y;

        if(gPanel.getPlayer().getHitBox().intersects(events)){
            if (gPanel.getPlayer().getInput().contentEquals(direction) || direction.contentEquals("any")){
                hit = true;
            }
        }

        gPanel.getPlayer().getHitBox().x = gPanel.getPlayer().getHitBoxDefaultX();
        gPanel.getPlayer().getHitBox().y = gPanel.getPlayer().getHitBoxDefaultY();
        events.x = eventX;
        events.y = eventY;

        return hit;
    }

    public void damagePit() {
        gPanel.getPlayer().currentHealth --;
        if (gPanel.getPlayer().currentHealth <= 0){
            System.exit(0);
        }
    }

    public void healEvent() {
        if (gPanel.getPlayer().currentHealth < gPanel.getPlayer().maxHealth) {
            gPanel.getPlayer().currentHealth++;
        }
    }

}
