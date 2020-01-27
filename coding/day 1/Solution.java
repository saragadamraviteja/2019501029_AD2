import java.io.*;
import java.util.*;


public class Solution {

    // int cycles;
    public static int process(int n) {
        int cycles = 1;
        
        while (n > 1) {
            if (n%2 !=0) {
                n = 3*n + 1; 
                cycles++;
            } else {
                n = n/2;
                cycles++;
            }
        }
        System.out.println(cycles);
        return cycles;

    }


    public static void main(String[] args) {
        int totalcycles;
        int max;
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while(sc.hasNext()) {
            max = 0;
            totalcycles = 0;
            flag = false;
            String i = sc.nextLine();
            String[] arr = i.split(" ");
            String temp = arr[0];

            if (Integer.parseInt(arr[1]) < Integer.parseInt(arr[0])){

                    arr[0] = arr[1];
                    arr[1] = temp;
                    flag = true;
            }
            for (int j = Integer.parseInt(arr[0]); j <= Integer.parseInt(arr[1]); j++ ) {
                totalcycles = process(j);
                if (max < totalcycles) {
                    max = totalcycles;
                }
            }
            if (flag) {
            
                System.out.println(arr[1] + " " + arr[0] + " " +max);
                } else {
                    System.out.println(arr[0] + " " + arr[1] + " " +max);
                }
        }
    }
}