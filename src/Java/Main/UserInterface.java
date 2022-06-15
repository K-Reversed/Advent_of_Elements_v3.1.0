package Java.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class UserInterface {
    private final GUI gPanel;
    private Graphics2D g2D;
    private final Font robotoBold80, roboto40, roboto10;
    private final Color blue, green, white;
    private final DecimalFormat dFormat = new DecimalFormat("#0.00");
    private String message = "";
    private int messageCounter = 0;
    public int commandNum = 0;
    private double gameTime = 0.00;
    private boolean messaged = false;



    public UserInterface (GUI gPanel){
        this.gPanel = gPanel;
        robotoBold80 = new Font("Roboto", Font.BOLD, 80);
        roboto40 = new Font("Roboto", Font.PLAIN, 40);
        roboto10 = new Font("Roboto", Font.PLAIN, 10);
        blue = new Color(0, 0, 255);
        green = new Color(0, 255, 0);
        white = new Color(255, 255, 255);
    }

    public void showMessage (String text){
        message = text;
        messaged = true;
    }

    public void draw (Graphics2D g2D) {
        this.g2D = g2D;
        g2D.setFont(roboto40);
        g2D.setColor(white);
        if (gPanel.gameState == gPanel.startUpState){
            startUp();
        }
        if (gPanel.gameState == gPanel.titleState){
            titleScreen();
        }
        if (gPanel.gameState == gPanel.playState){
            playerHealthBar();
            playerMagicBar();
        }
        if (gPanel.gameState == gPanel.pauseState){
            playerHealthBar();
            playerMagicBar();
            pauseScreen();
        }
        if (gPanel.gameState == gPanel.dialogueState){
            dialoguePanel();
        }
        if (gPanel.gameState == gPanel.endState) {
            gameEnd();
        }
        gameTime += 1.00 / 60;
        if (messaged) {
            g2D.setFont(roboto10);
            g2D.drawString(message, (gPanel.getTileSize() / 2), gPanel.getScreenHeight() - (gPanel.getTileSize() / 2));

            messageCounter++;
            if (messageCounter > 100) {
                messaged = false;
                messageCounter = 0;
            }
        }
    }

    public void startUp(){

    }
    public void titleScreen(){
        BufferedImage image = null;
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/png/SpriteSheets/Icon Sheet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2D.setColor(new Color(79, 164, 250));
        g2D.fillRect(0, 0, gPanel.getScreenWidth(), gPanel.getScreenHeight());
        g2D.setFont(robotoBold80);

        String text = "Advent of Elements v3";
        int x = centerTextX(text);
        int y = gPanel.getTileSize() * 2;

        g2D.setColor(new Color(54, 54, 54));
        g2D.drawString(text, x + 5, y + 5);

        g2D.setColor(new Color(123, 0, 255, 255));
        g2D.drawString(text, x, y);

        x = gPanel.getScreenWidth() / 2;
        y += gPanel.getTileSize() * 2;
        assert image != null;
        g2D.drawImage(image.getSubimage(16, 0, 16, 16), x - gPanel.getTileSize() * 2, y, gPanel.getTileSize() * 4, gPanel.getTileSize() * 4, null);

        g2D.setFont(g2D.getFont().deriveFont(Font.BOLD, 48F));

        text = "NEW GAME";
        x = centerTextX(text);
        y += gPanel.getTileSize() * 5;
        g2D.drawString(text, x, y);
        if (commandNum == 0){
            g2D.drawString("->", x - gPanel.getTileSize(), y);
        }

        text = "LOAD GAME";
        x = centerTextX(text);
        y += gPanel.getTileSize();
        g2D.drawString(text, x, y);
        if (commandNum == 1){
            g2D.drawString("->", x - gPanel.getTileSize(), y);
        }

        text = "QUIT";
        x = centerTextX(text);
        y += gPanel.getTileSize();
        g2D.drawString(text, x, y);
        if (commandNum == 2){
            g2D.drawString("->", x - gPanel.getTileSize(), y);
        }
    }
    public void playerHealthBar(){
        int x = gPanel.getTileSize() / 2;
        int y = gPanel.getTileSize() / 2;

        g2D.setColor(Color.red);
        g2D.fillRect(x, y, gPanel.getPlayer().currentHealth, y);
        g2D.setColor(Color.black);
        g2D.drawRect(x, y, gPanel.getPlayer().maxHealth, y);
    }
    public void playerMagicBar() {
        int x = gPanel.getScreenWidth() - 6 * gPanel.getTileSize() / 2;
        int y = gPanel.getTileSize() / 2;

        g2D.setColor(Color.blue);
        g2D.fillRect(x, y, gPanel.getPlayer().currentMagic, y);
        g2D.setColor(Color.black);
        g2D.drawRect(x, y, gPanel.getPlayer().maxMagic, y);
    }
    public void pauseScreen (){
        g2D.setFont(robotoBold80);
        String text = "PAUSED";

        int x = centerTextX(text);
        int y = gPanel.getScreenHeight() / 2;
        g2D.drawString(text, x, y);
    }
    public void dialoguePanel (){
        // currently empty
    }
    public void gameEnd () {
        String text = "Game End";
        int textLength = (int)(g2D.getFontMetrics().getStringBounds(text, g2D).getWidth());
        int x = ((gPanel.getScreenWidth() / 2) - textLength);
        int y = (gPanel.getScreenHeight() / 2) - (3 * gPanel.getTileSize());
        g2D.setColor(green);
        g2D.setFont(robotoBold80);
        g2D.drawString(text, x, y);
        gPanel.stopAudio();
        gPanel.setThread(null);
        System.out.println("Total play time: " + dFormat.format(gameTime));
    }

    public int centerTextX (String text){
        int length = (int)g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();
        return (gPanel.getScreenWidth() / 2 - length / 2);

    }

}
