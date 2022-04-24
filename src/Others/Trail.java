package Others;

import java.awt.*;

public class Trail extends GameObject{
    private float alpha = 1;
    private final Handler handler;
    private final Color color;
    private final int width;
    private final int height;
    private final float life;

    public Trail(int x, int y, ID id, Handler handler, int width, int height, float life, Color color) {
        super(x, y, id, handler);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;

    }

    public void tick() {
        if (alpha > life){
            alpha -= (life - 0.001f);
        } else {
            handler.removeObject(this);
        }
    }

    public void render(Graphics2D g) {
        g.setComposite(transparency(alpha));

       g.setColor(color);
       g.fillRect(x, y, width, height);
    }

    private AlphaComposite transparency (float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}
