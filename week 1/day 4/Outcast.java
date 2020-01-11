import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import java.io.IOException;

/**
 * OutCast
 */
public class Outcast {

    private WordNet wn;
    public Outcast(WordNet wordnet) {

        wn = wordnet;
        
       
    }
   public String outcast(String[] nouns) {
    int total_distance = 0; 
       String outcastedWord = "";
        for (String each : nouns) {
            int temp_distance = 0;
            for (String each1 : nouns) {
                temp_distance += wn.distance(each, each1);
            }
            if (temp_distance > total_distance) {
                total_distance = temp_distance;
                outcastedWord  = each;
            }
        }
        return outcastedWord;
   }

    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0],args[1]);
    Outcast outcast = new Outcast(wordnet);
    for (int t = 2; t < args.length; t++) {
        In in = new In(args[t]);
        String[] nouns = in.readAllStrings();
        StdOut.println(args[t] + ": " + outcast.outcast(nouns));
    }
    
}
}