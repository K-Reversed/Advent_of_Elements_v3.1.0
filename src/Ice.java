import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Ice extends Spell{
    private BufferedImage spriteSheet;
    private Handler handler;
    private HUD hud;
    private int maxDistance;
    private static String direction;
    public Ice (int x, int y, ID id, Handler handler, HUD hud) {
        super(x, y, id, handler, hud);
        this.handler = handler;
        this.hud = hud;
        direction = Character.getDirection();

        try {
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/spellSpriteSheets/Ice Spear Sprite Sheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        super.tick();

        maxDistance = Main.clamp(maxDistance, 0, 32);
        //handler.addObject(new Trail(x, y, ID.Trail, handler, 1, 5, 0.01f, new Color(0, 255, 255)));
        collision();
    }

    public void render(Graphics2D g) {
        BufferedImage image = spriteSheet.getSubimage(0,0, 32, 32);
        switch (direction){
            case("up") -> {
                setVY(5);
                g.drawImage(image, x + 32, y - 64, 32, 32, null);
                g.drawImage(image, x , y - 96, 32, 32, null);
                g.drawImage(image, x - 32, y - 128, 32, 32, null);
            }
            case("left") -> {
                setVY(5);
                g.drawImage(image, x - 64 , y + 32, 32, 32, null);
                g.drawImage(image, x - 96 , y, 32, 32, null);
                g.drawImage(image, x - 128 , y - 32, 32, 32, null);
            }
            case("down") -> {
                setVY(5);
                g.drawImage(image, x - 32, y + 64, 32, 32, null);
                g.drawImage(image, x , y + 96, 32, 32, null);
                g.drawImage(image, x + 32, y + 128, 32, 32, null);
            }
            case("right") -> {
                setVY(5);
                g.drawImage(image, x + 64 , y - 32, 32, 32, null);
                g.drawImage(image, x + 96 , y, 32, 32, null);
                g.drawImage(image, x + 128 , y + 32, 32, 32, null);
            }
        }
        maxDistance ++;
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

            if (maxDistance == 32){
                maxDistance = 0;
                handler.removeObject(this);
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return (new Rectangle(x, y, 32, 32));
    }
}
