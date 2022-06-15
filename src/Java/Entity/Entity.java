package Java.Entity;

import Java.Main.GUI;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private GUI gPanel;
    public Entity (GUI gPanel){
        this.gPanel = gPanel;
    }
    protected int worldX, worldY;
    protected int velocity;
    protected BufferedImage spriteSheet,
            idleL0, idleL1, idleR0, idleR1,
            up0, up1, up2,
            left0, left1, left2, left3, left4, left5,
            down0, down1, down2,
            right0, right1, right2, right3, right4, right5,
            attackL0, attackL1, attackR0, attackR1,
            hit0, hit1, hit2, hit3;
    protected int spriteSize;
    protected String input;
    protected int spriteNum = 0;
    protected int spriteCounter = 0;
    protected int idleNum = 0;
    protected int idleCounter = 0;
    protected int attackNum = 0;
    protected int attackCounter = 0;
    protected int hitNum = 0;
    protected int hitCounter = 0;
    protected Rectangle hitBox;
    protected int hitBoxDefaultX, hitBoxDefaultY;
    protected boolean collision = false;

    public int maxHealth;
    public int currentHealth;
    public int maxMagic;
    public int currentMagic;
    public String name;
    public int actionCounter;

    public abstract void draw(Graphics2D g2D);
    public abstract void update();
    public abstract void getImage();

    public void setCollision(boolean collision) {
        this.collision = collision;
    }
    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }
    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }
    public int getWorldX() {
        return worldX;
    }
    public int getWorldY() {
        return worldY;
    }
    public Rectangle getHitBox() {
        return hitBox;
    }
    public String getInput() {
        return input;
    }
    public int getVelocity() {
        return velocity;
    }
    public int getHitBoxDefaultX() {
        return hitBoxDefaultX;
    }
    public int getHitBoxDefaultY() {
        return hitBoxDefaultY;
    }
    public void setWorldCords(int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
    }
    public GUI getgPanel() {
        return gPanel;
    }
}
