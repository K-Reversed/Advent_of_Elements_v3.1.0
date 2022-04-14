import java.awt.*;

/**
 * @since 1.3
 * @updated 1.5
 */
public class HUD {

    public static int health = 200;
    public static int mana = 300;
    private int gValue = 255;
    private int rValue = 0;
    private int level = 1;

    private int enemyCount = 0;

    private final int maxHealth = health;
    private final int maxMana = mana;

    public void tick(){
        health = Main.clamp(health, 0, 400);
        mana = Main.clamp(mana, 0 , 600);

        gValue = (health * 2);
        rValue = ((maxHealth - health) * 2);

        gValue = Main.clamp(gValue, 0, 255);
        rValue = Main.clamp(rValue, 0, 255);


    }

    public void render(Graphics2D g){
        g.setColor(new Color(70, 70, 70));
        g.fillRect(15, 500, 400, 32);
        g.fillRect(15, 548, 600, 32);

        g.setColor(new Color(rValue, gValue, 0));
        g.fillRect(15, 500, health * 2, 32);

        g.setColor(new Color(0, 122, 255));
        g.fillRect(15, 548, mana * 2, 32);

        g.setColor(new Color(255, 255, 255));
        g.drawRect(15, 500, 400, 32);
        g.drawRect(15, 548, 600, 32);

        g.setFont(new Font("Sans Serif", Font.PLAIN, 32));
        g.setColor(new Color(123, 0, 255, 128));
        g.drawString(health + "/" + maxHealth, 15, 528);
        g.drawString(mana + "/" + maxMana, 15, 576);
        g.drawString("[M] Menu", 15, 640);
        g.drawString("[I] Inventory", 15, 672);
        g.drawString("Enemy Count : " + enemyCount, Main.WIDTH / 2, 640);
        g.drawString("Level : " + level, Main.WIDTH / 2, 672);

        if (HUD.health <= 2){
            g.setColor(new Color(0, 0, 0));
            g.fillRect(0,0, Main.WIDTH, Main.HEIGHT - 300);

            g.setFont(new Font("Sans Serif", Font.PLAIN, 32));
            g.setColor(new Color(255, 0, 0));
            g.drawString("Game Over", (Main.WIDTH - 175) / 2, (Main.HEIGHT - 300) / 2);
        }
    }

    public void setEnemyCount(int enemyCount) {
        this.enemyCount = enemyCount;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static int getMana() {
        return mana;
    }

    public static int getHealth() {
        return health;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public int getLevel() {
        return level;
    }

    public static void setMana(int mana) {
        HUD.mana = mana;
    }

    public static void setHealth(int health) {
        HUD.health = health;
    }
}
