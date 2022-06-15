package Java.Objects;

import Java.Main.GUI;

public class Key extends GameObjects{
    public Key (GUI gPanel) {
        super(gPanel);
        setName("Key");
        setImage("/Key.png");
    }

    public String toString() {
        return getName();
    }
}
