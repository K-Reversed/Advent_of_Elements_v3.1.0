package Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TileSet {

    private BufferedImage image;
    private boolean collision = false;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage (String string) {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + string)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean hasCollision() {
        return collision;
    }


}
