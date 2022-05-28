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
    TileSet[] tileSet;
    private final int[][] mapTileA;
    private final int[][] mapTileB;

    public TileLoader (GUI gPanel) {
        this.gPanel = gPanel;
        tileSet = new TileSet[52];
        getImage();
        mapTileA = new int[gPanel.getMaxWorldColumn()][gPanel.getMaxWorldRow()];
        mapTileB = new int[gPanel.getMaxWorldColumn()][gPanel.getMaxWorldRow()];
        getWorldMapA();
        getWorldMapB();
    }

    public int mapCode (String string){
        int num = 0;
        switch (string) {
            case ("b") -> num = 1; case ("c") -> num = 2; case ("d") -> num = 3; case ("e") -> num = 4;
            case ("f") -> num = 5; case ("g") -> num = 6; case ("h") -> num = 7; case ("i") -> num = 8;
            case ("j") -> num = 9; case ("k") -> num = 10; case ("l") -> num = 11; case ("m") -> num = 12;
            case ("n") -> num = 13; case ("o") -> num = 14; case ("p") -> num = 15; case ("q") -> num = 16;
            case ("r") -> num = 17; case ("s") -> num = 18; case ("t") -> num = 19; case ("u") -> num = 20;
            case ("v") -> num = 21; case ("w") -> num = 22; case ("x") -> num = 23; case ("y") -> num = 24;
            case ("z") -> num = 25; case ("A") -> num = 26; case ("B") -> num = 27; case ("C") -> num = 28;
            case ("D") -> num = 29; case ("E") -> num = 30; case ("F") -> num = 31; case ("G") -> num = 32;
            case ("H") -> num = 33; case ("I") -> num = 34; case ("J") -> num = 35; case ("K") -> num = 36;
            case ("L") -> num = 37; case ("M") -> num = 38; case ("N") -> num = 39; case ("O") -> num = 40;
            case ("P") -> num = 41; case ("Q") -> num = 42; case ("R") -> num = 43; case ("S") -> num = 44;
            case ("T") -> num = 45; case ("U") -> num = 46; case ("V") -> num = 47; case ("W") -> num = 48;
            case ("X") -> num = 49; case ("Y") -> num = 50; case ("Z") -> num = 51;

        }
        return (num);
    }

    public void getImage() {
        try {
            for (int i = 0; i < tileSet.length - 1; i++) {
                tileSet[i] = new TileSet();
            }
            tileSet[0].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Path Tile (Vertical 0).png"))));
            tileSet[1].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Path Tile (Vertical 1).png"))));
            tileSet[2].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Path Tile (Horizontal 0).png"))));
            tileSet[3].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Path Tile (Horizontal 1).png"))));
            tileSet[4].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Path Tile (Intersection).png"))));
            tileSet[5].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Bottom Center Edge).png"))));
            tileSet[6].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Bottom Left Corner).png"))));
            tileSet[7].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Bottom Right Corner).png"))));
            tileSet[8].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Middle Left Edge).png"))));
            tileSet[9].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Middle Right Edge).png"))));
            tileSet[10].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Top Center Edge).png"))));
            tileSet[11].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Top Left Corner).png"))));
            tileSet[12].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass + Sand Tile (Top Right Corner).png"))));
            tileSet[13].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass Tile 0.png"))));
            tileSet[14].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Grass Tile 1.png"))));
            tileSet[15].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Sand Tile 0.png"))));
            tileSet[16].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + "Void Tile.png"))));
//            tileSet[17].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + ""))));
//            tileSet[18].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + ""))));
//            tileSet[19].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + ""))));
//            tileSet[20].setImage(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/Tiles/" + ""))));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getWorldMapA(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap A.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int j = 0;  j < gPanel.getMaxWorldRow(); j++) {
                    int num = mapCode(strings[j]);
                    System.out.println(num);
                    mapTileA[j][i] = num;
                }

            }

            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int[] i : mapTileA) System.out.println(Arrays.toString(i));
    }

    public void getWorldMapB(){
        try{
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap B.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));

            for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int j = 0;  j < gPanel.getMaxWorldRow(); j++) {
                    int num = mapCode(strings[j]);
                    mapTileB[j][i] = num;
                }
            }

            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int[] i : mapTileB) System.out.println(Arrays.toString(i));
    }

    public void draw(Graphics2D g2D) {
        for (int i = 0; i < gPanel.getMaxWorldColumn(); i++) {
            for (int j = 0; j < gPanel.getMaxWorldRow(); j++) {
                int tileNum = mapTileA[i][j];
                int screenX = ((i * gPanel.getTileSize()) - gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX() + gPanel.getTileSize());
                int screenY = ((j * gPanel.getTileSize()) - gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY() + gPanel.getTileSize());
                if (tileNum != 17) {
                    if (j * gPanel.getTileSize() > gPanel.getPlayer().getWorldY() - (gPanel.getPlayer().getScreenY() + (2 * gPanel.getTileSize())))
                        if (i * gPanel.getTileSize() < gPanel.getPlayer().getWorldX() + (gPanel.getPlayer().getScreenX() + (gPanel.getTileSize())))
                            if (i * gPanel.getTileSize() > gPanel.getPlayer().getWorldX() - (gPanel.getPlayer().getScreenX() + (2 * gPanel.getTileSize())))
                                if (j * gPanel.getTileSize() < gPanel.getPlayer().getWorldY() + (gPanel.getPlayer().getScreenY() + (gPanel.getTileSize()))) {
                                    g2D.drawImage(tileSet[tileNum].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                                }
                }
            }
        }
    }

    public void update() {}
}
