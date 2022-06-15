package Java.Objects;

import Java.Main.GUI;

public class Lock extends GameObjects {
    public Lock(GUI gPanel) {
        super(gPanel);

        setName("Lock");
        setImage("/Lock.png");
        setCollision(true);
    }

    public String toString() {
        return getName();
    }
}
