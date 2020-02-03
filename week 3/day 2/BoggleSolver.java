import java.util.HashSet;

// import edu.princeton.cs.algs4.*;
import java.util.Set;
/**
 * BoggleSolver
 */
public class BoggleSolver {

    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    private TrieSET tt;

    public BoggleSolver(String[] dictionary) {
        if (dictionary == null) {
            throw new IllegalArgumentException();
        }

        tt = new TrieSET();

        for (int i = 0; i < dictionary.length; i++) {
                tt.add(dictionary[i]);
        }
     }

    //  String[] validWords;
    private int count = 0;
     private void testing(int k, int l, BoggleBoard board) {
        count ++;
        if (k < 0 || l < 0|| k >= board.rows()|| l >= board.cols()) {
            return;
        }

        if (bool[k][l] == false) {

            bool[k][l] = true;

            if (board.getLetter(k , l) == 'Q') {
                str.append(Character.toString(board.getLetter(k, l)));

                str.append(Character.toString('U'));
            } else {
                str.append(Character.toString(board.getLetter(k, l)));
            }

        if (str.length() >= 3) {

            if (tt.contains(str.toString())) {
                valid.add(str.toString());
            }

            if (tt.hasPrefix(str.toString())== false) {

                if (board.getLetter(k, l) == 'Q') {
                    
                    str.delete(str.length()-2, str.length());
                } else {

                    str.delete(str.length()-1, str.length());
                }

                bool[k][l] = false;
                return;
            }
        }

        for(int i =-1; i <2; i++ )  {
            for(int j = -1; j< 2; j++) {
                    testing(k + i, l+j,board);
            }
        }
        if (board.getLetter(k, l) == 'Q') {
                    
            str.delete(str.length()-2, str.length());
        } else {

            str.delete(str.length()-1, str.length());
        }
        bool[k][l] = false;
        }
        return;
     }

    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    private Set<String> valid;
    private StringBuffer str;
    private boolean[][] bool;
    public Iterable<String> getAllValidWords(BoggleBoard board) {
            valid = new HashSet<String>();
            // Set<String> valid = new HashSet<String>();
            bool = new boolean[board.rows()][board.cols()];
            str = new StringBuffer();
            for (int k = 0; k < board.rows(); k++) {
                for(int l = 0; l < board.cols(); l++) {
                    testing(k,l,board);
                }
            }
        return valid;
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
        // In in = new In(args[0]);
        // String[] dictionary = in.readAllStrings();
        // BoggleSolver solver = new BoggleSolver(dictionary);
    }
}