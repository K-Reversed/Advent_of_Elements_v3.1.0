package Others;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Wind extends Spell{
    private BufferedImage spriteSheet;
    private int spriteNum = 0;
    public static int mod = 1;
    private int maxTime = 400;
    private int spellDuration = 1500;
    private Handler handler;

    public Wind(int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler, hud);
        this.handler = handler;
        try {
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/SpriteSheets/Wind Magic Circle Sprite Sheet.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void tick() {
        super.tick();
        collision();
        if (maxTime <= 0){
            maxTime = 400;
            handler.removeObject(this);
        }

    }

    public void render(Graphics2D g) {
        BufferedImage image = null;
        if (spriteNum < 25) {
            image = spriteSheet.getSubimage(0, 0, 32, 32);
        }
        if (spriteNum >= 25 && spriteNum < 50) {
            image = spriteSheet.getSubimage(32, 0, 32, 32);
        }
        if (spriteNum >= 50 && spriteNum < 75) {
            image = spriteSheet.getSubimage(64, 0, 32, 32);
        }
        if (spriteNum >= 75 && spriteNum < 100) {
            image = spriteSheet.getSubimage(96, 0, 32, 32);
        }
        if (spriteNum >= 100 && spriteNum < 125) {
            image = spriteSheet.getSubimage(128, 0, 32, 32);
        }
        if (spriteNum >= 125 && spriteNum < 150) {
            image = spriteSheet.getSubimage(160, 0, 32, 32);
        }
        if (spriteNum >= 150 && spriteNum < 175) {
            image = spriteSheet.getSubimage(192, 0, 32, 32);
        }
        if (spriteNum >= 175) {
            image = spriteSheet.getSubimage(224, 0, 32, 32);
        }
        g.drawImage(image, x, y, 32, 32, null);
        spriteNum ++;
        maxTime --;
        spellDuration --;
        if (spriteNum >= 200){
           spriteNum = 0;
        }
        if (spellDuration <= 0){
            spellDuration = 1500;
            mod --;
        }
    }

    public void collision() {
    }
}
