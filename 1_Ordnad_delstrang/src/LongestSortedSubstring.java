import java.util.Scanner;

public class LongestSortedSubstring {
    public static void main(String[] args) {
        // Initialize scanner to read from standard input
        Scanner scanner = new Scanner(System.in);
        // Read a line of input from the user
        String input = scanner.nextLine();
        
        // Find the length of the longest sorted substring
        int maxLengthString = findMaxSortedSubstring(input);

        // Print the length of the longest sorted substring
        System.out.println(maxLengthString);
    }

    // Finds the length of the longest sorted substring in a given string
    public static int findMaxSortedSubstring(String str) {
        // Initialize maxLength to keep track of the longest substring found
        int maxLength = 1;
        // Initialize currentLength to keep track of the current substring length
        int currentLength = 1;
        
        // Iterate through the string starting from the second character
        for (int i = 1; i < str.length(); i++) {

            // Check if the current character is in order with the previous character
            // `str.charAt(index)` returns the character at the specified index in a string. Indexes start at 0.
            // Checks if the current character (`str.charAt(i)`) is in order with the previous character (`str.charAt(i - 1)`).
            if (isCharInOrder(str.charAt(i - 1), str.charAt(i))) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        
        return maxLength;
    }

    // Checks if the current character (`str.charAt(i)`) is in order with the previous character (`str.charAt(i - 1)`).
    public static boolean isCharInOrder(char prev, char current) {
        String alphabet = "0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz";
        int prevIndex = alphabet.indexOf(prev);
        int currentIndex = alphabet.indexOf(current);
        
        // Return true if prev is before or at the same position as current in the alphabet
        boolean isBeforeOrSame = prevIndex <= currentIndex;
        return isBeforeOrSame;
    }
}

