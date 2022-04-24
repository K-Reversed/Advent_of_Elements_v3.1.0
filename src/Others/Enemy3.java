package Others;

import Main.Main;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy3 extends GameObject{
    private static int health;
    private final Handler handler;
    private final HUD hud;
    public Enemy3 (int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler);
        vX = 20;
        vY = 20;
        health = 10;
        this.hud = hud;
        this.handler = handler;
    }

    public void tick() {
//        x+=vX;
//        y+=vY;
//
//        if (y <= 0 || y >= Main.HEIGHT - 308){
//            vY *= -1;
//        }
//        if (x <= 0 || x >= Main.WIDTH - 8){
//            vX *= -1;
//        }
//
//        handler.addObject(new Trail(x, y, ID.Trail, handler, 8, 8, 0.01f, new Color(252, 182, 5)));

    }

    public void render(Graphics2D g) {
        g.setColor(new Color( 0, 0, 0));
        g.fillRect(x,y, 8, 8);
        if (health <= 0){
            handler.removeObject(this);
            hud.setEnemyCount(hud.getEnemyCount() - 1);
            Spawner.enemyCountKeep --;
            HUD.setMana(HUD.getMana() + 50);
        }
    }



    public static void setHealth(int health) {
        Enemy3.health = health;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public static int getHealth() {
        return health;
    }
}