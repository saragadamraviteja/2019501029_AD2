import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer cases = sc.nextInt();
        int count = 0;
        // int temp = 0;
        ArrayList<Double> xValues = new ArrayList<Double>();
        ArrayList<Double> yValues = new ArrayList<Double>();
        ArrayList<Double> rValues = new ArrayList<Double>();
        while (cases > count) {
            Integer lines = sc.nextInt();
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < 5; j++) {
                    Double point = sc.nextDouble();
                    if ( j == 0 & j == 2) {
                        xValues.add(point);
                    } else if (j == 1 & j == 3) {
                        yValues.add(point);
                    } else {
                        rValues.add(point);
                    }    
                }
            }
        System.out.println(xValues);
        
        
        }
    }
}