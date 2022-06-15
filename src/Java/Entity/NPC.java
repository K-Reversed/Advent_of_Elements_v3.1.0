package Java.Entity;

import Java.Main.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class NPC extends Entity{

    public NPC(GUI gPanel) {
        super(gPanel);
        input = "down";
        velocity = 2;
        getImage();
    }


    public void draw(Graphics2D g2D) {
    }

    public void update() {

    }

    public void getImage() {
        spriteSize = 64;
        try {
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/SpriteSheets/NPC SpriteSheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        idleR0 = spriteSheet.getSubimage(0,0, spriteSize, spriteSize);
        idleR1 = spriteSheet.getSubimage(64, 0, spriteSize, spriteSize);
        idleL0 = spriteSheet.getSubimage(512, 0, spriteSize, spriteSize);
        idleL1 = spriteSheet.getSubimage(576, 0, spriteSize, spriteSize);
        right0 = spriteSheet.getSubimage(128, 0, spriteSize, spriteSize);
        right1 = spriteSheet.getSubimage(192, 0, spriteSize, spriteSize);
        right2 = spriteSheet.getSubimage(256, 0, spriteSize, spriteSize);
        right3 = spriteSheet.getSubimage(320, 0, spriteSize, spriteSize);
        right4 = spriteSheet.getSubimage(384, 0, spriteSize, spriteSize);
        right5 = spriteSheet.getSubimage(448, 0, spriteSize, spriteSize);
        left0 = spriteSheet.getSubimage(640, 0, spriteSize, spriteSize);
        left1 = spriteSheet.getSubimage(704, 0, spriteSize, spriteSize);
        left2 = spriteSheet.getSubimage(768, 0, spriteSize, spriteSize);
        left3 = spriteSheet.getSubimage(896, 0, spriteSize, spriteSize);
        left4 = spriteSheet.getSubimage(832, 0, spriteSize, spriteSize);
        left5 = spriteSheet.getSubimage(960, 0, spriteSize, spriteSize);
    }
}
