import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubstringFinder {

    // Main method to read input and call the findCommonSub method
    public static void main(String[] args) {

        // Initialize scanner to read from standard input
        Scanner scanner = new Scanner(System.in);

        // Read the first line as an integer
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read the next line as the string S
        String S = scanner.nextLine();

        // Find the most common substring of length n in S
        System.out.println(findCommonSub(n, S));
    }

    // This method finds the most common substring of length n in a given string S
    public static String findCommonSub(int n, String S) {

        // Maps substrings of length n to their frequencies within the string S
        Map<String, Integer> freqMap = new HashMap<>();

        //A string variable that will hold the most common substring found so far.
        String commonSub = "";

        //An integer to track the highest frequency of any substring encountered.
        int maxFreq = 0;

        // Loops through every possible substring of length n in S.
        for (int i = 0; i <= S.length() - n; i++) {

            //Extract each substring, starting from index i and ending just before i + n
            String currSub = S.substring(i, i + n);

            //Increment the frequency of the current substring in the map
            freqMap.put(currSub, freqMap.getOrDefault(currSub, 0) + 1);

            //Update the most common substring and its frequency if the current substring has a higher frequency
            if (freqMap.get(currSub) > maxFreq) {
                maxFreq = freqMap.get(currSub);
                commonSub = currSub;
                
            } else if (freqMap.get(currSub) == maxFreq) {
                commonSub = lexSmaller(commonSub, currSub);
            }
        }

        return commonSub;
    }

    public static String lexSmaller(String s1, String s2) {
        String order = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s1.length(); i++) {
            if (order.indexOf(s1.charAt(i)) < order.indexOf(s2.charAt(i))) {
                return s1;
            } else if (order.indexOf(s1.charAt(i)) > order.indexOf(s2.charAt(i))) {
                return s2;
            }
        }
        return s1;  // both strings are equal
    }
}
