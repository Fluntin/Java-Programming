import java.util.Scanner;

public class BaseMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the bases N and M: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        System.out.print("Enter the first number (A) in base N: ");
        String a = scanner.nextLine();

        System.out.print("Enter the second number (B) in base N: ");
        String b = scanner.nextLine();

        String result = baseMultiplication(n, m, a, b);
        System.out.println("The result is: " + result);
    }

    private static String baseMultiplication(int n, int m, String a, String b) {
        long aValue = convertToBase10(a, n);
        long bValue = convertToBase10(b, n);
        long product = aValue * bValue;
        return convertFromBase10(product, m);
    }

    private static long convertToBase10(String numStr, int base) {
        long value = 0;
        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            if (digit >= '0' && digit <= '9') {
                value = value * base + (digit - '0');
            } else if (digit >= 'A' && digit <= 'Z') {
                value = value * base + (digit - 'A' + 10);
            } else if (digit >= 'a' && digit <= 'z') {
                value = value * base + (digit - 'a' + 10);
            }
        }
        return value;
    }

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
