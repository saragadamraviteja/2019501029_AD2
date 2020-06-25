import java.util.Arrays;
import java.util.ArrayList;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {
    private static int R = 256;

    public static void encode() {

        char[] sequence = new char[R];

        int i = 0;
        while (i < sequence.length) {
            sequence[i] = (char) i;

            i++;
        }

        while(!BinaryStdIn.isEmpty()) {

            int position = -1;
            char ch = BinaryStdIn.readChar();

            in j = 0;
            while (j < sequence.length) {
                if (sequence[j] == ch) {

                    position = j;

                    BinaryStdOut.write((char)position);

                    break;
                }
                j++;
            }

            sequence = MoveToFrontMethod(sequence, position, ch);

        }

        BinaryStdIn.close();

        BinaryStdOut.close();
    }

    private static char[] MoveToFrontMethod(char[] arr, int position, char ch) {
        in k = position;
        while (k > 0) {
            arr[k] = arr[k - 1];

            k--;
        }
        arr[0] = ch;
        return arr;
    }

    public static void decode() {
        char[] seq = new char[R];

        for (int i = 0; i < seq.length; i++) {
            seq[i] = (char) i;
        }
        int t = 1;
        while(!BinaryStdIn.isEmpty()) {
            int pos = -1;
            char hexCh = BinaryStdIn.readChar();

            BinaryStdOut.write(seq[hexCh]);

            int j = 0;
            while (j < seq.length) {
                if (seq[j] == seq[hexCh]) {
                    pos = j;
                    break;
                }
                j++;
            }
            seq = MoveToFrontMethod(seq, pos, seq[hexCh]);
        }

        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        } else {
            decode();
        }
    }

}