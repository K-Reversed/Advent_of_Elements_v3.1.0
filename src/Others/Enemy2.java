package Others;

import Main.Main;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy2 extends GameObject{
    private static int health;
    private final Handler handler;
    private HUD hud;
    public Enemy2 (int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler);
        vX = 1;
        vY = 1;
        health = 50;
        this.hud = hud;
        this.handler = handler;
    }

    public void tick() {
//        x+=vX;
//        y+=vY;
//
//        if (y <= 0 || y >= Main.HEIGHT - 324){
//            vY *= -1;
//        }
//        if (x <= 0 || x >= Main.WIDTH - 24){
//            vX *= -1;
//        }
//
//        handler.addObject(new Trail(x, y, ID.Trail, handler, 24, 24, 0.1f, new Color(168, 0, 44)));
    }

    public void render(Graphics2D g) {
        g.setColor(new Color( 0, 0, 0));
        g.fillRect(x,y, 24, 24);
        if (health <= 0){
            handler.removeObject(this);
            hud.setEnemyCount(hud.getEnemyCount() - 1);
            Spawner.enemyCountKeep --;
            HUD.setMana(HUD.getMana() + 200);
        }
    }



    public static void setHealth(int health) {
        Enemy2.health = health;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public static int getHealth() {
        return health;
    }
}