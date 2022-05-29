package Entity;

import Main.GUI;
import Main.KeyInput;
import Main.MouseInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    private final GUI gPanel;
    private final KeyInput keyInput;
    private final MouseInput mouseInput;

    private final int screenX;
    private final int screenY;

    public Player(GUI gPanel, KeyInput keyInput, MouseInput mouseInput) {
        this.gPanel = gPanel;
        this.keyInput = keyInput;
        this.mouseInput = mouseInput;

        screenX = ((gPanel.getScreenWidth() / 2) - gPanel.getTileSize());
        screenY = ((gPanel.getScreenHeight() / 2) - gPanel.getTileSize());

        setDefaultValues();
        getImage();
    }
    public void setDefaultValues() {
        worldX = ((gPanel.getMaxWorldRow() / 2 - 1) * gPanel.getTileSize());
       worldY = ((gPanel.getMaxWorldColumn() / 2) * gPanel.getTileSize());
        velocity = 4;
        direction = ("idle left");
    }

    public void getImage() {
        try {
            spriteSize = 64;
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/SpriteSheets/Wizard 3.0 Sprite Sheet.png")));
            idleR0 = spriteSheet.getSubimage(0,0, spriteSize, spriteSize);
            idleR1 = spriteSheet.getSubimage(64, 0, spriteSize, spriteSize);
            idleL0 = spriteSheet.getSubimage(512, 0, spriteSize, spriteSize);
            idleL1 = spriteSheet.getSubimage(576, 0, spriteSize, spriteSize);
            right0 = spriteSheet.getSubimage(128, 0, spriteSize, spriteSize);
            right1 = spriteSheet.getSubimage(192, 0, spriteSize, spriteSize);
            right2 = spriteSheet.getSubimage(256, 0, spriteSize, spriteSize);
            right3 = spriteSheet.getSubimage(320, 0, spriteSize, spriteSize);
            right4 = spriteSheet.getSubimage(384, 0, spriteSize, spriteSize);
            right5 = spriteSheet.getSubimage(448, 0, spriteSize, spriteSize);
            left0 = spriteSheet.getSubimage(640, 0, spriteSize, spriteSize);
            left1 = spriteSheet.getSubimage(704, 0, spriteSize, spriteSize);
            left2 = spriteSheet.getSubimage(768, 0, spriteSize, spriteSize);
            left3 = spriteSheet.getSubimage(896, 0, spriteSize, spriteSize);
            left4 = spriteSheet.getSubimage(832, 0, spriteSize, spriteSize);
            left5 = spriteSheet.getSubimage(960, 0, spriteSize, spriteSize);
            up0 = null;
            up1 = null;
            down0 = null;
            down1 = null;
        } catch (IOException e) {e.printStackTrace();}
    }

    public void update() {
        if (keyInput.isUp()){
            if (keyInput.getLastPressed().equals("left")) {direction = ("left");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("right");}
           worldY-= velocity;
        }
        if (keyInput.isLeft()){
            direction = ("left");
            worldX -= velocity;
        }
        if (keyInput.isDown()){
            if (keyInput.getLastPressed().equals("left")) {direction = ("left");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("right");}
           worldY+= velocity;
        }
        if (keyInput.isRight()){
            direction = ("right");
            worldX += velocity;
        }

        //Specific Key Input Cases
        //All Keys Pressed
        if (keyInput.isUp() && keyInput.isLeft() && keyInput.isDown() && keyInput.isRight()) {
            direction = ("idle left");
        }
        //No Keys Pressed
        if (!keyInput.isUp() && !keyInput.isLeft() && !keyInput.isDown() && !keyInput.isRight()) {
            if (keyInput.getLastPressed().equals("left")) {direction = ("idle left");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("idle right");}
        }
        //Left & Right Keys Pressed
        if (!keyInput.isUp() && keyInput.isLeft() && !keyInput.isDown() && keyInput.isRight()) {
            if (keyInput.getLastPressed().equals("left")) {direction = ("idle right");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("idle left");}
        }
        //Up & Down Keys Pressed
        if (keyInput.isUp() && !keyInput.isLeft() && keyInput.isDown() && !keyInput.isRight()) {
            if (keyInput.getLastPressed().equals("left")) {direction = ("idle left");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("idle right");}
        }
        //Left + Up or Down Keys Pressed
        if ((keyInput.isUp() || keyInput.isDown()) && keyInput.isLeft() && !keyInput.isRight()) {
            direction = ("left");
        }
        //Right + Up or Down Keys Pressed
        if ((keyInput.isUp() && keyInput.isDown()) && !keyInput.isLeft() && keyInput.isRight()) {
            direction = ("right");
        }
        spriteCounter ++;
        idleCounter ++;
        if (spriteCounter > 6) {
            switch (spriteNum) {
                case (0) -> spriteNum = 1;
                case (1) -> spriteNum = 2;
                case (2) -> spriteNum = 3;
                case (3) -> spriteNum = 4;
                case (4) -> spriteNum = 5;
                case (5) -> spriteNum = 0;
            }
            spriteCounter = 0;
        }
        if (idleCounter > 20) {
            if (idleNum == 0) {idleNum = 1;}
            else if (idleNum == 1) {idleNum = 0;}
            idleCounter = 0;
        }
    }

    public void draw(Graphics2D g2D) {
        BufferedImage image = null;
        switch (direction) {
            case ("left") -> {
                switch (spriteNum) {
                    case (0) -> image = left0;
                    case (1) -> image = left1;
                    case (2) -> image = left2;
                    case (3) -> image = left3;
                    case (4) -> image = left4;
                    case (5) -> image = left5;
                }
            }
            case ("right") -> {
                switch (spriteNum) {
                    case (0) -> image = right0;
                    case (1) -> image = right1;
                    case (2) -> image = right2;
                    case (3) -> image = right3;
                    case (4) -> image = right4;
                    case (5) -> image = right5;
                }
            }
            case ("idle left") -> {
                if (idleNum == 0) {image = idleL0;}
                if (idleNum == 1) {image = idleL1;}
            }
            case ("idle right") -> {
                if (idleNum == 0) {image = idleR0;}
                if (idleNum == 1) {image = idleR1;}
            }
        }
        g2D.drawImage(image, screenX, screenY, gPanel.getTileSize(), gPanel.getTileSize(), null);
    }

    public int getScreenX() {
        return screenX;
    }
    public int getScreenY() {
        return screenY;
    }
    public int getWorldX(){
        return (worldX);
    }
    public int getWorldY(){
        return (worldY);
    }
}
