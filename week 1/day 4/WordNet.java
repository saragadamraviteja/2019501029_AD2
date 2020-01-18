import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File; 
import java.util.Hashtable;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.In;
import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;


/**
 * Main
 */

public class WordNet {
   private int count;
   private Digraph obj;
    private SAP sp;
//    Digraph obj1;
//    Digraph obj2;
   
   private Hashtable<String, ArrayList<Integer>> h = new Hashtable<String, ArrayList<Integer>>();
  private ArrayList<String> str = new ArrayList<String>();
   private void parseSynsets(String filename) {

         String[] store =  readFile(filename);
         String[] store1;
         String[] store2;
        // Hashtable<String, ArrayList<Integer>> h = new Hashtable<String, ArrayList<Integer>>();
        store1 = new String[store.length];
        for (int i = 0; i < store.length; i++) {
            store1 = store[i].split(","); 
            // System.out.println(store1[0]);
            // System.out.println(store1[1]);
            str.add(Integer.parseInt(store1[0]),store1[1]);
            // System.out.println(str.toString());
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
        // System.out.println(h.get("bioscope"));
    }

    public WordNet(String synsets, String hypernyms) {
        parseSynsets(synsets);
        // graph("hypernyms.txt"); 
        //parseHypernyms(hypernyms);
        obj = new Digraph(h.size());
        parseHypernyms(hypernyms);
        sp = new SAP(obj);

    }

     // distance between nounA and nounB (defined below)
   public int distance(String nounA, String nounB){
    if (nounA == null || nounB == null) { 
        throw new IllegalArgumentException();
    } 
       if (isNoun(nounA) && isNoun(nounB)) {
           if (nounA == nounB) {
               return 0;
           }
       int ds = sp.length(h.get(nounA), h.get(nounB));
       return ds;
   } else {
       return -1;
   }
}

   public Iterable<String> nouns() {
        ArrayList<String> temp = new ArrayList<>();
        for (String s : h.keySet()) {
         temp.add(s);
        }
        return temp;
   }


// public void graph(String filename) {
    
//     // obj = new Digraph(h.size());
//     // System.out.println(h.size());
//     parseHypernyms(filename);
//     sp = new Sap(obj);


//     // for (int v = 0; v < obj.V(); v++){
//     //     for (int w : obj.adj(v)){
//     //         // StdOut.println(v + "->" + w
//     //     }

//     // }
// }

// a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
   // in a shortest ancestral path (defined below)
   public String sap(String nounA, String nounB) {
    //sp = new Sap(obj);
    if (nounA == null || nounB == null) { 
        throw new IllegalArgumentException();
    } 
        if (isNoun(nounA) && isNoun(nounB)) {
            //  sp = new Sap(obj);
           // System.out.println(h.get(nounA).toString());
           // System.out.println(h.get(nounB).toString());
            int ans = sp.ancestor(h.get(nounA), h.get(nounB));
            if (ans != -1) {
                return str.get(ans);
            }
            else {
                return "there is no common ancestor";
            }
        }
        else {
            return "not a noun";
        }
   }

private void parseHypernyms(String filename) {
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
}

public boolean isNoun(String word) {
    if (word == null) {
        throw new IllegalArgumentException();
    } else {
        return h.containsKey(word);
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
        // In xx = new In(args[0]);
       WordNet ref = new WordNet(args[0], args[1]);
    //    System.out.println(args[1]);
        //ref.parseSynsets("synsets.txt");
        //parseHypernymsDup("hypernyms.txt");
        //ref.graph("hypernyms.txt");  
        //System.out.println(ref.distance("calcium_ion", "casein"));  
    }
}

