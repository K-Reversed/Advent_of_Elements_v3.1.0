package Others;

/**
 * @since 1.3
 */
public class Stats {
    private final int maxHealth;
    private int health;
    private final int maxMana;
    private int mana;
    private int attack;
    private int defense;
    private double maxEvasion;
    private double evasion;
    public Stats (int health, int mana, int attack, int defense, double evasion){
        maxHealth = 1000;
        maxMana = 500;
        maxEvasion = 100;
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.evasion = evasion;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxMana() {
        return mana;
    }

    public int getMana() {
        return mana;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public double getMaxEvasion() {
        return maxEvasion;
    }

    public double getEvasion() {
        return evasion;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}