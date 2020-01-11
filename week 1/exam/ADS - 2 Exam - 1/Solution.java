import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.io.File; 
import java.util.Hashtable;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import javafx.print.Collation;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.In;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Digraph;


/**
 * Solution
 */
public class Solution {
    
    int count;
    int count1;
   Digraph obj; 
   Hashtable<Integer, String> h;

    private void emails(String filename) {
        h = new Hashtable<Integer, String>();
        String[] store1;
        //String[] store2;
        String[] store = readFile(filename);
        store1 = new String[store.length];
        for (int i = 0; i < store.length; i++) {
            store1 = store[i].split(";");
            //System.out.println(store1[0]);
            //System.out.println(store1[1]);
            h.put(Integer.parseInt(store1[0]),(store1[1]));
        }
   //System.out.println(h.size());
        count = h.size();
        obj = new Digraph(count);
    }

    private void emailLog(String filename) {
        count1 = 0;
        Hashtable<Integer, ArrayList<Integer>> h3 = new Hashtable<Integer, ArrayList<Integer>>();
        Hashtable<Integer, Integer> h1 = new Hashtable<Integer, Integer>();
        String[] store1;
        String[] store2;
        String[] store3;
        String[] store = readFile(filename);
        store1 = new String[store.length];
        for(int i = 0; i < store.length; i++) {
            store1 = store[i].split(",");
            store2 = store1[0].split(" ");
            store3 = store1[1].split(" ");
            h1.put(Integer.parseInt(store2[1]), Integer.parseInt(store3[2]));
            obj.addEdge(Integer.parseInt(store2[1]),Integer.parseInt(store3[2]));
        }

        Hashtable<Integer, Integer> h5 = new Hashtable<Integer, Integer>();
        ArrayList<Integer> asdasda = new ArrayList<>();
        for (int integer = 0;integer < obj.V(); integer++) {
            asdasda.add(obj.indegree(integer));
            h5.put(obj.indegree(integer), integer);
        }

        Collections.sort(asdasda,Collections.reverseOrder());
        // int i = 0;
        for (int i = 0; i < 10; i++) {
            //System.out.println(asdasda.get(i));
            System.out.println(asdasda.get(i) + " " +h.get(asdasda.get(i)));
        }
     }


    private static String[] readFile(final String filename) {
        /**
         * Taking input parameter as filename and performing
         * operations. It returns null when the file is cannot be read.
         */
            ArrayList<String> lines = new ArrayList<String>();
            Scanner scan = null;
            try {
                scan = new Scanner(new File(filename));
                while (scan.hasNext()) {
                    lines.add(scan.nextLine());
                }
                String[] linesArray = lines.toArray(new String[lines.size()]);
                return linesArray;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (scan != null) {
                    scan.close();
                }
            }
            return null;
        }
        
    public static void main(String[] args) {
        Solution ob = new Solution();
        ob.emails("emails.txt");
        ob.emailLog("email-logs.txt");



    }
}