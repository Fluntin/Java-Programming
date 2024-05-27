import java.util.Scanner;

public class Kommentar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //-----------------------------------------------------------------------------------
        // Read all input lines into a StringBuilder
        //-----------------------------------------------------------------------------------
        StringBuilder inputTextBuilder = new StringBuilder(); // Initialize a StringBuilder
        
        //-----------------------------------------------------------------------------------
        // While there are more lines to read from the input stream 
        // Input:
        //  This is the first line.
        //  This is the second line.
        //  This is the third line.
        //
        // inputedTextBuilder:
        //  This is the first line. \n This is the second line. \n This is the third line. \n
        //-----------------------------------------------------------------------------------
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

            //-----------------------------------------------------------------------------------
            // Iterate over all characters in the input text
            for (int currentIndex = 0; currentIndex < inputText.length(); currentIndex++) {

                //-----------------------------------------------------------------------------------
                // If a % is encountered, the loop skips characters until the next % is found
                if (inputText.charAt(currentIndex) == '%') {

                    //-----------------------------------------------------------------------------------
                    // Skip characters until the closing '%'
                    currentIndex++;
                    while (inputText.charAt(currentIndex) != '%') {
                        currentIndex++;
                    }

                //-----------------------------------------------------------------------------------
                // if /* is encountered, the loop skips characters until the next */ is found
                } else if (inputText.charAt(currentIndex) == '/' && inputText.charAt(currentIndex + 1) == '*') {
                    //-----------------------------------------------------------------------------------
                    // Skip characters until the closing '*/'
                    // Note that the currentIndex is incremented by 2 to skip the '/*' characters
                    currentIndex += 2;
                    while (true) {
                        if (inputText.charAt(currentIndex) == '*' && inputText.charAt(currentIndex + 1) == '/') {
                            currentIndex++;
                            break;
                        }
                        currentIndex++;
                    }
                
                //-----------------------------------------------------------------------------------
                // Else we can just print the character
                } else {

                    //-----------------------------------------------------------------------------------
                    // Print the non-comment character
                    System.out.print(inputText.charAt(currentIndex));
                }
            }
        } catch (Exception ignored) {
            //-----------------------------------------------------------------------------------
            // Catch any exceptions that occur due to index out of bounds or other issues
            // Started a comment but did not finish it
            //-----------------------------------------------------------------------------------
        }
    }
}