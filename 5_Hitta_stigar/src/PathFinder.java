import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main {
    static boolean[][] visitedCells;

    public static void main(String[] args) throws IOException {
        findPaths();
    }

    //-----------------------------------------------------------------------------------
    // Initializes the visitedCells array with the given dimensions
    // All cells are marked as unvisited
    //-----------------------------------------------------------------------------------
    public static void initializeVisitedCells(int numRows, int numCols) {
        visitedCells = new boolean[numRows][numCols];
    }

    //-----------------------------------------------------------------------------------
    // Marks a cell as visited
    // The cell is identified by its row and column
    //-----------------------------------------------------------------------------------
    public static void markCellVisited(int row, int col) {
        visitedCells[row][col] = true;
    }

    //-----------------------------------------------------------------------------------
    // Checks if a cell has been visited
    // Returns true if the cell has been visited, false otherwise
    //-----------------------------------------------------------------------------------
    public static boolean isCellVisited(int row, int col) {
        return visitedCells[row][col];
    }

    //-----------------------------------------------------------------------------------
    // Finds paths in a grid of characters
    // The grid is read from the standard input
    // The results are printed to the standard output
    //-----------------------------------------------------------------------------------
    public static void findPaths() throws IOException {
        // Reads input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split("\\s+");
        int numRows = Integer.parseInt(dimensions[0]);
        int numCols = Integer.parseInt(dimensions[1]);

        // Initializes data structures
        HashMap<Character, Boolean> pathExists = new HashMap<>(); // Stores the characters for which a path exists
        char[][] characterGrid = new char[numRows][numCols]; // Stores the characters in the grid
        Set<Character> lastRowCharacters = new HashSet<>(); // Stores the characters in the last row

        // Initializes the visitedCells array
        initializeVisitedCells(numRows, numCols);
        
        //-----------------------------------------------------------------------------------
        // Fills the characterGrid with input data
        //-----------------------------------------------------------------------------------
        for (int i = 0; i < numRows; i++) {
            char[] currentRow = reader.readLine().toCharArray();
            characterGrid[i] = currentRow;
        }

        //-----------------------------------------------------------------------------------
        // Closes the reader
        // Adds the characters from the last row to a set
        //-----------------------------------------------------------------------------------
        for (int i = 0; i < numCols; i++) {
            char character = characterGrid[characterGrid.length - 1][i];
            lastRowCharacters.add(character);
        }

        //-----------------------------------------------------------------------------------
        // Checks for valid paths from the first row
        // If a path exists, the character is added to the pathExists map
        //-----------------------------------------------------------------------------------
        for (int i = 0; i < numCols; i++) {
            char character = characterGrid[0][i];
            if (pathExists.containsKey(character) || !lastRowCharacters.contains(character)) continue;
            if (doesPathExist(character, characterGrid, 1, i)) pathExists.put(character, true);
        }

        //-----------------------------------------------------------------------------------
        // Output and sorting
        // If no paths exist, prints 0
        // Otherwise, prints the characters in sorted order
        //-----------------------------------------------------------------------------------
        if (pathExists.isEmpty()) {
            System.out.println("0");
        } else {
            Set<Character> foundPaths = pathExists.keySet();
            Character[] sortedCharacters = foundPaths.toArray(new Character[0]);
            Arrays.sort(sortedCharacters);
            StringBuilder result = new StringBuilder();
            for (Character character : sortedCharacters) {
                result.append(character);
            }
            System.out.println(result);
        }
    }

    //-----------------------------------------------------------------------------------
    // Recursive function to check if a path exists
    //-----------------------------------------------------------------------------------
    public static boolean doesPathExist(char targetChar, char[][] grid, int currentRow, int currentCol) {
        if (currentRow == grid.length) return true; // Reached the last row
        if (isCellVisited(currentRow, currentCol)) return false; // Cell already visited

        //-----------------------------------------------------------------------------------
        // Check if the current cell contains the target character
        // If it does, mark the cell as visited and check the surrounding cells
        //-----------------------------------------------------------------------------------
        char[] row = grid[currentRow];
        if (targetChar == row[currentCol]) {
            markCellVisited(currentRow, currentCol);
            int offset = 0;

            //-----------------------------------------------------------------------------------
            // Check right
            while (currentCol + offset < row.length && targetChar == row[currentCol + offset]) {
                if (doesPathExist(targetChar, grid, currentRow + 1, currentCol + offset)) return true;
                offset++;
            }

            //-----------------------------------------------------------------------------------
            // Reset offset and check left
            offset = 0;
            while (currentCol - offset >= 0 && targetChar == row[currentCol - offset]) {
                if (doesPathExist(targetChar, grid, currentRow + 1, currentCol - offset)) return true;
                offset++;
            }

            //-----------------------------------------------------------------------------------
            // Check directly below
            return doesPathExist(targetChar, grid, currentRow + 1, currentCol);
        }

        return false;
    }
}