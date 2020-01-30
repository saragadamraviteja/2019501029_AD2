import java.io.*;
import java.util.*;
/**
 * Solution
 */
public class Solution {


    public static void main(String[] args) {
        int total;
        int count = 0;
        Integer c;
        int max;
        Scanner sc = new Scanner(System.in);
        while (true) { 
            total = 0;
            count ++;
        Integer n = sc.nextInt();

        //System.out.println(n + " "+ "n");
        if (n == 0) {
            break;
        } else {
            boolean[] flag = new boolean[n];
            Integer m = sc.nextInt();
            c = sc.nextInt();
            int[] arr = new int[n];
            int[] temp = new int[m];
            max = 0;
            for (int k = 0; k < n; k++) {
                arr[k] = sc.nextInt();
            } 
            for (int l = 0; l < m; l++) {
                Integer operator = sc.nextInt();
                temp[l] = operator;
            }
            int j = 0;
             for (j = 0; j < temp.length; j++)  { 
                    flag[temp[j] - 1] = !(flag[temp[j] - 1]);
                    if (flag[temp[j] - 1]) {
                        total = arr[temp[j] - 1] + total;
                    }
                 else {
                        total = total - arr[temp[j] - 1];
                    } 
                 if (max < total){
                    max = total;
                }
                if (total > c) {
                    System.out.println("Sequence" + " " + count);
                    System.out.println("Fuse was blown.");
                    break;
                }
                }
                //System.out.println(total+" "+ "nbjsd" + " "+c);
                if (j == temp.length){
                    System.out.println("Sequence" + " " + count);
                    System.out.println("Fuse was not blown.");
                    System.out.println("Maximal power consumption was" +" "+ max + " "+ "amperes.");
            }
            }
            System.out.println();
        }
    }
}