import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int temp = 0;
        String str = "";
        while (sc.hasNext()) {
            int value = sc.nextInt();

            if (value == 0) {
                continue;
            }
            temp = temp + 1;
            EdgeWeightedDigraph edgeweight = new EdgeWeightedDigraph(value);
            System.out.println(edgeweight.V());
            System.out.println(edgeweight.E());
            for (int k = 0; k < value; k++) {
                Integer edges = sc.nextInt();
                    for (int l = 0; l < edges; l++) {
                        edgeweight.addEdge(new DirectedEdge(k, sc.nextInt() - 1, sc.nextInt()));
                }
            }
            Integer ts = sc.nextInt();
            Integer td = sc.nextInt();
            DijkstraSP obj = new DijkstraSP(edgeweight, ts - 1);
            // System.out.println(obj.pathTo(td - 1));
            str = " ";
            for(DirectedEdge j : obj.pathTo(td - 1)) {
                str +=  " " + Integer.toString(j.from() + 1);
            }
            str +=" "+ (td);
            //System.out.println(str.trim());
            System.out.println("Case " + temp + ": Path = "+ "" +str.trim() + "; " + (int) obj.distTo(td - 1)+ " second delay");
        }
    }
}