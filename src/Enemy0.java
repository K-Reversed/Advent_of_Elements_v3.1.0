import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Enemy0 extends GameObject{
    private static int health;
    private final Handler handler;
    private final HUD hud;
    public Enemy0(int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler);
        vX = 3;
        vY = 3;
        health = 10;
        this.hud = hud;
        this.handler = handler;
    }

    public void tick() {
        x+=vX;
        y+=vY;

        if (y <= 0 || y >= Main.HEIGHT - 316){
            vY *= -1;
        }
        if (x <= 0 || x >= Main.WIDTH - 16){
            vX *= -1;
        }

        handler.addObject(new Trail(x, y, ID.Trail, handler, 16, 16, 0.1f, new Color(0, 255, 255)));

    }

    public void render(Graphics2D g) {
        g.setColor(new Color( 0, 0, 0));
        g.fillRect(x,y, 16, 16);
        if (health <= 0){
            handler.removeObject(this);
            hud.setEnemyCount(hud.getEnemyCount() - 1);
            Spawner.enemyCountKeep --;
            HUD.setMana(HUD.getMana() + 20);
        }
    }



    public static void setHealth(int health) {
        Enemy0.health = health;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    public static int getHealth() {
        return health;
    }
}
