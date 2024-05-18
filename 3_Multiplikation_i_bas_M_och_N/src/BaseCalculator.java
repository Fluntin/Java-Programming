import java.util.Scanner;

public class BaseCalculator {

    // Main method to read input and execute multiplication
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        // Prompt for base inputs
        int sourceBase = inputReader.nextInt();
        int targetBase = inputReader.nextInt();
        inputReader.nextLine();  // Clear the input buffer

        // Prompt for first number in source base
        String firstNumber = inputReader.nextLine();

        // Prompt for second number in source base
        String secondNumber = inputReader.nextLine();

        // Perform the multiplication and display the result
        String multiplicationResult = performMultiplication(sourceBase, targetBase, firstNumber, secondNumber);
        System.out.println(multiplicationResult);
    }

    // Multiplies two numbers in a given source base and converts the result to target base
    private static String performMultiplication(int sourceBase, int targetBase, String num1, String num2) {
        long num1Base10 = convertToDecimal(num1, sourceBase);
        long num2Base10 = convertToDecimal(num2, sourceBase);
        long resultBase10 = num1Base10 * num2Base10;
        return convertToBase(resultBase10, targetBase);
    }

    // Converts a number from any base to decimal (base 10)
    private static long convertToDecimal(String numberStr, int base) {
        long decimalValue = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            char currentChar = numberStr.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                decimalValue = decimalValue * base + (currentChar - '0');
            } else if (currentChar >= 'A' && currentChar <= 'Z') {
                decimalValue = decimalValue * base + (currentChar - 'A' + 10);
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                decimalValue = decimalValue * base + (currentChar - 'a' + 10);
            }
        }
        return decimalValue;
    }

    // Converts a decimal number to the specified target base
    private static String convertToBase(long number, int base) {
        if (number == 0) return "0";

        StringBuilder baseDigits = new StringBuilder();
        while (number > 0) {
            long remainder = number % base;
            if (remainder < 10) {
                baseDigits.append((char) ('0' + remainder));
            } else {
                baseDigits.append((char) ('A' + remainder - 10));
            }
            number /= base;
        }
        return baseDigits.reverse().toString();
    }
}