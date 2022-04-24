package Others;

import java.util.ArrayList;

/**
 * @since 1.3
 */
public class Items {
    protected String itemName;
    protected String itemDescription;
    protected int stackLimit;
    protected int amount;
    protected ItemList itemList;

    public Items (String itemName, String itemDescription, int stackLimit, int amount, ItemList itemList){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.stackLimit = stackLimit;
        this.amount = amount;
        this.itemList = itemList;
    }

    public ArrayList<String[]> addItem (ArrayList<String[]> arr, String itemName, int amount){
        arr.add(new String[]{itemName, String.valueOf(amount)});
        return (arr);
    }
}