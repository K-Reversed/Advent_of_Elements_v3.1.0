package Java.Tile;

import Java.Entity.Entity;
import Java.Main.GUI;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TileLoader extends Entity {

    private final GUI gPanel;
    private final TileSet[] tileSet;
    private final ArrayList<int[][]> mapArray;
    private String currentMap;
    private int tileFrame = 0;
    private int tileCounter = 0;

    public TileLoader (GUI gPanel) {
        super(gPanel);
        this.gPanel = gPanel;
        tileSet = new TileSet[101];
        getImage();
        mapArray = new ArrayList<>();

        currentMap = ("OverWorld");
        getWorldMaps("/res/TextFiles/WorldMap A (Ground).txt", new int[31][31]);
        getWorldMaps("/res/TextFiles/WorldMap A (Layer 1).txt", new int[31][31]);
        getWorldMaps("/res/TextFiles/DungeonMap A (Ground).txt", new int[31][31]);
        getWorldMaps("/res/TextFiles/DungeonMap A (Layer 1).txt", new int[31][31]);
    }

    /**
     * @param string Map Input
     * @return an int value corresponding to a tile
     */
    public int mapKey (String string){
        int num;
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
            default -> num = 0;
        }
        return (num);
    }

    public void getImage() {
        for (int i = 0; i < tileSet.length; i++) {
            tileSet[i] = new TileSet();
        }
        //a, b, c, d, e
        tileSet[0].setImage("/Grass/Grass Tile 0.png"); tileSet[1].setImage("/Grass/Grass Tile 1.png"); tileSet[2].setImage("/Sand/Sand Tile.png"); tileSet[3].setImage("/Others/Tree Tile.png"); tileSet[4].setImage("/Others/Null Tile.png");
        //f, g, h, i, j
        tileSet[5].setImage("/Others/Void Tile.png"); tileSet[6].setImage("/Transitions/Grass to Sand Tile (BCE).png"); tileSet[7].setImage("/Transitions/Grass to Sand Tile (BLC).png"); tileSet[8].setImage("/Transitions/Grass to Sand Tile (BRC).png"); tileSet[9].setImage("/Transitions/Grass to Sand Tile (MLE).png");
        //k, l, m, n, o
        tileSet[10].setImage("/Transitions/Grass to Sand Tile (MLE).png"); tileSet[11].setImage("/Transitions/Grass to Sand Tile (MRE).png"); tileSet[12].setImage("/Transitions/Grass to Sand Tile (TCE).png"); tileSet[13].setImage("/Transitions/Grass to Sand Tile (TLC).png"); tileSet[14].setImage("/Transitions/Grass to Sand Tile (TRC).png");
        //p, q, r, s, t
        tileSet[15].setImage("/Dungeon/Dungeon Center Tile 0.png"); tileSet[16].setImage("/Dungeon/Dungeon Center Tile 1.png"); tileSet[17].setImage("/Dungeon/Dungeon Center Tile 2.png"); tileSet[18].setImage("/Dungeon/Dungeon Center Tile 3.png"); tileSet[19].setImage("/Dungeon/Dungeon Center Tile 4.png");
        //u, v, w, x, y
        tileSet[20].setImage("/Dungeon/Dungeon Center Tile 5.png"); tileSet[21].setImage("/Dungeon/Dungeon Center Tile 6.png"); tileSet[22].setImage("/Dungeon/Dungeon Center Tile 7.png"); tileSet[23].setImage("/Dungeon/Dungeon Center Tile 8.png"); tileSet[24].setImage("/Dungeon/Dungeon Floor Tile 0.png");
        //z, A, B, C, D
        tileSet[25].setImage("/Dungeon/Dungeon Floor Tile 1.png"); tileSet[26].setImage("/Dungeon/Dungeon Floor Tile 2.png"); tileSet[27].setImage("/Dungeon/Dungeon Wall Tile 0.png"); tileSet[28].setImage("/Path/Path Tile (BLC).png"); tileSet[29].setImage("/Path/Path Tile (BRC).png");
        //E, F, G, H, I
        tileSet[30].setImage("/Path/Path Tile (HB).png"); tileSet[31].setImage("/Path/Path Tile (HT).png"); tileSet[32].setImage("/Path/Path Tile (H0).png"); tileSet[33].setImage("/Path/Path Tile (H1).png"); tileSet[34].setImage("/Path/Path Tile (Inter).png");
        //J, K, L, M, N
        tileSet[35].setImage("/Path/Path Tile (TLC).png"); tileSet[36].setImage("/Path/Path Tile (TRC).png"); tileSet[37].setImage("/Path/Path Tile (VL).png"); tileSet[38].setImage("/Path/Path Tile (VR).png"); tileSet[39].setImage("/Path/Path Tile (V0).png");
        //O, P, Q, R, S
        tileSet[40].setImage("/Path/Path Tile (V1).png"); tileSet[41].setImage("/Wall/Stone Wall Tile (BE).png"); tileSet[42].setImage("/Wall/Stone Wall Tile (BLC).png"); tileSet[43].setImage("/Wall/Stone Wall Tile (BRC).png"); tileSet[44].setImage("/Wall/Stone Wall Tile (H).png");
        //T, U, V, W, X
        tileSet[45].setImage("/Wall/Stone Wall Tile (HB).png"); tileSet[46].setImage("/Wall/Stone Wall Tile (HT).png"); tileSet[47].setImage("/Wall/Stone Wall Tile (Inter).png"); tileSet[48].setImage("/Wall/Stone Wall Tile (LE).png"); tileSet[49].setImage("/Wall/Stone Wall Tile (RE).png");
        //Y, Z, 0, 1, 2
        tileSet[50].setImage("/Wall/Stone Wall Tile (TE).png"); tileSet[51].setImage("/Wall/Stone Wall Tile (TLC).png"); tileSet[52].setImage("/Wall/Stone Wall Tile (TRC).png"); tileSet[53].setImage("/Wall/Stone Wall Tile (V).png"); tileSet[54].setImage("/Wall/Stone Wall Tile (VL).png");
        //3, 4, 5, 6, 7
        tileSet[55].setImage("/Wall/Stone Wall Tile (VR).png"); tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 0.png"); tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 0.png"); tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 0.png"); tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 0.png");
        //8, 9, `, ~, !
        tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 0.png"); tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 0.png"); tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 0.png"); tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 0.png"); tileSet[64].setImage("/Water/Water Tile.png");
        //@, #, $, %, ^
        tileSet[65].setImage("/Transitions/Grass to Water Tiles (BCE).png"); tileSet[66].setImage("/Transitions/Grass to Water Tiles (BL).png"); tileSet[67].setImage("/Transitions/Grass to Water Tiles (BLC).png"); tileSet[68].setImage("/Transitions/Grass to Water Tiles (BR).png"); tileSet[69].setImage("/Transitions/Grass to Water Tiles (BRC).png");
        //&, *, (, ), -
        tileSet[70].setImage("/Transitions/Grass to Water Tiles (MLE).png"); tileSet[71].setImage("/Transitions/Grass to Water Tiles (MRE).png"); tileSet[72].setImage("/Transitions/Grass to Water Tiles (TCE).png"); tileSet[73].setImage("/Transitions/Grass to Water Tiles (TL).png"); tileSet[74].setImage("/Transitions/Grass to Water Tiles (TLC).png");
        //_, =, +, [, {,
        tileSet[75].setImage("/Transitions/Grass to Water Tiles (TR).png"); tileSet[76].setImage("/Transitions/Grass to Water Tiles (TRC).png"); tileSet[77].setImage(""); tileSet[78].setImage(""); tileSet[79].setImage("");
        //], }, \, |, ;,
        tileSet[80].setImage(""); tileSet[81].setImage(""); tileSet[82].setImage(""); tileSet[83].setImage(""); tileSet[84].setImage("");
        //:, ', ", ,, <,
        tileSet[85].setImage(""); tileSet[86].setImage(""); tileSet[87].setImage(""); tileSet[88].setImage(""); tileSet[89].setImage("");
        //., >, /, ?, ¡,
        tileSet[90].setImage(""); tileSet[91].setImage(""); tileSet[92].setImage(""); tileSet[93].setImage(""); tileSet[94].setImage("");
        //™, £, ¢, ∞, §,
        tileSet[95].setImage(""); tileSet[96].setImage(""); tileSet[97].setImage(""); tileSet[98].setImage(""); tileSet[99].setImage("");
        //¶
        tileSet[100].setImage("");
        setTileCollision();
    }

    public void setTileCollision (){
        tileSet[3].setCollision(true);
        tileSet[5].setCollision(true);
        tileSet[27].setCollision(true);
        for (int i = 41; i <= 55; i++){
            tileSet[i].setCollision(true);
        }
        for (int i = 64; i <= 76; i++) {
            tileSet[i].setCollision(true);
        }
    }

    public void getWorldMaps(String filePath, int[][] map){
        try{
            InputStream inputStream = getClass().getResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)));
            for (int i = 0; i < map.length ; i++) {
                String line = reader.readLine();
                String[] strings = line.split(" ");
                for (int j = 0;  j < map[i].length; j++) {
                    int num = mapKey(strings[j]);
                    map[j][i] = num;
                }
            }
            reader.close();
            mapArray.add(map);
        } catch (IOException e){
            e.printStackTrace();
        }
        for (int[] i : map) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public void draw(Graphics2D g2D) {
        int mapSizeX = 0;
        int mapSizeY = 0;
        switch (currentMap) {
            case ("OverWorld") -> {
                mapSizeX = getMapArray().get(0)[0].length;
                mapSizeY = getMapArray().get(0).length;
            }
            case ("FireDungeon") -> {
                mapSizeX = getMapArray().get(2)[0].length;
                mapSizeY = getMapArray().get(2).length;
            }
        }
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                int screenX = ((i * gPanel.getTileSize()) - gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX() + gPanel.getTileSize());
                int screenY = ((j * gPanel.getTileSize()) - gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY() + gPanel.getTileSize());
                if (j * gPanel.getTileSize() + ( 2 * gPanel.getTileSize()) > gPanel.getPlayer().getWorldY() - gPanel.getPlayer().getScreenY() &&
                        (i * gPanel.getTileSize() - gPanel.getTileSize() < gPanel.getPlayer().getWorldX() + gPanel.getPlayer().getScreenX()) &&
                        (i * gPanel.getTileSize() + (2 * gPanel.getTileSize()) > gPanel.getPlayer().getWorldX() - gPanel.getPlayer().getScreenX()) &&
                        (j * gPanel.getTileSize() - gPanel.getTileSize() < gPanel.getPlayer().getWorldY() + gPanel.getPlayer().getScreenY())) {
                                switch (currentMap) {
                                    case ("OverWorld") -> {
                                        g2D.drawImage(tileSet[mapArray.get(0)[i][j]].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                                        g2D.drawImage(tileSet[mapArray.get(1)[i][j]].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);

                                    }
                                    case ("FireDungeon") -> g2D.drawImage(tileSet[mapArray.get(2)[i][j]].getImage(), screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
                                }
                            }


            }
        }
    }

    public void update() {
        if (tileCounter % 10 == 0) {
            switch (tileFrame) {
                case (0) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 1.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 1.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 1.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 1.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 1.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 1.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 1.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 1.png");
                    tileFrame = 1;
                }
                case (1) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 2.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 2.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 2.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 2.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 2.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 2.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 2.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 2.png");
                    tileFrame = 2;
                }
                case (2) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 3.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 3.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 3.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 3.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 3.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 3.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 3.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 3.png");
                    tileFrame = 3;
                }
                case (3) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 4.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 4.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 4.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 4.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 4.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 4.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 4.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 4.png");
                    tileFrame = 4;
                }
                case (4) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 3.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 3.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 3.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 3.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 3.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 3.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 3.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 3.png");
                    tileFrame = 5;
                }
                case (5) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 2.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 2.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 2.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 2.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 2.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 2.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 2.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 2.png");
                    tileFrame = 6;
                }
                case (6) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 1.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 1.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 1.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 1.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 1.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 1.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 1.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 1.png");
                    tileFrame = 7;
                }
                case (7) -> {
                    tileSet[56].setImage("/Animated/DarkPortal/Dark Portal Tile Frame 0.png");
                    tileSet[57].setImage("/Animated/EarthPortal/Earth Portal Tile Frame 0.png");
                    tileSet[58].setImage("/Animated/FirePortal/Fire Portal Tile Frame 0.png");
                    tileSet[59].setImage("/Animated/LightningPortal/Lightning Portal Tile Frame 0.png");
                    tileSet[60].setImage("/Animated/LightPortal/Light Portal Tile Frame 0.png");
                    tileSet[61].setImage("/Animated/NaturePortal/Nature Portal Tile Frame 0.png");
                    tileSet[62].setImage("/Animated/WaterPortal/Water Portal Tile Frame 0.png");
                    tileSet[63].setImage("/Animated/WindPortal/Wind Portal Tile Frame 0.png");
                    tileFrame = 0;
                }
            }
        }
        tileCounter ++;
        if (tileCounter > 60){
            tileCounter = 0;
        }
    }

    public ArrayList<int[][]> getMapArray() {
        return mapArray;
    }

    public TileSet[] getTileSet() {
        return tileSet;
    }

    public String getCurrentMap() {
        return currentMap;
    }

    public void setCurrentMap(String currentMap) {
        this.currentMap = currentMap;
    }
}
