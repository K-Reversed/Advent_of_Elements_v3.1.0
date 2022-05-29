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

    /**
     * @param string Map Input
     * @return an int value corresponding to a tile
     */
    public int mapCode (String string){
        int num = 0;
        switch (string) {
            case ("b") -> num = 1; case ("c") -> num = 2; case ("d") -> num = 3; case ("e") -> num = 4; case ("f") -> num = 5; case ("g") -> num = 6;
            case ("h") -> num = 7; case ("i") -> num = 8; case ("j") -> num = 9; case ("k") -> num = 10; case ("l") -> num = 11; case ("m") -> num = 12;
            case ("n") -> num = 13; case ("o") -> num = 14; case ("p") -> num = 15; case ("q") -> num = 16; case ("r") -> num = 17; case ("s") -> num = 18;
            case ("t") -> num = 19; case ("u") -> num = 20; case ("v") -> num = 21; case ("w") -> num = 22; case ("x") -> num = 23; case ("y") -> num = 24;
            case ("z") -> num = 25; case ("A") -> num = 26; case ("B") -> num = 27; case ("C") -> num = 28; case ("D") -> num = 29; case ("E") -> num = 30;
            case ("F") -> num = 31; case ("G") -> num = 32; case ("H") -> num = 33; case ("I") -> num = 34; case ("J") -> num = 35; case ("K") -> num = 36;
            case ("L") -> num = 37; case ("M") -> num = 38; case ("N") -> num = 39; case ("O") -> num = 40; case ("P") -> num = 41; case ("Q") -> num = 42;
            case ("R") -> num = 43; case ("S") -> num = 44; case ("T") -> num = 45; case ("U") -> num = 46; case ("V") -> num = 47; case ("W") -> num = 48;
            case ("X") -> num = 49; case ("Y") -> num = 50; case ("Z") -> num = 51; case ("0") -> num = 52; case ("1") -> num = 53; case ("2") -> num = 54;
            case ("3") -> num = 55; case ("4") -> num = 56; case ("5") -> num = 57; case ("6") -> num = 58; case ("7") -> num = 59; case ("8") -> num = 60;
            case ("9") -> num = 61; case ("`") -> num = 62; case ("~") -> num = 63; case ("!") -> num = 64; case ("@") -> num = 65; case ("#") -> num = 66;
            case ("$") -> num = 67; case ("%") -> num = 68; case ("^") -> num = 69; case ("&") -> num = 70; case ("*") -> num = 71; case ("(") -> num = 72;
            case (")") -> num = 73; case ("-") -> num = 74; case ("_") -> num = 75; case ("=") -> num = 76; case ("+") -> num = 77; case ("[") -> num = 78;
            case ("{") -> num = 79; case ("]") -> num = 80; case ("}") -> num = 81; case ("\\") -> num = 82; case ("|") -> num = 83; case (";") -> num = 84;
            case (":") -> num = 85; case ("'") -> num = 86; case ("\"") -> num = 87; case (",") -> num = 88; case ("<") -> num = 89; case (".") -> num = 90;
            case (">") -> num = 91; case ("/") -> num = 92; case ("?") -> num = 93; case ("¡") -> num = 94; case ("™") -> num = 95; case ("£") -> num = 96;
            case ("¢") -> num = 97; case ("∞") -> num = 98; case ("§") -> num = 99; case ("¶") -> num = 100;
        }
        return (num);
    }

    public void getImage() {
        for (int i = 0; i < tileSet.length - 1; i++) {
            tileSet[i] = new TileSet();
        }
        tileSet[0].setImage("Grass + Path Tile (Vertical 0).png"); tileSet[1].setImage("Grass + Path Tile (Vertical 1).png"); tileSet[2].setImage("Grass + Path Tile (Horizontal 0).png");
        tileSet[3].setImage("Grass + Path Tile (Horizontal 1).png"); tileSet[4].setImage("Grass + Path Tile (Intersection).png"); tileSet[5].setImage("Grass + Sand Tile (Bottom Center Edge).png");
        tileSet[6].setImage("Grass + Sand Tile (Bottom Left Corner).png"); tileSet[7].setImage("Grass + Sand Tile (Bottom Right Corner).png"); tileSet[8].setImage("Grass + Sand Tile (Middle Left Edge).png");
        tileSet[9].setImage("Grass + Sand Tile (Middle Right Edge).png"); tileSet[10].setImage("Grass + Sand Tile (Top Center Edge).png"); tileSet[11].setImage("Grass + Sand Tile (Top Left Corner).png");
        tileSet[12].setImage("Grass + Sand Tile (Top Right Corner).png"); tileSet[13].setImage("Grass Tile 0.png"); tileSet[14].setImage("Grass Tile 1.png");
        tileSet[15].setImage("Sand Tile 0.png"); tileSet[16].setImage("Void Tile.png"); tileSet[17].setImage("Null Tile.png");
//        tileSet[18].setImage(""); tileSet[19].setImage(""); tileSet[20].setImage("");

    }

    public void getWorldMapA(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap A (Ground).txt");
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
            InputStream inputStream = getClass().getResourceAsStream("/res/TextFiles/WorldMap B (Layer 1).txt");
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
                int tileNumA = mapTileA[i][j];
                int tileNumB = mapTileB[i][j];
                int screenX = ((i * gPanel.getTileSize()) - gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX() + gPanel.getTileSize());
                int screenY = ((j * gPanel.getTileSize()) - gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY() + gPanel.getTileSize());
                if (j * gPanel.getTileSize() > gPanel.getPlayer().getWorldY() - (gPanel.getPlayer().getScreenY() + (2 * gPanel.getTileSize())))
                    if (i * gPanel.getTileSize() < gPanel.getPlayer().getWorldX() + (gPanel.getPlayer().getScreenX() + (gPanel.getTileSize())))
                        if (i * gPanel.getTileSize() > gPanel.getPlayer().getWorldX() - (gPanel.getPlayer().getScreenX() + (2 * gPanel.getTileSize())))
                            if (j * gPanel.getTileSize() < gPanel.getPlayer().getWorldY() + (gPanel.getPlayer().getScreenY() + (gPanel.getTileSize()))) {
                                g2D.drawImage(tileSet[tileNumA].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                                g2D.drawImage(tileSet[tileNumB].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                            }
            }
        }
    }

    public void update() {}
}
