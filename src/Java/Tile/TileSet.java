package Java.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class TileSet {

    private BufferedImage image;
    private boolean collision = false;

    public void setImage (String image) {
        try {
            String path = ("/res/png/Tiles/" + image);
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        } catch (NullPointerException | IOException ignored) {}
    }
    public void setCollision(boolean collision) {this.collision = collision;}

    public BufferedImage getImage() {return image;}
    public boolean hasCollision() {return collision;}
}
