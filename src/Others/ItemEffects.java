package Others;

/**
 * @since 1.3
 */
public class ItemEffects extends Items{
    private Stats stats;
    private ItemList itemList;
    private boolean hasEffect;
    private boolean canEquip;

    public ItemEffects(String itemName, String itemDescription, int stackLimit, int amount, ItemList itemList) {
        super(itemName, itemDescription, stackLimit, amount, itemList);
    }

    public void effects (ItemList itemList){
        if (itemList == ItemList.healthPotion){
            stats.setHealth(stats.getHealth() + 250);
            if (stats.getHealth() > stats.getMaxHealth()){
                stats.setHealth(10000);
            }
        }
        if (itemList == ItemList.manaPotion){
            stats.setMana(stats.getMana() + 250);
            if (stats.getMana() > stats.getMaxMana()){
                stats.setMana(500);
            }
        }

    }
}
