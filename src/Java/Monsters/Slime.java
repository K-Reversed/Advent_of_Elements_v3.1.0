package Java.Monsters;

import Java.Entity.Entity;
import Java.Main.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Slime extends Entity {

    public Slime(GUI gPanel) {
        super(gPanel);
        name = "slime";
        velocity = 1;
        maxHealth = 4;
        currentHealth = maxHealth;

        hitBox = new Rectangle(0, 0, gPanel.getTileSize(), gPanel.getTileSize());
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

    }

    @Override
    public void draw(Graphics2D g2D) {

    }

    @Override
    public void update() {

    }

    @Override
    public void getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/SpriteSheets/Slime SpriteSheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert image != null;
        up0 = image.getSubimage(0, 0, 64, 64);
        up1 = image.getSubimage(64, 0, 64, 64);
        up2 = image.getSubimage(128, 0, 64, 64);
        left0 = image.getSubimage(0, 0, 64, 64);
        left1 = image.getSubimage(64, 0, 64, 64);
        left2 = image.getSubimage(128, 0, 64, 64);
        down0 = image.getSubimage(0, 0, 64, 64);
        down1 = image.getSubimage(64, 0, 64, 64);
        down2 = image.getSubimage(128, 0, 64, 64);
        right0 = image.getSubimage(0, 0, 64, 64);
        right1 = image.getSubimage(64, 0, 64, 64);
        right2 = image.getSubimage(128, 0, 64, 64);
    }

    public void setAction (){
        actionCounter ++;
        if (actionCounter >= 120){
            Random random = new Random();
            int i = random.nextInt(125) + 1;
            if (i <= 25){
                input = "up";
            }
            if (i > 25 && i <= 50){
                input = "left";
            }
            if (i > 50 && i <= 75){
                input = "down";
            }
            if (i > 75 && i <= 100){
                input = "right";
            }
            if (i > 100 && i < 125)
            actionCounter = 0;
        }
    }
}