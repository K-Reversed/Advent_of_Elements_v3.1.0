package Java.Main;

import Java.Objects.HPPotion;
import Java.Objects.Key;
import Java.Objects.MPPotion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UserInterface {
    private final GUI gPanel;
    private final Font robotoBold80, roboto40, roboto10;
    private final Color blue, green;
    private final BufferedImage image0, image1, image2;
    private boolean messaged = false;
    private String message = "";
    private int messageCounter = 0;
    private boolean gameEnd = false;
    private double gameTime = 0;
    private final DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UserInterface (GUI gPanel){
        this.gPanel = gPanel;
        robotoBold80 = new Font("Roboto", Font.BOLD, 80);
        roboto40 = new Font("Roboto", Font.PLAIN, 40);
        roboto10 = new Font("Roboto", Font.PLAIN, 10);
        blue = new Color(0, 0, 255);
        green = new Color(5, 255, 0);

        Key key = new Key();
        HPPotion hpPotion = new HPPotion();
        MPPotion mpPotion = new MPPotion();
        image0 = key.getImage(0);
        image1 = hpPotion.getImage(0);
        image2 = mpPotion.getImage(0);
    }

    public void showMessage (String text){
        message = text;
        messaged = true;
    }

    public void draw (Graphics2D g2D) {

        if (gameEnd) {
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
        } else {
            g2D.setFont(roboto40);
            g2D.setColor(blue);
            g2D.drawImage(image0, (gPanel.getTileSize() / 4), (gPanel.getTileSize() / 4), gPanel.getTileSize(), gPanel.getTileSize(), null);
            g2D.drawImage(image1, (gPanel.getTileSize() / 4), (gPanel.getTileSize() + (gPanel.getTileSize() / 4)), gPanel.getTileSize(), gPanel.getTileSize(), null);
            g2D.drawImage(image2, (gPanel.getTileSize() / 4), (2 * gPanel.getTileSize() + (gPanel.getTileSize() / 4)), gPanel.getTileSize(), gPanel.getTileSize(), null);
            g2D.drawString("x " + gPanel.getPlayer().getKeyCount(), gPanel.getTileSize(), gPanel.getTileSize());
            g2D.drawString("x " + gPanel.getPlayer().getHpPotionCount(), gPanel.getTileSize(), 2 * gPanel.getTileSize());
            g2D.drawString("x " + gPanel.getPlayer().getMpPotionCount(), gPanel.getTileSize(), 3 * gPanel.getTileSize());

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
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}
