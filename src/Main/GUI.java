package Main;

import Entity.Player;
import Tile.TileLoader;

import javax.swing.*;
import java.awt.*;

/**
 * @since 2.1.0
 * @updated 3.1.0
 */
public class GUI extends JPanel implements Runnable {

    //Screen Settings
    private final int originalTileSize = 32;
    private final double scale = 2.5;
    private final int tileSize = (int) (originalTileSize * scale);
    private final int column = 16;
    private final int row = 12;
    private final int screenWidth = tileSize * column;
    private final int screenHeight = tileSize * row;
    private final int maxWorldColumn = 31;
    private final int maxWorldRow = 31;

    private final TileLoader tileL = new TileLoader(this);
    private final KeyInput keyInput = new KeyInput(this);
    private final MouseInput mouseInput = new MouseInput(this);
    private Thread thread;
    private final EntityCollision eCollision = new EntityCollision(this);

    Player player = new Player(this, keyInput, mouseInput);

    /**
     * @updated 2.1.2, 3.1.0
     */
    public GUI() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setMaximumSize(new Dimension(screenWidth, screenHeight));
        this.setMinimumSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(0, 0, 0));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyInput);
        this.addMouseListener(mouseInput);
        this.setFocusable(true);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int FPS = 60;
        double tick = 1000000000f / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawcount = 0;
        while (thread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / tick;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawcount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawcount);
                drawcount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = ((Graphics2D) g);

        tileL.draw(g2D);

        player.draw(g2D);

        g2D.dispose();
    }
    public int getTileSize() {
        return tileSize;
    }
    public int getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public int getMaxWorldColumn() {
        return maxWorldColumn;
    }
    public int getMaxWorldRow() {
        return maxWorldRow;
    }
    public int getWorldWidth() {
        return (tileSize * maxWorldColumn);
    }
    public int getWorldHeight() {
        return (tileSize * maxWorldRow);
    }
    public EntityCollision geteCollision() {
        return eCollision;
    }
    public TileLoader getTileL() {
        return tileL;
    }

    public Player getPlayer() {
        return player;
    }

}
