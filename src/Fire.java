import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Fire extends Spell{
    private BufferedImage spriteSheet;
    private int spriteNum = 0;
    private final Handler handler;
    private final HUD hud;
    private static String direction;
    public Fire(int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler, hud);
        this.handler = handler;
        this.hud = hud;
        direction = Character.getDirection();
        try {
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/spellSpriteSheets/Fireball Sprite Sheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        super.tick();
        //handler.addObject(new Trail(x - 8, y + 8, ID.Trail, handler, 16, 16, 0.1f, new Color(200, 0 ,0)));
    }

    public void render(Graphics2D g) {
        BufferedImage image = null;
        g.draw(getBounds());
        switch (direction){
            case ("up") -> {
                setVY(-4);
                if (spriteNum < 25) {
                    image = spriteSheet.getSubimage(800, 0, 32, 32);
                }
                if (spriteNum > 25){
                    image = spriteSheet.getSubimage(768, 0, 32, 32);
                }
            }
            case ("left") -> {
                setVX(-4);
                if (spriteNum < 25){
                    image = spriteSheet.getSubimage(512, 0, 32, 32);
                }
                if (spriteNum > 25){
                    image = spriteSheet.getSubimage(544, 0, 32, 32);
                }
            }
            case ("down") -> {
                setVY(4);
                if (spriteNum <= 25){
                    image = spriteSheet.getSubimage(256, 0, 32, 32);
                }
                if (spriteNum > 25){
                    image = spriteSheet.getSubimage(288, 0, 32, 32);
                }
            }
            case ("right") -> {
                setVX(4);
                if (spriteNum <= 25) {
                    image = spriteSheet.getSubimage(0, 0, 32, 32);
                }
                if (spriteNum > 25){
                    image = spriteSheet.getSubimage(32, 0, 32, 32);
                }
            }
        }
        g.drawImage(image, x, y, 32, 32, null);
        spriteNum ++;
        if (spriteNum >= 50){
            spriteNum = 0;
        }

    }

    public void collision(){
        for (int i = 0; i < handler.gameObjects.size(); i++ ){
            GameObject temp = handler.gameObjects.get(i);
            if (temp.getId() == ID.Enemy0) {
                if (getBounds().intersects(temp.getBounds())) {
                    Enemy0.setHealth(Enemy0.getHealth() - 1);
                    handler.removeObject(this);
                }
            }
            if (temp.getId() == ID.Enemy1){
                if (getBounds().intersects(temp.getBounds())) {
                    Enemy1.setHealth(Enemy1.getHealth() - 1);
                    handler.removeObject(this);
                }
            }
            if (temp.getId() == ID.Enemy2){
                if (getBounds().intersects(temp.getBounds())) {
                    Enemy2.setHealth(Enemy2.getHealth() - 1);
                    handler.removeObject(this);
                }
            }
            if (temp.getId() == ID.Enemy3){
                if (getBounds().intersects(temp.getBounds())) {
                    Enemy3.setHealth(Enemy3.getHealth() - 1);
                    handler.removeObject(this);
                }
            }
            if (x <= 0 || x >= Main.WIDTH - 32 || y <= 0 || y >= Main.HEIGHT - 332){
                handler.removeObject(this);
            }
        }
    }

    public Rectangle getBounds() {
        return (new Rectangle(x, y, 32, 32));
    }
}
