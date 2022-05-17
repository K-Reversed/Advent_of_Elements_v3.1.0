package Entity;

import Main.GUI;
import Main.KeyInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    private final GUI gPanel;
    private final KeyInput keyInput;

    public Player(GUI gPanel, KeyInput keyInput) {
        this.gPanel = gPanel;
        this.keyInput = keyInput;

        setDefaultValues();
        getSprite();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        velocity = 3;
        direction = ("idle left");
    }

    public void getSprite() {
        try {
            spriteSize = 64;
            spriteSheet = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/SpriteSheets/Wizard 2.0 Sprite Sheet.png")));
            idleR0 = spriteSheet.getSubimage(0,0, spriteSize, spriteSize);
            idleR1 = spriteSheet.getSubimage(64, 0, spriteSize, spriteSize);
            right0 = spriteSheet.getSubimage(128, 0, spriteSize, spriteSize);
            right1 = spriteSheet.getSubimage(192, 0, spriteSize, spriteSize);
            idleL0 = spriteSheet.getSubimage(256, 0, spriteSize, spriteSize);
            idleL1 = spriteSheet.getSubimage(320, 0, spriteSize, spriteSize);
            left0 = spriteSheet.getSubimage(384, 0, spriteSize, spriteSize);
            left1 = spriteSheet.getSubimage(448, 0, spriteSize, spriteSize);
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
            y -= velocity;
        }
        if (keyInput.isLeft()){
            direction = ("left");
            x -= velocity;
        }
        if (keyInput.isDown()){
            if (keyInput.getLastPressed().equals("left")) {direction = ("left");}
            if (keyInput.getLastPressed().equals("right")) {direction = ("right");}
            y += velocity;
        }
        if (keyInput.isRight()){
            direction = ("right");
            x += velocity;
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
        if (spriteCounter > 10) {
            if (spriteNum == 0) {spriteNum = 1;}
            else if (spriteNum == 1) {spriteNum = 0;}
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
                if (spriteNum == 0) {image = left0;}
                if (spriteNum == 1) {image = left1;}
            }
            case ("right") -> {
                if (spriteNum == 0) {image = right0;}
                if (spriteNum == 1) {image = right1;}
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
        g2D.drawImage(image, x, y, gPanel.getTileSize(), gPanel.getTileSize(), null);
    }
}
