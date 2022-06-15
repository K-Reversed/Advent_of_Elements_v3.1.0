package Java.Objects;

import Java.Main.GUI;

public class HPPotion extends GameObjects {
    public HPPotion (GUI gPanel) {
        super(gPanel);

        setName("Health Potion");
        setImage("/Health Potion.png");
    }

    public String toString() {
        return getName();
    }
}
