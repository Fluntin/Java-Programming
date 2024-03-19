import java.util.Scanner;

public class BaseMultiplication {


    // Main method to read input and call the baseMultiplication method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the bases N and M
        System.out.print("Enter the bases N and M: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // Read the two numbers A and B in base N
        System.out.print("Enter the first number (A) in base N: ");
        String a = scanner.nextLine();

        // Read the two numbers A and B in base N
        System.out.print("Enter the second number (B) in base N: ");
        String b = scanner.nextLine();

        // Call the baseMultiplication method and print the result
        String result = baseMultiplication(n, m, a, b);
        System.out.println(result);
    }

    // This method multiplies two numbers in base N and returns the result in base M
    private static String baseMultiplication(int n, int m, String a, String b) {

        // Convert the numbers to base 10
        // Take number in base N and convert it to base 10
        long aValue = convertToBase10(a, n);
        long bValue = convertToBase10(b, n);

        // We multiply the numbers in base 10
        long product = aValue * bValue;

        // Convert the product to base M
        return convertFromBase10(product, m);
    }

    // This method converts a number in base N to base 10
    private static long convertToBase10(String numStr, int base) {
        long value = 0;
        for (int i = 0; i < numStr.length(); i++) {

            // Get the i-th character of the string
            char digit = numStr.charAt(i);

            // if we have a digit, we add it to the value
            // converts the character representing the digit into its integer value.
            // Since the ASCII code of '0' is 48, and the codes for '1' to '9' 
            // follow it sequentially (49 to 57), 
            // subtracting the code of '0' from any of these gives the actual 
            // numeric value of the character
            if (digit >= '0' && digit <= '9') {
                value = value * base + (digit - '0');


            // if we have a letter, we add it to the value
            // converts the character representing the digit into its integer value.
            // Since the ASCII code of 'A' is 65, and the codes for 'B' to 'Z'
            // follow it sequentially (66 to 90),
            // subtracting the code of 'A' from any of these gives the actual
            // numeric value of the character
            } else if (digit >= 'A' && digit <= 'Z') {
                value = value * base + (digit - 'A' + 10);

            // if we have a letter, we add it to the value
            // converts the character representing the digit into its integer value.
            // Since the ASCII code of 'a' is 97, and the codes for 'b' to 'z'
            // follow it sequentially (98 to 122),
            // subtracting the code of 'a' from any of these gives the actual
            // numeric value of the character
            } else if (digit >= 'a' && digit <= 'z') {
                value = value * base + (digit - 'a' + 10);
            }
        }
        return value;
    }

    // This method converts a number from base 10 to base M
    private static String convertFromBase10(long num, int base) {
        if (num == 0) return "0";

        StringBuilder digits = new StringBuilder();
        while (num > 0) {
            long digit = num % base;
            if (digit < 10) {
                digits.append((char) ('0' + digit));
            } else {
                digits.append((char) ('A' + digit - 10));
            }
            num /= base;
        }
        return digits.reverse().toString();
    }
}
