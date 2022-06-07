package Java.Objects;

public class HPPotion extends GameObjects {
    public HPPotion () {
        setName("Health Potion");
        setImage("/Health Potion.png");
    }

    public String toString() {
        return getName();
    }
}
