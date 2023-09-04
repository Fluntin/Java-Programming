import java.util.Scanner;

public class LongestSortedSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        int maxLength = findLongestSortedSubstring(input);
        System.out.println(maxLength);
    }
    
    public static int findLongestSortedSubstring(String str) {
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (isCharInOrder(str.charAt(i - 1), str.charAt(i))) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        
        return maxLength;
    }
    
    public static boolean isCharInOrder(char prev, char current) {
        String alphabet = "0123456789ABCDEGHIJKLMNOPQRSTUVWXYZabcdefhijklmnopqrstuvwxyz";
        int prevIndex = alphabet.indexOf(prev);
        int currentIndex = alphabet.indexOf(current);
        
        return prevIndex <= currentIndex;
    }
}

#1233212 

