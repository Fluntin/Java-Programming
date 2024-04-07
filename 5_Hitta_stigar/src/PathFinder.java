import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class PathFinder {

    // Change in row for up, down, left, right
    // Down, up, left, right
    private static final int[] MOVE_X = { -1, 1, 0, 0 }; // Final means that the value of the variable cannot be changed

    // Change in column for up, down, left, right
    // Down, up, left, right
    private static final int[] MOVE_Y = { 0, 0, -1, 1 }; // Final means that the value of the variable cannot be changed

    // Main method to read input and execute the path finding
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         // Read number of rows
        int rows = scanner.nextInt();

         // Read number of columns
        int columns = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        // Read the grid of characters ROW by ROW!
        // By writing char[][] grid = new char[rows][columns]; we create a 2D array of characters
        char[][] grid = new char[rows][columns]; // char[rows][columns] means a predefined size!
        for (int i = 0; i < rows; i++) {

            // nextLine() reads the next line of input from the scanner as a String
            // trim() removes leading and trailing whitespaces
            // toCharArray() converts the string to a character array
            grid[i] = scanner.nextLine().trim().toCharArray();
        }

        // Set to store valid path characters without duplicates, sorted
        // We can use a TreeSet because it automatically sorts the characters
        // and has O(log n) time complexity for add and contains operations
        Set<Character> validPathChars = new TreeSet<>();

        //Now we need to create a 2D array to keep track of visited cells
        //This can be done by creating a boolean array of the same size as the grid!
        boolean[][] visited = new boolean[rows][columns]; // Tracking visited cells

        // Starting Deep-First Search from the first row
        // This works because we know that the first row is always a valid starting point
        // For each column in the first row, we start a DFS to explore the grid
        // If we reach the last row, we add the character to the set of valid path characters
        // If there are no valid paths, we output 0
        for (int j = 0; j < columns; j++) {
            if (!visited[0][j]) {
                dfs(grid, 0, j, grid[0][j], visited, validPathChars);
            }
        }

        // Outputting the valid paths or 0 if there are none
        if (validPathChars.isEmpty()) {
            System.out.println("0");
        } else {
            validPathChars.forEach(System.out::print);
            System.out.println();
        }
    }

    // Depth-First Search (DFS) to explore the grid
    // Coped from stackoverflow.com/questions/15597512/find-all-paths-in-a-2d-array
    private static void dfs(char[][] grid, int startX, int startY, char pathChar, boolean[][] visited, Set<Character> validPathChars) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
    
        while (!stack.isEmpty()) {
            int[] pos = stack.pop();
            int row = pos[0];
            int column = pos[1];
    
            if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] != pathChar || visited[row][column]) {
                continue;
            }
    
            visited[row][column] = true;
    
            if (row == grid.length - 1) {
                validPathChars.add(pathChar);
            }
    
            for (int i = 0; i < 4; i++) {
                int newRow = row + MOVE_X[i];
                int newColumn = column + MOVE_Y[i];
                stack.push(new int[]{newRow, newColumn});
            }
        }
    }
    
}