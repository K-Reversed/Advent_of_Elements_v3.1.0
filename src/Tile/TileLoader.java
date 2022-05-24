package Tile;

import Entity.Entity;
import Main.GUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

public class TileLoader extends Entity {

    GUI gPanel;
    Tile[] tiles;
    private final int[][] mapTileA;
    private final int[][] mapTileB;

    public TileLoader (GUI gPanel) {
        this.gPanel = gPanel;
        tiles = new Tile[20];
        getImage();
        mapTileA = new int[gPanel.getMaxWorldColumn()][gPanel.getMaxWorldRow()];
        mapTileB = new int[gPanel.getMaxWorldColumn()][gPanel.getMaxWorldRow()];
        getWorldMapA();
        getWorldMapB();
    }

    public void getImage() {
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

            tiles[5] = new Tile();
            tiles[5].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 3.png"))));

            tiles[6] = new Tile();
            tiles[6].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 4.png"))));

            tiles[7] = new Tile();
            tiles[7].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 5.png"))));

            tiles[8] = new Tile();
            tiles[8].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Path Tile 6.png"))));

            tiles[9] = new Tile();
            tiles[9].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 0.png"))));

            tiles[10] = new Tile();
            tiles[10].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 1.png"))));

            tiles[11] = new Tile();
            tiles[11].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 2.png"))));

            tiles[12] = new Tile();
            tiles[12].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 3.png"))));

            tiles[13] = new Tile();
            tiles[13].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 4.png"))));

            tiles[14] = new Tile();
            tiles[14].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 5.png"))));

            tiles[15] = new Tile();
            tiles[15].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 6.png"))));

            tiles[16] = new Tile();
            tiles[16].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/Grass + Sand Tile 7.png"))));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getWorldMapA(){
        try{
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap A.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));

            for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int j = 0;  j < gPanel.getMaxWorldRow(); j++) {

                    int num = Integer.parseInt(strings[j]);

                    mapTileA[j][i] = num;
                }
            }

            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(mapTileA));
    }

    public void getWorldMapB(){
        try{
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap B.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));

            for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int j = 0;  j < gPanel.getMaxWorldRow(); j++) {

                    int num = Integer.parseInt(strings[j]);

                    mapTileB[j][i] = num;
                }
            }

            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(Arrays.deepToString(mapTileB));
    }

    public void draw(Graphics2D g2D) {
        for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
            for (int j = 0; j < gPanel.getMaxWorldRow(); j++) {
                int tileNum = mapTileA[i][j];
                int screenX = ((i * gPanel.getTileSize()) - gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX() + gPanel.getTileSize());
                int screenY = ((j * gPanel.getTileSize()) - gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY() + gPanel.getTileSize());
                if (tileNum != 17) {
                    if (j * gPanel.getTileSize() > gPanel.getPlayer().getWorldY() - (gPanel.getPlayer().getScreenY() + (2 * gPanel.getTileSize())))
                        if (i * gPanel.getTileSize() < gPanel.getPlayer().getWorldX() + (gPanel.getPlayer().getScreenX() + (2 * gPanel.getTileSize())))
                            if (i * gPanel.getTileSize() > gPanel.getPlayer().getWorldX() - (gPanel.getPlayer().getScreenX() + (2 * gPanel.getTileSize())))
                                if (j * gPanel.getTileSize() < gPanel.getPlayer().getWorldY() + (gPanel.getPlayer().getScreenY() + (2 * gPanel.getTileSize()))) {
                                    g2D.drawImage(tiles[tileNum].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                                }
                }
            }
        }
    }

    public void update() {}
}
