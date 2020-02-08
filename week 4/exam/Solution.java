import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static String longestRepeatedDna(String input) {

    // set containing distinct possible candidates
    // when examine new candidate we check if it is already in the set
    // if it is -> we found our longest dna!
    // in not -> we add the candidate to set and continue
    Set<String> dnaSet = new HashSet<String>(); 

    for (int currentLen = input.length() - 1; currentLen > 0; --currentLen) {

        // empty before we start processing sub-strings of currentLen
        dnaSet.clear(); 

        // examine all substrings of length currentLen
        for (int i = 0; i + currentLen <= input.length(); ++i) {
            // take substring of length currentLen starting at index i
            String possibleDna = input.substring(i, i + currentLen);
            if (dnaSet.contains(possibleDna)) {
                // hooray! we found it!
                return possibleDna;
            } else {
                dnaSet.add(possibleDna);
            }
        }
    }
            return null; // or return "";
   }

    public static void main(String[] args) {
        String[] testCases = {"ababa", "mababa123", "mytest",};
        for (String test : testCases) {
        System.out.println("longest dna for input " + test + " = " + 
            longestRepeatedDna(test));
    }
    }
}