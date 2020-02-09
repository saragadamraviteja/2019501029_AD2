import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.LSD;
import java.util.Arrays;
/**
 * CircularSuffixArray
 */
public class CircularSuffixArray {

    private int[] index;
    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        
        int len = s.length();

        Suffix[] suffixes = new Suffix[n];

        for (int j = 0; j < len; j++) {
            suffixes[j] = new Suffix(s.substring(j) + s.substring(0, j), j);
        }

        Arrays.sort(suffixes);

        index = new int[len];
        for (int i = 0; i < len; i++) {
            index[i] = suffixes[i].index;
        }
    }

    private static class Suffix implements Comparable<Suffix> {

        private final String text;

        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }

        private int length() {
            return text.length();
        }

        private char charAt(int i) {
            return text.charAt(i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;
            int n = Math.min(this.length(), that.length());
            for (int i = 0; i < n; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }
        public String toString() {
            return text.substring(index);
        }
    }

    // length of s
    public int length() {
        return index.length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= index.length) throw new IllegalArgumentException();
        return index[i];
    }

    
    // unit testing (required)
    public static void main(String[] args) {
        
    }
}