import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;
import java.io.File; 
import java.util.Hashtable;
// import edu.princeton.cs.algs4.Digraph;
// import edu.princeton.cs.algs4.StdOut;

/**
 * Main
 */

public class WordNet {
   static int count;
   //static Digraph obj;
    public static void parseSynsets(String filename) {

        String[] store = readFile(filename);
        String[] store1;
        String[] store2;
        Hashtable<String, ArrayList<Integer>> h = new Hashtable<String, ArrayList<Integer>>();
        store1 = new String[store.length];
        for (int i = 0; i < store.length; i++) {
            store1 = store[i].split(","); 
            store2 = store1[1].split(" ");
                for (int j = 0; j < store2.length; j++) {
                    if(h.containsKey(store2[j])){
                        h.get(store2[j]).add(Integer.parseInt(store1[0]));
                    } else{
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(Integer.parseInt(store1[0]));
                        h.put(store2[j], temp);
                    }        
                }
        }
        System.out.println(h.get("bioscope"));
    }

    public static void parseHypernyms(String filename) {
        String[] store = readFile(filename);
        String[] store1;
        String[] store2;
        Hashtable<Integer, ArrayList<Integer>> h1 = new Hashtable<Integer, ArrayList<Integer>>(); 
        store1 = new String[store.length];
        for (int i = 0; i < store.length; i++) {
            if (!(store[i].contains(","))){
                continue;
            }
            store1 = store[i].split(",",2); 
            store2 = store1[1].split(",");
                for (int j = 0; j < store2.length; j++) {
                    if(h1.containsKey(Integer.parseInt(store1[0]))){
                        h1.get(Integer.parseInt(store1[0])).add(Integer.parseInt(store2[j]));
                        count++;
                    } else{
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(Integer.parseInt(store2[j]));
                        h1.put(Integer.parseInt(store1[0]), temp);
                        count++;
                    }
                        
                }
        }
        System.out.println(count);
    System.out.println(h1.get(53));
    // obj = new Digraph(count);
    // parseHypernymsDup(filename);
    // for (int v = 0; v < obj.V(); v++){
    //     for (int w : obj.adj(v)){
    //         StdOut.println(v + "->" + w);
    //     }

    // }


}

    public static String[] readFile(final String filename) {
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
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (scan != null) {
                    scan.close();
                }
            }
            return null;
        }

    public static void main(String[] args) {
        parseSynsets("synset.txt");
        parseHypernyms("hypernyms.txt");
        
    }
}
