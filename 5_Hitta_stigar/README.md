# Path Finder in a Grid

This Java program reads a grid of characters from the user and determines which characters have valid paths from the first row to the last row of the grid. A valid path for a character is defined as a sequence of contiguous cells containing that character, moving only to the right, left, or directly below to the next row.

## How It Works

1. **Reading Input:**
   - The program uses `BufferedReader` to read the dimensions of the grid and the grid itself from the standard input (typically the console).

2. **Path Finding:**
   - The `findPaths` method reads the grid and initializes data structures.
   - It then checks each character in the first row to see if a valid path exists to the last row using the `doesPathExist` method.

3. **Marking Cells:**
   - The program uses a 2D boolean array `visitedCells` to keep track of visited cells to avoid revisiting them during the path search.

4. **Sorting and Output:**
   - The characters with valid paths are sorted alphabetically and printed. If no paths are found, the program prints `0`.

## Methods

### `initializeVisitedCells(int numRows, int numCols)`

Initializes the `visitedCells` array with the given dimensions, marking all cells as unvisited.

- **Parameters:**
  - `numRows`: Number of rows in the grid.
  - `numCols`: Number of columns in the grid.

### `markCellVisited(int row, int col)`

Marks a cell as visited.

- **Parameters:**
  - `row`: Row index of the cell.
  - `col`: Column index of the cell.

### `isCellVisited(int row, int col)`

Checks if a cell has been visited.

- **Parameters:**
  - `row`: Row index of the cell.
  - `col`: Column index of the cell.
- **Returns:**
  - `true` if the cell has been visited, `false` otherwise.

### `findPaths()`

Reads the grid from the input, initializes data structures, finds valid paths, and prints the results.

### `doesPathExist(char targetChar, char[][] grid, int currentRow, int currentCol)`

Recursively checks if a path exists for the target character from the current cell to the last row.

- **Parameters:**
  - `targetChar`: The character to find the path for.
  - `grid`: The character grid.
  - `currentRow`: The current row index.
  - `currentCol`: The current column index.
- **Returns:**
  - `true` if a path exists, `false` otherwise.

## Example

If the user inputs the following grid:
```
3 4
ABCA
BCDB
CACA
```

The program will output:
```
A
C
```
indicating that valid paths exist for characters `A` and `C`.