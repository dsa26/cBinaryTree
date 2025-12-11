//efficiency test

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int sizes[] = {10,100,1000,5000,10000};
        System.out.println("n,insert,search,delete,avgInsert,avgSearch,avgDelete");
        Random rand = new Random();
        for(int n:sizes){
            ArrayList<Integer> vals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vals.add(i);
            }
            Collections.shuffle(vals, rand);

            BST tree = new BST();
            long startInsert = System.nanoTime();
            for (int val:vals){
                tree.insert(val);
            }
            long endInsert = System.nanoTime();
            long totalInsert = endInsert - startInsert;
            double avgInsert = totalInsert / (double) n;

            long startSearch = System.nanoTime();
            for (int val : vals) {
                tree.contains(val);
            }
            long endSearch = System.nanoTime();
            long totalSearch = endSearch - startSearch;
            double avgSearch = totalSearch / (double) n;

            long startDelete = System.nanoTime();
            for (int val : vals) {
                tree.delete(val);
            }
            long endDelete = System.nanoTime();
            long totalDelete = endDelete - startDelete;
            double avgDelete = totalDelete / (double) n;
        }


    }


}
