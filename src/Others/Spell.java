package Others;

import Main.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @since 1.5
 */
public abstract class Spell extends GameObject{

    private BufferedImage fireBallSpriteSheet, iceSpearSpriteSheet, windMagicCircleSpriteSheet;
    private static String spellType;
    private int spriteNum = 0;
    private Handler handler;
    private HUD hud;

    public Spell(int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler);
        this.hud = hud;
        spellType = null;
        spellSprites();

    }

    public void tick() {
        x += vX;
        y += vY;

        x = Main.clamp(x, 0, Main.WIDTH - 16);
        y = Main.clamp(y, 0, Main.HEIGHT - 332);

        collision();
    }

    public void spellSprites (){
        try {
            fireBallSpriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/SpriteSheets/Fireball Sprite Sheet.png")));
            windMagicCircleSpriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/SpriteSheets/Wind Magic Circle Sprite Sheet.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void render(Graphics2D g) {}

    public abstract void collision();

    public static void setSpellType(String spellType) {
        Spell.spellType = spellType;
    }

    public Rectangle getBounds() {
        return null;
    }
}
