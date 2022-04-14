import java.awt.*;

/**
 * @since 1.1
 */
public abstract class GameObject {
    protected int x;
    protected int y;
    protected int vX;
    protected int vY;
    protected ID id;
    protected Handler handler;


    public GameObject (int x, int y, ID id, Handler handler){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }

    public abstract void tick();
    /**
     * @param g renders graphics on gui.
     * @updated 1.4
     */
    public abstract void render(Graphics2D g);

    /**
     * @return sets the borders for Game objects
     */
    public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setVX(int vX) {
        this.vX = vX;
    }
    public void setVY(int vY) {
        this.vY = vY;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getVX() {
        return vX;
    }
    public int getVY() {
        return vY;
    }
    public ID getId() {
        return id;
    }
}
