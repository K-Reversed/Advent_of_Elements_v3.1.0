package Java.Objects;

import Java.Entity.Projectile;
import Java.Main.GUI;

public class FireBall extends Projectile {
    GUI gPanel;
    public FireBall(GUI gPanel) {
        super(gPanel);
        this.gPanel = gPanel;
        getImage();
    }
    public void getImage (){
    }

}
