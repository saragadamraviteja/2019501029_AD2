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

public class SAP {
    private BreadthFirstDirectedPaths bfs;
    private BreadthFirstDirectedPaths bfs1;
    private Digraph Dg;
    private int distance;
    private int pathlength;
    private int ancestorValue;
    public SAP(Digraph G) {
        Dg = G;
        pathlength = -1;
        ancestorValue = -1;
    }

    public int length(int v, int w) {
        // bfs = new BreadthFirstDirectedPaths(Dg, v);
        // bfs1 = new BreadthFirstDirectedPaths(Dg, w);
        ancestor(v, w);
        return pathlength; 
    }

    public int ancestor(int v, int w) {
        if(v == w){
            pathlength = 0;
            return v;
        }
        distance = Integer.MAX_VALUE;
        if ((v < 0 && v > Dg.V())||(w < 0 && w > Dg.V())) {
            return -1;
        }
        try {
        bfs = new BreadthFirstDirectedPaths(Dg, v);
        bfs1 = new BreadthFirstDirectedPaths(Dg, w);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return -1;
        }
        // if (Dg.V() < v || v < 0) {
         //   throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (v-1));
        // }
        for (int i = 0; i < Dg.V(); i++) {
            if(bfs.hasPathTo(i) && bfs1.hasPathTo(i)){
                pathlength = bfs.distTo(i) + bfs1.distTo(i);    
                // System.out.println(pathlength);
                if (distance >= pathlength) {
                    distance = pathlength;
                    ancestorValue = i;
                }
            }
        }

        if (distance != Integer.MAX_VALUE) {
            pathlength = distance;
        }
            return ancestorValue;
        }
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
            ancestor(v, w);
           
            return pathlength;
    }

    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
        distance = Integer.MAX_VALUE;
        try {
            if(v == null || w == null) throw new IllegalArgumentException(); 
        } catch (IllegalArgumentException e){
        }
 //int asec = -1;
 bfs = new BreadthFirstDirectedPaths(Dg, v);
 bfs1 = new BreadthFirstDirectedPaths(Dg, w);
        for (int k : v ) {
            for (int l : w) {
                if (((k < 0 && k < Dg.V()) || k > 0 && k > Dg.V() )){
                    return -1;
                }
        for (int i = 0; i < Dg.V(); i++) {
            //System.out.println(i);
            if(bfs.hasPathTo(i) && bfs1.hasPathTo(i)){
                pathlength = bfs.distTo(i) + bfs1.distTo(i);
                    if (distance >= pathlength) {
                        distance = pathlength;
                        ancestorValue = i;
                    }
                }
                if (distance != Integer.MAX_VALUE) {
                    pathlength = distance;
                }
            }
        }
        // return ancestorValue;
    }
    return ancestorValue;
}
    // }
public static void main(String[] args) {
    In in = new In(args[0]);
    Digraph obj = new Digraph(in);
    SAP sp = new SAP(obj);
    while (!StdIn.isEmpty()) {
        int v = StdIn.readInt();
        int w = StdIn.readInt();
        int length   = sp.length(v, w);
        int ancestor = sp.ancestor(v, w);
        // StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
        }
    }
}