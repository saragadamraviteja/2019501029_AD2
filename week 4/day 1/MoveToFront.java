import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
/**
 * MoveToFront
 */
public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {

        char[] characters = new char[256];

        for (int k = 0; k < characters.length; k++)  {
            characters[k] = (char)k;
        }

        while(!BinaryStdIn.isEmpty()) {

            char ch = BinaryStdIn.readChar();

            int position = -2;

            for (int i = 0; i < characters.length; i++ ) {

                if (characters[i] == ch) {
                    BinaryStdOut.write((char)i);
                    position = i;
                    break;
                }
            }
            characters = MoveToFront(characters, position, ch);
        }

        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    private static char[] MoveToFront(char[] array, int pos, char ch) {

        for (int h = pos; h > 0; h--) {

            array[h] = array[h - 1];
        }
        array[0] = ch;
        
        return array;
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] characters = new char[256];
        
        for (int k = 0; k < characters.length; k++) {
            characters[k] = (char) k;
        }
            while (!BinaryStdIn.isEmpty()) {
                char ch = BinaryStdIn.readChar();

                int position = -1;

                BinaryStdOut.write(characters[ch]);
                for (int i = 0; i < characters.length; i++){
                    if (characters[i] == characters[ch]) {
                        position = i;
                        break;
                    }
                }
                characters = MoveToFront(characters, position, characters[ch]);
            }
        BinaryStdIn.close();
        BinaryStdOut.close();
    }
   

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if(args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        }
    }
}