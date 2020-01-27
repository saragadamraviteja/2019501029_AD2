import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        //Scanner sc = new Scanner(new File("sample.txt"));
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNext()) {
            Integer inter = sc.nextInt();
            if (inter == 0)
                continue;
            count++;
            EdgeWeightedDigraph ew = new EdgeWeightedDigraph(inter);
            for (int i = 0; i < inter; i++) {
                Integer x = sc.nextInt();
                for (int j = 0; j < x; j++) {
                    ew.addEdge(new DirectedEdge(i, sc.nextInt() - 1, sc.nextInt()));
                    // System.out.println(ew.toString());
                }
            }
            Integer s = sc.nextInt(), d = sc.nextInt();
            // System.out.println(ew.toString());
            DijkstraSP dsp = new DijkstraSP(ew, s - 1);
            System.out.print("Case " + count + ": Path = ");
            DirectedEdge dam = new DirectedEdge(0, 0, 0);
            for (DirectedEdge sam : dsp.pathTo(d - 1)) {
                System.out.print(sam.from() + 1 + " ");
                dam = sam;
            }
            System.out.println(dam.to() + 1 + "; " + (int) dsp.distTo(d - 1) + " second delay");
            ;
            // System.out.println(dsp.pathTo(d - 1) + " " + dsp.distTo(d - 1));
        }
    }
}