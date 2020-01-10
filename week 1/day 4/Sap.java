import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File; 
import java.util.Hashtable;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.In;

public class Sap {
    BreadthFirstDirectedPaths bfs;
    BreadthFirstDirectedPaths bfs1;
    Digraph Dg;
    int distance = Integer.MAX_VALUE;
    int pathlength;
    int ancestorValue;
    public Sap(Digraph G) {
        Dg = G;
        pathlength = -1;
        ancestorValue = -1;
    }

    public int length(int v, int w) {
        bfs = new BreadthFirstDirectedPaths(Dg, v);
        bfs1 = new BreadthFirstDirectedPaths(Dg, w);
        ancestor(v, w);
        return pathlength; 
    }

    public int ancestor(int v, int w) {
        if (Dg.V() < v) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v-1));
        }
        for (int i = 0; i < Dg.V(); i++) {
            System.out.println(i);
            if(bfs.hasPathTo(i) && bfs1.hasPathTo(i)){
                pathlength = bfs.distTo(i) + bfs1.distTo(i);
                    if (distance >= pathlength) {
                        distance = pathlength;
                        ancestorValue = i;
                    }
                }
            }

            // if (distance != pathlength) {
            //     pathlength = distance;
            // }
            return ancestorValue;
        }
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
            ancestor(v, w);
            return pathlength;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
        int dist = Integer.MAX_VALUE;
        int asec = -1;
        for (int k : v ) {
            for (int l : w) {
        // for (int i = 0; i < Dg.V(); i++) {
        //     System.out.println(i);
        //     if(bfs.hasPathTo(i) && bfs1.hasPathTo(i)){
        //         pathlength = bfs.distTo(i) + bfs1.distTo(i);
        //             if (distance >= pathlength) {
        //                 distance = pathlength;
        //                 ancestorValue = i;
        //             }
        //         }
                ancestor(k, l);
                if (dist > pathlength) {
                    dist = pathlength;
                    asec = ancestorValue;
                }
            }
        }
        return asec;
    }
    // }
public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph obj = new Digraph(in);
    Sap sp = new Sap(obj);
    while (!StdIn.isEmpty()) {
        int v = StdIn.readInt();
        int w = StdIn.readInt();
        int length   = sp.length(v, w);
        int ancestor = sp.ancestor(v, w);
        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}