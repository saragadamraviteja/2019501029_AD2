import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
        String conct = " ";
        String result = " ";
        String ch = sc.nextLine();
        conct = Character.toString(ch.charAt(0));
        //System.out.println(conct);
        for(int i = 1; i < ch.length(); i++) {
            if (ch.charAt(i) == 'E' || ch.charAt(i) == 'A' || ch.charAt(i) == 'I' || ch.charAt(i) == 'O' || ch.charAt(i) == 'U' || ch.charAt(i) == 'Y' || ch.charAt(i) == 'W' || ch.charAt(i) == 'H' ) {
                continue;
            } else  if (ch.charAt(i) == 'B' || ch.charAt(i) == 'P'||ch.charAt(i) == 'F'||ch.charAt(i)=='V') {
                if(ch.charAt(i - 1) == 'B' || ch.charAt(i - 1) == 'P'||ch.charAt(i - 1) == 'F'||ch.charAt(i - 1)=='V') {
                    continue;
                } else {
                    //System.out.println("nsbcjd");
                    conct += "1";
                }
            } else if (ch.charAt(i) == 'C' || ch.charAt(i) == 'S'||ch.charAt(i) == 'K'||ch.charAt(i)=='G'||ch.charAt(i) =='J'||ch.charAt(i) =='Q'||ch.charAt(i) =='X'||ch.charAt(i) =='Z') {
                if(ch.charAt(i - 1) == 'C' || ch.charAt(i - 1) == 'S'||ch.charAt(i - 1) == 'K'||ch.charAt(i - 1)=='G'||ch.charAt(i - 1) =='J'||ch.charAt(i - 1) =='Q'||ch.charAt(i - 1) =='X'||ch.charAt(i - 1) =='Z') {
                    continue;
                } else {
                    conct += "2";
                    //System.out.println(conct);
                }
            } else if (ch.charAt(i) == 'D'||ch.charAt(i) =='T') {
                if (ch.charAt(i-1) == 'D'||ch.charAt(i -1) =='T') {
                    continue;
                } else{
                    conct += "3";
                }

            } else if (ch.charAt(i) == 'L') {
                if (ch.charAt(i - 1) == 'L') {
                    continue;
                } else {
                    //System.out.println("nsbcjd");
                    conct += "4";
                    //System.out.println(conct);
                }
            } else if (ch.charAt(i) == 'M'||ch.charAt(i) == 'N') {
                if (ch.charAt(i -1) == 'M'||ch.charAt(i-1) == 'N') {
                    continue;
                } else {
                    conct += "5";
                }
            } else if(ch.charAt(i) == 'R') {
                if (ch.charAt(i -1) == 'R') {
                    continue;
                } else {
                    conct += "6";
                }
            }
            if (conct.length() == 4) {
                break;
            }
            }
            while (conct.length() !=4) {
                conct += "0";
            }
            System.out.println(ch+";"+conct);

        }

    }
}