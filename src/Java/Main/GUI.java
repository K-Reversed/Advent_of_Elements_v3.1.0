package Java.Main;

import Java.Entity.Player;
import Java.Tile.TileLoader;
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

    private final TileLoader tileL = new TileLoader(this);
    private final KeyInput keyInput = new KeyInput(this);
    private final AudioPlayer mPlayer = new AudioPlayer();
    private final AudioPlayer sEPlayer = new AudioPlayer();
    private final MouseInput mouseInput = new MouseInput(this);
    private final UserInterface userI = new UserInterface(this);
    private Thread thread;
    private final EntityCollision eCollision = new EntityCollision(this);
    private final ObjectLoader objectL = new ObjectLoader(this);
    private final EventHandler eHandler = new EventHandler(this);
    private final Player player = new Player(this, keyInput, mouseInput);

    private final Font miniFont = new Font("Arial", Font.PLAIN, 10);

    //Game State
    public int gameState;
    public final int startUpState = 0;
    public final int titleState = 1;
    public final int playState = 2;
    public final int pauseState = 3;
    public final int dialogueState = 4;
    public final int endState = 5;


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

    public void initiate(){
        objectL.loadObjects();
        objectL.loadNPCs();
        //objectL.loadMonsters();
        gameState = titleState;
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
        int drawCount = 0;
        while (thread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / tick;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (gameState == playState){
            player.update();
            tileL.update();
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = ((Graphics2D) g);
        long drawStart = 0;

        if (keyInput.isDrawDebug()) {
            drawStart = System.nanoTime();
        }

        if (gameState == titleState){
            userI.draw(g2D);
        } else {

            tileL.draw(g2D);

            for (int i = 0; i < objectL.getGameObjects().length; i++) {
                if (objectL.getGameObjects()[i] != null) {
                    objectL.getGameObjects()[i].draw(g2D, this);
                }
            }

            for (int i = 0; i < objectL.getNpc().length; i++) {
                if (objectL.getNpc()[i] != null) {
                    objectL.getNpc()[i].draw(g2D);
                }
            }
//
//            for (int i = 0; i < objectL.getMonster().length; i++) {
//                if (objectL.getMonster()[i] != null) {
//                    objectL.getMonster()[i].draw(g2D);
//                }
//            }

            player.draw(g2D);

            userI.draw(g2D);
        }
        long drawEnd = System.nanoTime();
        long passed = drawEnd - drawStart;

        if (keyInput.isDrawDebug()) {
            g2D.setColor(Color.black);
            g2D.setFont(miniFont);
            g2D.drawString("Draw Time: " + passed, 100, 400);
            System.out.println("Draw Time: " + passed);
        }

        g2D.dispose();
    }

    public void playAudio(int i){
        mPlayer.setFile(i);
        mPlayer.play();
        mPlayer.loop();
    }

    public void stopAudio() {
        mPlayer.stop();
    }

    public void playSoundEffect(int i){
        sEPlayer.setFile(i);
        sEPlayer.play();
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public int getTileSize() {
        return tileSize;
    }
    public int getScreenWidth() {
        return screenWidth;
    }
    public int getScreenHeight() {
        return screenHeight;
    }
    public EntityCollision getECollision() {
        return eCollision;
    }
    public TileLoader getTileL() {
        return tileL;
    }
    public ObjectLoader getObjectL() {
        return objectL;
    }
    public Player getPlayer() {
        return player;
    }
    public MouseInput getMouseInput() {
        return mouseInput;
    }
    public UserInterface getUserI() {
        return userI;
    }

    public EventHandler geteHandler() {
        return eHandler;
    }
}
