import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
        Integer testcases = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testcases; i++) {
            String temp = "";
            String text = sc.nextLine();
            // long nPermutant = Long.parseLong(sc.nextLine());
            int nPermutant = sc.nextInt();
            sc.nextLine();
            ArrayList<String> arr = new ArrayList<String>(); 
            for (int j = 0; j < text.length(); j++) {
                arr.add(String.valueOf(text.charAt(j)));
            }
            // System.out.println(arr);
            int[] remainder = new int[text.length()];
            for (int k = 1; k <= text.length(); k++) {
                remainder[k - 1] = nPermutant % k;
                nPermutant = nPermutant/k;
            }
            int[] tempo =  new int[remainder.length];
            for (int h = 1; h <= tempo.length; h++) {
                tempo[tempo.length - h] = remainder[h -1];
            }
            //System.out.println(Arrays.toString(remainder));
            for (int l = 0; l < remainder.length; l++ ) {
                temp = arr.remove(tempo[l]);
                //System.out.println("hi");
                System.out.println(arr.remove(tempo[l]));
            }
            //System.out.println(arr);
            
            System.out.println(temp);
        }
    }
    }
    
}