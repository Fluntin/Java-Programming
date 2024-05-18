import java.util.Scanner;

public class Kommentar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //-----------------------------------------------------------------------------------
        // Read all input lines into a StringBuilder
        //-----------------------------------------------------------------------------------
        StringBuilder inputTextBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            inputTextBuilder.append(scanner.nextLine());
            inputTextBuilder.append("\n");
        }
        scanner.close();

        //-----------------------------------------------------------------------------------
        // Convert the StringBuilder to a single string
        //-----------------------------------------------------------------------------------
        String inputText = inputTextBuilder.toString();

        try {
            for (int currentIndex = 0; currentIndex < inputText.length(); currentIndex++) {
                if (inputText.charAt(currentIndex) == '%') {

                    //-----------------------------------------------------------------------------------
                    // Skip characters until the closing '%'
                    currentIndex++;
                    while (inputText.charAt(currentIndex) != '%') {
                        currentIndex++;
                    }
                } else if (inputText.charAt(currentIndex) == '/' && inputText.charAt(currentIndex + 1) == '*') {
                    //-----------------------------------------------------------------------------------
                    // Skip characters until the closing '*/'
                    currentIndex += 2;
                    while (true) {
                        if (inputText.charAt(currentIndex) == '*' && inputText.charAt(currentIndex + 1) == '/') {
                            currentIndex++;
                            break;
                        }
                        currentIndex++;
                    }
                } else {
                    //-----------------------------------------------------------------------------------
                    // Print the non-comment character
                    System.out.print(inputText.charAt(currentIndex));
                }
            }
        } catch (Exception ignored) {
            //-----------------------------------------------------------------------------------
            // Catch any exceptions that occur due to index out of bounds or other issues
        }
    }
}