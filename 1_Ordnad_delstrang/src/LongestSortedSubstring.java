import java.util.Scanner;

public class LongestSortedSubstring {
    public static void main(String[] args) {

        // Initialize scanner to read from standard input
        Scanner inputScanner = new Scanner(System.in);

        // Read a line of input from the user
        String userInput = inputScanner.nextLine();
        
        // Find the length of the longest sorted substring
        int longestSortedLength = findMaxSortedSubstring(userInput);

        // Print the length of the longest sorted substring
        System.out.println(longestSortedLength);
    }

    // Finds the length of the longest sorted substring in a given string
    public static int findMaxSortedSubstring(String text) {

        // Initialize variables to keep track of the longest and current sorted substring lengths
        int maxSortedLength = 1;
        int currentSortedLength = 1;
        
        // Iterate through the text starting from the second character
        // Start at 1 since we are comparing with the previous character
        for (int i = 1; i < text.length(); i++) {

            // Check if the current character is in order with the previous character
            if (isCharsInOrder(text.charAt(i - 1), text.charAt(i))) {

                // If in order, increment currentSortedLength
                currentSortedLength++;

                // Update maxSortedLength if currentSortedLength is greater
                maxSortedLength = Math.max(maxSortedLength, currentSortedLength);
            } else {
                // If not in order, reset currentSortedLength to 1
                currentSortedLength = 1;
            }
        }
        // Return the length of the longest sorted substring found
        return maxSortedLength;
    }

    // Determines if the current character is in order with the previous character
    public static boolean isCharsInOrder(char previousChar, char currentChar) {
        // Define a custom order for characters
        String orderedAlphabet = "0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz";
        // Find indexes of previous and current characters in the ordered alphabet
        int prevCharIndex = orderedAlphabet.indexOf(previousChar);
        int currCharIndex = orderedAlphabet.indexOf(currentChar);
        
        // Return true if previousChar is before or at the same position as currentChar in the alphabet
        boolean isInOrder = prevCharIndex <= currCharIndex;
        return isInOrder;
    }
}