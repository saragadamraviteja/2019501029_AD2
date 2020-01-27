import java.io.*;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        while (sc.hasNext()) {
            String str = "";
            String sent = sc.nextLine();
            for(int i = 0; i < sent.length(); i++) {
                if(sent.charAt(i)== '"' && flag == false) {
                    str += "`" + "`";
                    flag = true;
                } else if (sent.charAt(i)== '"' && flag == true){
                    str += "''";
                    flag = false;
                }
                else {
                    str += sent.charAt(i);
                }
            }
            System.out.println(str);
        }
    }
}