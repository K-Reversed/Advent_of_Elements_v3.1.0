package Java.Objects;

public class Lock extends GameObjects {
    public Lock() {
        setName("Lock");
        setImage("/Lock.png");
        setCollision(true);
    }

    public String toString() {
        return getName();
    }
}
