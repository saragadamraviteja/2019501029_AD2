import java.lang.IllegalArgumentException;
import edu.princeton.cs.algs4.LSD;
import java.util.Arrays;



public class CircularSuffixArray {
    private int[] index;

    public CircularSuffixArray(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }

        int l = text.length();

        Suffix[] allSuffixes = new Suffix[l];
        int i = 0;
        while (i < l) {
            allSuffixes[i] = new Suffix(text.substring(i) + text.substring(0, i), i);

            i++;
        }

        Arrays.sort(allSuffixes);
        
        index = new int[l];
        
        int j = 0;
        while (j < l) {
            index[j] = allSuffixes[j].index;
            j++;
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
            if (this == that) return 0;  // optimization
            
            int n = Math.min(this.length(), that.length());
            int i = 0;
            while (i < n) {
                if (this.charAt(i) < that.charAt(i)){
                    return -1;
                } 
                
                if (this.charAt(i) > that.charAt(i)) {
                    return +1;
                }

                i++;
            }

            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }
    }

    public int length() {
        return index.length;
    }


    public int index(int i) {
        if (i < 0 || i >= index.length) throw new IllegalArgumentException();
        return index[i];
    }
}


