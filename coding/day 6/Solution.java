import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int count;
        Scanner sc = new Scanner(System.in);
        while (true){       
            Double H = sc.nextDouble();
            //System.out.println(H);
             if (H == 0) {
                 break;
             } else{
                 Double U = sc.nextDouble();
                 //System.out.println(U);
                 Double D = sc.nextDouble();
                 //System.out.println(D);
                 Double F = sc.nextDouble();
                 F = (F*U)/100;
                 //System.out.println(F);
                 double total = 0.0;
                count = 0;
                 while (H >= total && total >= 0.0) {
                    count += 1;
                    total = (total + U); 
                    if (H < total) {
                        break;
                    }
                    total = total - D;
                    U = U - F;
                 }
                 if (total > H) {
                 System.out.println("success on day" +" "+ (count));
                 } else {
                    System.out.println("failure on day" +" "+ (count));  
                 }

             }
        }
    }
}