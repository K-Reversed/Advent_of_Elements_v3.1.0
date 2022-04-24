package Others;

import Main.Main;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy1 extends GameObject{
    private static int health;
    private final Handler handler;
    private HUD hud;
    public Enemy1 (int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler);
        vX = 10;
        vY = 2;
        health = 15;
        this.hud = hud;
        this.handler = handler;
    }

    public void tick() {
//        x+=vX;
//        y+=vY;
//
//        if (y <= 0 || y >= Main.HEIGHT - 312){
//            vY *= -1;
//        }
//        if (x <= 0 || x >= Main.WIDTH - 12){
//            vX *= -1;
//        }
//
//        handler.addObject(new Trail(x, y, ID.Trail, handler, 12, 12, 0.1f, new Color(0, 125, 125)));
    }

    public void render(Graphics2D g) {
        g.setColor(new Color( 0, 0, 0));
        g.fillRect(x,y, 12, 12);
        if (health <= 0){
            handler.removeObject(this);
            hud.setEnemyCount(hud.getEnemyCount() - 1);
            Spawner.enemyCountKeep --;
            HUD.setMana(HUD.getMana() + 30);
        }
    }

    private double calculateAngle(double vecX, double vecY) {
        double angle = Math.toDegrees(Math.atan(vecY / vecX));
        return vecX > 0 ? angle : 180 + angle;
    }


    public static void setHealth(int health) {
        Enemy1.health = health;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public static int getHealth() {
        return health;
    }
}