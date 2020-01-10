import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;
import java.io.File; 
import java.util.Hashtable;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
// import edu.princeton.cs.algs4.BreadthFirstPaths;

/**
 * Main
 */

public class WordNet {
   int count;
   Digraph obj;
   
   Hashtable<String, ArrayList<Integer>> h = new Hashtable<String, ArrayList<Integer>>();
    public void parseSynsets(String filename) {

        String[] store =  readFile(filename);
        String[] store1;
        String[] store2;
        // Hashtable<String, ArrayList<Integer>> h = new Hashtable<String, ArrayList<Integer>>();
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

public void graph(String filename) {
    obj = new Digraph(h.size());
    //System.out.println(h.size());
    parseHypernymsDup(filename);
    for (int v = 0; v < obj.V(); v++){
        for (int w : obj.adj(v)){
             StdOut.println(v + "->" + w);
        }

    }
}

public void parseHypernymsDup(String filename) {
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
                    obj.addEdge(Integer.parseInt(store1[0]),Integer.parseInt(store2[j]));
                } else{
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(Integer.parseInt(store2[j]));
                    h1.put(Integer.parseInt(store1[0]), temp);
                    obj.addEdge(Integer.parseInt(store1[0]),Integer.parseInt(store2[j]));
                }
                    
            }
    }
    
System.out.println(h1.get(34));
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
        WordNet ref = new WordNet();
        ref.parseSynsets("synsets.txt");
        //parseHypernymsDup("hypernyms.txt");
        ref.graph("hypernyms.txt");
    }
}

