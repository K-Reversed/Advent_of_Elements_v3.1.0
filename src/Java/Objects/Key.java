package Java.Objects;

public class Key extends GameObjects{
    public Key () {
        setName("Key");
        setImage("/Key.png");
    }

    public String toString() {
        return getName();
    }
}
