package Others;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @since 1.3
 */
public class Inventory {
    private ArrayList<String[]> arrayListStrings;
    public Inventory(){
        arrayListStrings = new ArrayList<>();
    }

    public ArrayList<String[]> alphabetSort (ArrayList<String[]> arr) {
        if (arr.size() < 2){
            return (arr);
        }
        int swaps = 0;
        for (int i = 0; i < arr.size() - 1; i ++) {
            int mem = i;
            for (int i1 = i + 1; i1 < arr.size(); i1++){
                if (arr.get(i1)[0].toLowerCase(Locale.ROOT).compareTo(arr.get(mem)[0].toLowerCase(Locale.ROOT)) < 0){
                    mem = i1;
                }
            }
            String temp = arr.get(i)[0];
            arr.get(i)[0] = arr.get(mem)[0];
            arr.get(mem)[0] = temp;
            swaps++;
        }
        System.out.println("It has done " + swaps + " swaps.");
        return (arr);
    }
    public ArrayList<String[]> reverseAlphabetSort (ArrayList<String[]> arr) {
        if (arr.size() < 2){
            return (arr);
        }
        int swaps = 0;
        for (int i = 0; i < arr.size() - 1; i ++) {
            for (int i1 = i + 1; i1 < arr.size(); i1++){
                if (arr.get(i1)[0].toLowerCase(Locale.ROOT).compareTo(arr.get(i)[0].toLowerCase(Locale.ROOT)) > 0){
                    String temp = arr.get(i)[0];
                    arr.get(i)[0] = temp;
                    swaps++;
                }
            }

        }
        System.out.println("It has done " + swaps + " swaps.");
        return (arr);
    }

}
