package Java.Entity;

import Java.Main.GUI;
import Java.Main.KeyInput;
import Java.Main.MouseInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {
    private final KeyInput keyInput;
    private final MouseInput mouseInput;
    private final GUI gPanel;

    private final int screenX;
    private final int screenY;
    private int keyCount = 0;
    private int hpPotionCount = 0;
    private int mpPotionCount = 0;
    private int lockCounter = 0;

    public Player(GUI gPanel, KeyInput keyInput, MouseInput mouseInput) {
        super(gPanel);
        this.gPanel = gPanel;
        this.keyInput = keyInput;
        this.mouseInput = mouseInput;

        screenX = ((gPanel.getScreenWidth() / 2) - gPanel.getTileSize());
        screenY = ((gPanel.getScreenHeight() / 2) - gPanel.getTileSize());

        hitBox = new Rectangle(20 , 16, 20, 50);
        hitBoxDefaultX = hitBox.x;
        hitBoxDefaultY = hitBox.y;

        setDefaultValues();
        getImage();
    }

    public void setDefaultValues() {
        setWorldX((getgPanel().getTileL().getMapArray().get(0).length / 2 + 1) * getgPanel().getTileSize());
        setWorldY((getgPanel().getTileL().getMapArray().get(0).length / 2 + 1) * getgPanel().getTileSize());
        velocity = 4;
        input = ("idle left");

        maxHealth = 200;
        currentHealth = maxHealth;
        maxMagic = 200;
        currentMagic = maxMagic;

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
            attackL0 = spriteSheet.getSubimage(1024, 0, spriteSize, spriteSize);
            attackL1 = spriteSheet.getSubimage(1088, 0, spriteSize, spriteSize);
            attackR0 = spriteSheet.getSubimage(1152, 0, spriteSize, spriteSize);
            attackR1 = spriteSheet.getSubimage(1216, 0, spriteSize, spriteSize);
        } catch (IOException e) {e.printStackTrace();}
    }

    public void update() {
        if (!mouseInput.isAttack()) {
            //Cardinal Directions
            if (keyInput.isUp()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("up left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("up right");}
            }
            if (keyInput.isLeft()) {input = ("left");}
            if (keyInput.isDown()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("down left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("down right");}
            }
            if (keyInput.isRight()) {input = ("right");}
            //Ordinal Direction
            if (keyInput.isUp() && keyInput.isLeft()) {input = ("NW");}
            if (keyInput.isUp() && keyInput.isRight()) {input = ("NE");}
            if (keyInput.isDown() && keyInput.isLeft()) {input = ("SW");}
            if (keyInput.isDown() && keyInput.isRight()) {input = ("SE");}


            //Specific Key Input Cases
            //All Keys Pressed
            if (keyInput.isUp() && keyInput.isLeft() && keyInput.isDown() && keyInput.isRight()) {input = ("idle left");}
            //No Keys Pressed
            if (!keyInput.isUp() && !keyInput.isLeft() && !keyInput.isDown() && !keyInput.isRight()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("idle left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("idle right");}
            }
            //Left & Right Keys Pressed
            if (!keyInput.isUp() && keyInput.isLeft() && !keyInput.isDown() && keyInput.isRight()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("idle right");}
                if (keyInput.getLastPressed().equals("right")) {input = ("idle left");}
            }
            //Up & Down Keys Pressed
            if (keyInput.isUp() && !keyInput.isLeft() && keyInput.isDown() && !keyInput.isRight()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("idle left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("idle right");}
            }
            //Left & Right & (Up or Down) Keys Pressed
            if (keyInput.isUp() && keyInput.isLeft() && !keyInput.isDown() && keyInput.isRight()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("up left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("up right");}
            }
            if (!keyInput.isUp() && keyInput.isLeft() && keyInput.isDown() && keyInput.isRight()) {
                if (keyInput.getLastPressed().equals("left")) {input = ("down left");}
                if (keyInput.getLastPressed().equals("right")) {input = ("down right");}
            }
            //Up & Down && (Right or Left) Keys Pressed
            if (keyInput.isUp() && keyInput.isLeft() && keyInput.isDown() && !keyInput.isRight()) {input = ("left");}
            if (keyInput.isUp() && !keyInput.isLeft() && keyInput.isDown() && keyInput.isRight()) {input = ("right");}
        } else {
            if (keyInput.getLastPressed().equals("left")) {input = ("attack left");}
            if (keyInput.getLastPressed().equals("right")){input = ("attack right");}
        }

        collision = false;
        getgPanel().getECollision().tileCollision(this);
        obtained(getgPanel().getECollision().objectCollision(this, true));

        if (!collision && !mouseInput.isAttack()) {
            switch (input){
                case ("NE") -> {
                    worldY -= velocity;
                    worldX += velocity;
                }
                case ("up left"), ("up right") -> worldY -= velocity;
                case ("NW") -> {
                    worldY -= velocity;
                    worldX -= velocity;
                }
                case ("left") -> worldX -= velocity;
                case ("SW") -> {
                    worldY += velocity;
                    worldX -= velocity;
                }
                case ("down left"), ("down right") -> worldY += velocity;
                case ("SE") -> {
                    worldY += velocity;
                    worldX += velocity;
                }
                case ("right") -> worldX += velocity;
                case ("attack left"), ("attack right") -> {}
            }
        }
        
        getgPanel().geteHandler().checkEvent();

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
        if (getgPanel().getMouseInput().isAttack()) {
            //attackCounter++;
            if (attackCounter > 16) {
                if (attackNum == 0) {
                    attackNum = 1;
                    getgPanel().playSoundEffect(2);
                }
                else if (attackNum == 1) {
                    attackNum = 0;
                    getgPanel().playSoundEffect(3);
                }
                attackCounter = 0;
            }
        } else {
            attackCounter = 0;
        }

    }

    public void draw(Graphics2D g2D) {
        BufferedImage image = null;
        switch (input) {
            case ("left"), ("up left"), ("down left"), ("NW"), ("SW") -> {
                switch (spriteNum) {
                    case (0) -> image = left0;
                    case (1) -> image = left1;
                    case (2) -> image = left2;
                    case (3) -> image = left3;
                    case (4) -> image = left4;
                    case (5) -> image = left5;
                }
            }
            case ("right"), ("up right"), ("down right"), ("NE"), ("SE") -> {
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
            case ("attack left") -> {
                if (attackNum == 0) {
                    image = attackL0;
                }
                if (attackNum == 1) {
                    image = attackL1;
                }
            }
            case ("attack right") -> {
                if (attackNum == 0) {
                    image = attackR0;
                }
                if (attackNum == 1) {
                    image = attackR1;
                }
            }

        }
        g2D.drawImage(image, screenX, screenY, getgPanel().getTileSize(), getgPanel().getTileSize(), null);
        g2D.setColor(new Color(85, 222, 14, 255));
        if (image == attackL1){
            g2D.draw(new Rectangle(hitBox.x + screenX + 17, hitBox.y + screenY, hitBox.width, hitBox.height));
        } else if (image == attackR1) {
            g2D.draw(new Rectangle(hitBox.x + screenX - 17, hitBox.y + screenY, hitBox.width, hitBox.height));
        } else {
            g2D.draw(new Rectangle(hitBox.x + screenX, hitBox.y + screenY, hitBox.width, hitBox.height));
        }
    }

    public void obtained(int index){
        if (index != 999) {
            String name = gPanel.getObjectL().getGameObjects()[index].getName();

            switch (name) {
                case ("Key") -> {
                    keyCount ++;
                    gPanel.getObjectL().getGameObjects()[index] = null;

                    gPanel.getUserI().showMessage("A Key has been obtained!");
                }
                case ("Lock") -> {
                    if (keyCount > 0) {
                        keyCount --;
                        gPanel.getObjectL().getGameObjects()[index] = null;
                        gPanel.playSoundEffect(5);
                        gPanel.getUserI().showMessage("A Lock has been removed!");
                    } else {

                        lockCounter ++;
                        if (lockCounter > 50) {
                            gPanel.playSoundEffect(7);
                            gPanel.getUserI().showMessage("You do not have a Key!");
                            lockCounter = 0;
                        }
                    }
                }
                case ("Health Potion") -> {
                    hpPotionCount ++;
                    gPanel.getObjectL().getGameObjects()[index] = null;
                    gPanel.playSoundEffect(6);
                    gPanel.getUserI().showMessage("A Health Potion has been obtained!");

                }
                case ("Magic Potion") -> {
                    mpPotionCount ++;
                    gPanel.getObjectL().getGameObjects()[index] = null;
                    gPanel.playSoundEffect(6);
                    gPanel.getUserI().showMessage("A Magic Potion has been obtained!");
                }
                case ("End Flag") -> {
                    gPanel.gameState = gPanel.endState;
                    gPanel.stopAudio();
                    //gPanel.playSoundEffect();
                }
            }
        }
    }

    public int getScreenX() {return screenX;}
    public int getScreenY() {return screenY;}
    public int getWorldX(){return (worldX);}
    public int getWorldY(){return (worldY);}
}
