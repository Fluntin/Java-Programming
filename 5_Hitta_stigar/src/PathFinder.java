import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PathFinder {
    private static final int[] DX = { -1, 1, 0, 0 };
    private static final int[] DY = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the rest of the line

        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = scanner.nextLine().trim().toCharArray();
        }

        Set<Character> validPaths = new TreeSet<>();
        boolean[][] visited = new boolean[m][n];

        for (int j = 0; j < n; j++) {
            if (!visited[0][j]) {
                dfs(map, 0, j, map[0][j], visited, validPaths);
            }
        }

        if (validPaths.isEmpty()) {
            System.out.println("0");
        } else {
            validPaths.forEach(System.out::print);
            System.out.println();
        }
    }

    private static void dfs(char[][] map, int x, int y, char letter, boolean[][] visited, Set<Character> validPaths) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || map[x][y] != letter || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        if (x == map.length - 1) {
            validPaths.add(letter);
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + DX[i];
            int newY = y + DY[i];
            dfs(map, newX, newY, letter, visited, validPaths);
        }
    }
}

