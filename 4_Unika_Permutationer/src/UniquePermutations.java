import java.util.*;
public class UniquePermutations {

    // Main method - entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // We can use a Set to ensure all permutations are unique
        // HashSet is a good choice because it has O(1) lookup time
        Set <String> permutations = new HashSet<>(); 

        // We create a function to generate all permutations of the input string
        // Generating permutations and adding them to the Set of permutations 
        generatePermutations("", input, permutations); 

        // We must sort the permutations alphabetically before printing them!

        // First, we copy the permutations from the set back to a list.
        List<String> sortedPermutations = new ArrayList<>(permutations); 

        // Second, we can use the Collections.sort method to sort the list.
        Collections.sort(sortedPermutations);

        // Last, we loop through the sorted list of permutations and print them.
        for (String perm : sortedPermutations) {
            System.out.println(perm);
        }
    }

    // We can use recursion to generate all permutations of a string!

    // The prefix parameter is the current permutation being built
    // The remaining parameter is the characters left to be permuted
    // The permutations parameter is the set of unique permutations

    private static void generatePermutations(String prefix, String remaining, Set<String> permutations) {
        // Base case: if no characters are remaining to be permuted, add the prefix to permutations
        if (remaining.length() == 0) {
            permutations.add(prefix);
            return;
        }

        // Recursive case: for each character in the remaining string,
        // remove it, append it to the prefix, and recurse on the rest

        for (int i = 0; i < remaining.length(); i++) {

            // 1. Creating new prefix by adding the current character
            String newPrefix = prefix + remaining.charAt(i); 

            // 2. Creating new remaining string by removing the current character
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            // 3. Recurse with the new prefix and the new remaining string
            generatePermutations(newPrefix, newRemaining, permutations);
        }
    }
}
