package Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class TileSet {

    private BufferedImage image;
    private boolean collision = false;
//    private Polygon collisionBounds;

    public void setImage (String string) {
        try {
            String path = ("/res/png/Tiles/" + string);
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
            System.out.println("\"" + (new File(path)) + "\" has loaded.");
        } catch (IOException e) {e.printStackTrace();}
    }

    public BufferedImage getImage() {return image;}
    public void setCollision(boolean collision) {this.collision = collision;}
//    public void setCollisionBounds(Polygon collisionBounds) {
//        this.collisionBounds = collisionBounds;
//    }
    public boolean hasCollision() {return collision;}
//    public Polygon getCollisionBounds() {
//        return collisionBounds;
//    }
}
