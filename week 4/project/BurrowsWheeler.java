
import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Hashtable;

public class BurrowsWheeler {

    
    public static void transform(){
        String myStr= BinaryStdIn.readString();

        CircularSuffixArray circularArray = new CircularSuffixArray(myStr);

        int i = 0;
        while (i < myStr.length()) {

            if (circularArray.index(i) == 0) {

                BinaryStdOut.write(i);

                break;
            }            
            i++;
        }

        int j = 0;
        while (j < myStr.length()) {
            
            if (circularArray.index(j) == 0) {

                BinaryStdOut.write(myStr.charAt(myStr.length() - 1));

            } else {

                BinaryStdOut.write(myStr.charAt(circularArray.index(j) - 1));
            }
            j++;
        }
        BinaryStdIn.close();

        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int firstInput = BinaryStdIn.readInt();

        String transformedString = BinaryStdIn.readString();

        char[] transformedArray = transformedString.toCharArray();
        char[] transformedArrayOne = transformedArray.clone();

        Arrays.sort(transformedArrayOne);

        int[] next = new int[transformedArray.length];

        Hashtable<Character, ArrayList<Integer>> hT = new Hashtable<Character, ArrayList<Integer>>();

        int i = 0;
        while (i < transformedArray.length) {
            if (hT.get(transformedArray[i]) != null) {

                hT.get(transformedArray[i]).add(i);
            } else {
                ArrayList<Integer> arrList = new ArrayList<Integer>();

                arrList.add(i);

                hT.put(transformedArray[i], arrList);
            }
            i++;
        }

        int j = 0;
        while (j < next.length) {
            next[i] = hT.get(transformedArrayOne[i]).get(0);
        

            hT.get(transformedArrayOne[i]).remove(0);
        
            j++;
        }

        int[] result = new int[transformedArray.length];

        int temp = firstInput;

        int k = 0;
        while (k < result.length) {
            result[i] = transformedArrayOne[temp];
            temp = next[temp];
            BinaryStdOut.write((char) result[i]);
            k++;
        }
        BinaryStdIn.close();
        BinaryStdOut.close();
        
        return;
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            transform();
        } else {
            inverseTransform();
        }
    }

}