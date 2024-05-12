import java.util.*;

public class PathFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                
        //--------------------------------------------------------------------------------
        // First I get the dimensions of the matrix
        //--------------------------------------------------------------------------------
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        //--------------------------------------------------------------------------------
        // This part is necessary to consume the newline character after reading the integers
        //--------------------------------------------------------------------------------
        scanner.nextLine(); // Consume the newline character

        //--------------------------------------------------------------------------------
        // Now I read the matrix from the input
        //--------------------------------------------------------------------------------
        char[][] grid = new char[M][];

        // I read each row of the matrix and store it in the grid array
        // I use the toCharArray() method to convert the string to a char array
        // I use the trim() method to remove leading and trailing whitespaces
        // I use the nextLine() method to read the entire line
        for (int i = 0; i < M; i++) {
            grid[i] = scanner.nextLine().trim().toCharArray();
        }
        
        //--------------------------------------------------------------------------------
        // Set to hold the characters that can reach from top to bottom
        // I use a set to avoid duplicates and to keep the characters sorted
        // This way I can print the characters in alphabetical order
        //--------------------------------------------------------------------------------
        Set<Character> connectingChars = new HashSet<>();

        //--------------------------------------------------------------------------------
        // This time I also need a visited matrix to keep track of visited cells
        // I use a single visited matrix for all characters
        //--------------------------------------------------------------------------------
        boolean[][] visited = new boolean[M][N];
        
        //--------------------------------------------------------------------------------
        // HashSet to track which characters have already been initiated for BFS
        // This is to ensure that each character starts BFS only once tp save on time
        //--------------------------------------------------------------------------------
        Set<Character> initiated = new HashSet<>();

        //--------------------------------------------------------------------------------
        // Start BFS from each cell in the top row for each unique character
        // If a character can reach the bottom row, add it to the connectingChars set
        //--------------------------------------------------------------------------------
        for (int col = 0; col < N; col++) {
            char startChar = grid[0][col];
            if (!initiated.contains(startChar)) {  // Ensure each character starts BFS once
                initiated.add(startChar);
                if (bfs(0, col, startChar, grid, visited, M, N)) {
                    connectingChars.add(startChar);
                }
                // Clear visited information for this character
                for (boolean[] row : visited) {
                    Arrays.fill(row, false);
                }
            }
        }
        
        //--------------------------------------------------------------------------------
        // Print the characters that can reach from top to bottom
        // If no characters can reach, print 0
        // Otherwise, print the characters in alphabetical order
        //--------------------------------------------------------------------------------
        if (connectingChars.isEmpty()) {
            System.out.println("0");
        } else {
            List<Character> result = new ArrayList<>(connectingChars);
            Collections.sort(result);
            result.forEach(System.out::print);
        }
    }

    //--------------------------------------------------------------------------------
    // BFS function to check if a character can reach the bottom row
    //--------------------------------------------------------------------------------
    private static boolean bfs(int startRow, int startCol, char charToCheck, char[][] grid, boolean[][] visited, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            if (row == M - 1) {  // Check if the bottom row is reached
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int newRow = row + dr[d], newCol = col + dc[d];
                if (newRow >= 0 && newRow < M && newCol >= 0 && newCol < N && !visited[newRow][newCol] && grid[newRow][newCol] == charToCheck) {
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return false;
    }
}