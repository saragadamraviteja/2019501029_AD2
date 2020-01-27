import java.io.*;
import java.util.*;
/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {
        Hashtable<String, ArrayList<Integer>> hash = new Hashtable<String, ArrayList<Integer>>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //System.out.println(str);
        String[] arr = str.split(" ");
        System.out.println(arr[0]);
        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            String str1 = sc.nextLine();
            String[] arr1 = str1.split(" ",2);
            System.out.println(arr1[1]);

        }

        // for (int j = 0; j < store2.length; j++) {
        //     if(h.containsKey(store2[j])){
        //         h.get(store2[j]).add(Integer.parseInt(store1[0]));
        //     } else{
        //         ArrayList<Integer> temp = new ArrayList<Integer>();
        //         temp.add(Integer.parseInt(store1[0]));
        //         h.put(store2[j], temp);
        //     }        
        // }

    }
}