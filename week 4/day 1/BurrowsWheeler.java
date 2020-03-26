import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Hashtable;
import edu.princeton.cs.algs4.StdIn;

public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output 
    public static void transform() {

        String strng = BinaryStdIn.readString();

        CircularSuffixArray obj = new CircularSuffixArray(strng);

        for (int j = 0; j < strng.length(); j++){

            if (obj.index(j) == 0){
                BinaryStdOut.write(j);

                break;
            }
        }

        for(int i = 0; i < strng.length(); i++) {
            if (obj.index(i) == 0) {
                BinaryStdOut.write(strng.charAt(strng.length() - 1));
            } else {
                BinaryStdOut.write(strng.charAt(obj.index(i) - 1));
            }
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {

    }

}

