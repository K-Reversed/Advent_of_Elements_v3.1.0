package Others;

import Main.Main;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @since 1.1
 * @updated 1.4, 1.5
 */
public class Character extends GameObject {
    private BufferedImage up0, up1, down0, down1, left0, left1, right0, right1;
    private static String direction;
    private int spriteNum = 0;

    private final Handler handler;

    public Character(int x, int y, ID id, Handler handler){
        super(x, y, id, handler);
        this.handler = handler;
        characterSprite();
        direction = "down";
    }

    public void characterSprite (){
        try {
            up0 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-up-frame-0.png")));
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-up-frame-1.png")));

            left0 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-left-frame-0.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-left-frame-1.png")));

            right0 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-right-frame-0.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-right-frame-1.png")));

            down0 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-down-frame-0.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("res/png/Old-Wizard-Sprite/wizard-down-frame-1.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void tick() {
        x += vX;
        y += vY;

        x = Main.clamp(x, -8, Main.WIDTH - 23);
        y = Main.clamp(y, -4, Main.HEIGHT - 332);

        collision();
    }



    public void render(Graphics2D g) {
        BufferedImage image = null;
        switch (direction) {
            case ("up") -> {
                if (spriteNum <= 100){
                    image = up0;
                }
                if (spriteNum >= 100) {
                    image = up1;
                }
            }
            case ("down") -> {
                if (spriteNum <= 100){
                    image = down0;
                }
                if (spriteNum >= 100) {
                    image = down1;
                }
            }
            case ("left") -> {
                if (spriteNum <= 100){
                    image = left0;
                }
                if (spriteNum >= 100) {
                    image = left1;
                }
            }
            case ("right") -> {
                if (spriteNum <= 100){
                    image = right0;
                }
                if (spriteNum >= 100) {
                    image = right1;
                }
            }
            case ("spin") -> {
                if (spriteNum % 100 <= 25){
                    image = up0;
                }
                if (spriteNum % 100 > 25 && spriteNum % 100 <= 50){
                    image = left0;
                }
                if (spriteNum % 100 > 50 && spriteNum % 100 <= 75){
                    image = down0;
                }
                if (spriteNum % 100 > 75){
                    image = right0;
                }
            }
        }
        g.drawImage(image, x, y, 32, 32, null);
        spriteNum ++;
        if (spriteNum > 200){
            spriteNum = 0;
        }
    }

    private void collision(){
        for (int i = 0; i < handler.gameObjects.size(); i++ ){
            GameObject temp = handler.gameObjects.get(i);
            if (temp.getId() == ID.Enemy0 || temp.getId() == ID.Enemy2){
                if (getBounds().intersects(temp.getBounds())){
                    HUD.health -= 2;
                }
            }
            if (temp.getId() == ID.Enemy1){
                if (getBounds().intersects(temp.getBounds())){
                    HUD.health -= 5;
                }
            }
            if (temp.getId() == ID.Enemy3){
                if (getBounds().intersects(temp.getBounds())){
                    HUD.health -= 3;
                }
            }

        }
    }


    public static void setDirection(String d) {
        direction = d;
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 8, y + 4, 15, 28 );
    }
    public static String getDirection() {
        return direction;
    }
    public int getX() {
        return super.getX();
    }
    public int getY() {
        return super.getY();
    }
    public int getVX() {
        return super.getVX();
    }
    public int getVY() {
        return super.getVY();
    }
}