package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected int x, y;
    protected int velocity;


    protected BufferedImage spriteSheet, idleL0, idleL1, idleR0, idleR1, up0, up1, left0, left1, down0, down1, right0, right1;
    protected int spriteSize;
    protected String direction;

    protected int spriteCounter = 0;
    protected int idleCounter = 0;
    protected int spriteNum = 0;
    protected int idleNum = 0;

    public abstract void draw(Graphics2D g2D);
    public abstract void update();
}
