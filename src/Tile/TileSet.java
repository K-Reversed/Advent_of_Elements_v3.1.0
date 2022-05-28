package Tile;

import java.awt.image.BufferedImage;

public class TileSet {

    private BufferedImage image;
    private boolean collision = false;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean hasCollision() {
        return collision;
    }


}
