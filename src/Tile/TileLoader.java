package Tile;

import Entity.Entity;
import Main.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class TileLoader extends Entity {

    GUI gPanel;
    Tile[] tiles;

    public TileLoader (GUI gPanel) {
        this.gPanel = gPanel;
        tiles = new Tile[10];
        getTiles();
    }

    public void getTiles() {
        try {
            tiles[0] = new Tile();
            tiles[0].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass Tile 0.png"))));

            tiles[1] = new Tile();
            tiles[1].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass Tile 1.png"))));

            tiles[2] = new Tile();
            tiles[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 0.png"))));

            tiles[3] = new Tile();
            tiles[3].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 1.png"))));

            tiles[4] = new Tile();
            tiles[4].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 2.png"))));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2D) {
        g2D.drawImage(tiles[0].getImage(), 0, 0, gPanel.getTileSize(), gPanel.getTileSize(), null);
    }

    public void update() {

    }
}
