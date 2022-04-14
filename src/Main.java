//TODO:
// 1. Add inventory,
// 2. Add items to inventory,
// 3. Try to find a way to add sprites (done)
// 4. Link keys to attacks
// 5. Find a way to use 2d arrays in the project. (Possible implementation found in Inventory)
// 6. Find a way to use arrayList. (Possible implementation found in Inventory)
// 7. Find a way to use sorting algorithms.

import java.awt.*;
import java.awt.image.BufferStrategy;


/**
 * @author Kevin Jiang
 * @version 1.6
 * @since 1.0
 */
public class Main extends Canvas implements Runnable {

    public static final int WIDTH = (640);
    public static final int HEIGHT = ((WIDTH / 12 * 9) + 300);
    private Thread t0;
    private boolean running = false;
    private final Handler handler;
    private final HUD hud;
    private final Spawner spawner;

    /**
     * @updated 1.1, 1.2
     */
    public Main(){
        handler = new Handler();

        hud = new HUD();

        this.addKeyListener(new KeyInput(handler, hud));


        spawner = new Spawner(handler, hud);

        new GUI(WIDTH, HEIGHT, "Advent of Elements v2", this);

        handler.addObject(new Character((WIDTH / 2) - 16, ((HEIGHT - 300) / 2) - 16, ID.Character, handler));
    }

    public synchronized void start(){
        t0 = new Thread(this);
        t0.start();
        running = true;
    }

    public synchronized void stop(){
        try {
            t0.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @updated 1.3
     */
    public void run() {
        this.requestFocus();
        long lastTime = (System.nanoTime());
        double tickCount = (60.0);
        double ns = (1000000000 / tickCount);
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while (delta >= 1){
                tick();
                delta --;
            }
            if (running) {
                render();
            }
            frames ++;
            if (System.currentTimeMillis() - timer > 1000) {

                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    /**
     * @updated 1.3
     */
    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();

        if (HUD.health == 0){
            stop();
        }
    }

    /**
     * @updated 1.2
     */
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.setBackground(new Color(0, 0, 0));
        g.setColor(new Color(70, 70, 70));
        g.fillRect(0, 0, WIDTH, HEIGHT - 300);
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, HEIGHT - 300, WIDTH, HEIGHT - 400);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max){
        if (var >= max){
            return (max);
        } else {
            return Math.max(var, min);
        }
    }

    /**
     * @param args the main method
     */
    public static void main(String[] args){
        new Main();
    }


}
