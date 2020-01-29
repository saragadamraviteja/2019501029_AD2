import edu.princeton.cs.algs4.*;
/**
 * BoggleSolver
 */
public class BoggleSolver {

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    TrieST tt;

    public BoggleSolver(String[] dictionary) {
        tt = new TrieST<Integer>();
        for (int i = 0; i < dictionary.length; i++) {
                tt.put(dictionary[i], scoreOf(dictionary[i]));
        }
     }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board) {
            
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    //int score;
    public int scoreOf(String word) {
        if (word.length() >2 && word.length() < 5) {
            return 1;
        } else if (word.length() == 5) {
            return 2;
        } else if (word.length() == 6) {
            return 3;
        } else if (word.length() == 7) {
            return 5;
        } else if (word.length() > 8) {
            return 11;
        } else {
            return 0;
        }
    } 

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
    }
}