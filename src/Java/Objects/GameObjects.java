package Java.Objects;

import Java.Entity.Entity;
import Java.Main.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class GameObjects extends Entity {
    private BufferedImage image;
    private String name;
    private int worldX, worldY;
    private boolean collision = false;
    private Rectangle hitBox = new Rectangle(0, 0, (int)(32 * 2.5), (int)(32 * 2.5));
    private int hitBoxDefaultX = 0;
    private int hitBoxDefaultY = 0;

    public GameObjects(GUI gPanel) {
        super(gPanel);
    }


    public void setImage(String image) {
        try {
            String path = ("/res/png/Objects/" + image);
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        } catch (NullPointerException | IOException e) {
            this.image = null;
            System.out.println("Image has not loaded");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void draw(Graphics2D g2D) {}

    public void update() {}

    public void getImage() {
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void draw(Graphics2D g2D, GUI gPanel) {
        int screenX = ((worldX - gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX() + gPanel.getTileSize()));
        int screenY = ((worldY - gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY() + gPanel.getTileSize()));
        if (worldY + ( 2 * gPanel.getTileSize()) > gPanel.getPlayer().getWorldY() - gPanel.getPlayer().getScreenY() &&
                (worldX - gPanel.getTileSize() < gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX()) &&
                (worldX + (2 * gPanel.getTileSize()) > gPanel.getPlayer().getWorldX() - gPanel.getPlayer().getScreenX()) &&
                (worldY - gPanel.getTileSize() < gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY())) {
            switch (gPanel.getTileL().getCurrentMap()) {
                case ("OverWorld") -> g2D.drawImage(image, screenX, screenY , gPanel.getTileSize(), gPanel.getTileSize(), null);
                case ("FireDungeon") -> g2D.drawImage(image, screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
            }
        }
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage (int i){
        return image;
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


    public boolean hasCollision() {
        return collision;
    }
}
    
