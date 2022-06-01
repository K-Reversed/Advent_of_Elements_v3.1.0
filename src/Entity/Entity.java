package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected int worldX, worldY;
    protected int velocity;
    protected BufferedImage spriteSheet,
            idleL0, idleL1, idleR0, idleR1,
            up0, up1,
            left0, left1, left2, left3, left4, left5,
            down0, down1,
            right0, right1, right2, right3, right4, right5,
            attack0, attack1, attack2, attack3,
            hit0, hit1, hit2, hit3;
    protected int spriteSize;
    protected String direction;
    protected int spriteNum = 0;
    protected int spriteCounter = 0;
    protected int idleNum = 0;
    protected int idleCounter = 0;
    protected int attackNum = 0;
    protected int attackCounter = 0;
    protected int hitNum = 0;
    protected int hitCounter = 0;
    protected Rectangle hitBox;
    protected boolean collision = false;

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
    public String getDirection() {
        return direction;
    }
    public int getVelocity() {
        return velocity;
    }
}
