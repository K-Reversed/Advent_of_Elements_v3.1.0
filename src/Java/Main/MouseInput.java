package Java.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    private final GUI gPanel;
    private boolean attack = false;
    public MouseInput (GUI gPanel){
        this.gPanel = gPanel;
    }

    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
        attack = true;
    }
    public void mouseReleased(MouseEvent e) {
        attack = false;
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {
    }

    public boolean isAttack() {
        return attack;
    }
}
