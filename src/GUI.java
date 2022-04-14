import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * @since 1.0
 */
public class GUI extends JFrame {

    /**
     * @param width The width of the GUI
     * @param height The height of the GUI
     * @param title The name pf the GUI
     * @param game An instance of Main class
     * @updated 1.2
     */
    public GUI (int width, int height, String title, Main game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
