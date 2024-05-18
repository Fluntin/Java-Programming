# Kvadranter - Quadrant Navigator

This Java program reads an initial quadrant position and steps to move, then calculates the final position within a grid of quadrants. If the movement goes beyond the grid boundaries, it prints "outside".

## How It Works

1. **Reading Input:**
   - The program uses `Scanner` to read the initial position and steps from the standard input (typically the console).
   - The initial position is given in the format `x.y.z` and the steps are given as two integers representing horizontal and vertical movements.

2. **Processing Movement:**
   - The program processes horizontal and vertical movements separately using helper methods `moveHorizontally` and `moveVertically`.
   - The `adjustHorizontal` and `adjustVertical` methods handle the actual adjustments to the position array based on the movement direction.
   - If the movement goes outside the grid boundaries at any point, the program prints "outside" and terminates.

3. **Output:**
   - If the final position is valid, the program constructs and prints the final position string.
   - If the movement results in going outside the grid boundaries, it prints "outside".

## Methods

### `main(String[] args)`

- Reads the initial position and steps from input.
- Converts the position and steps to integer arrays.
- Checks if the steps are beyond the grid boundaries.
- Processes the horizontal and vertical movements.
- Prints the final position or "outside" if the movement is beyond the boundaries.

### `moveHorizontally(int depth, int[] position, int horizontalSteps)`

- Processes horizontal movement by calling `adjustHorizontal`.
- **Parameters:**
  - `depth`: The depth of the position array.
  - `position`: The current position array.
  - `horizontalSteps`: The number of horizontal steps to move.
- **Returns:**
  - The updated position array or `null` if the movement is beyond the boundaries.

### `moveVertically(int depth, int[] position, int verticalSteps)`

- Processes vertical movement by calling `adjustVertical`.
- **Parameters:**
  - `depth`: The depth of the position array.
  - `position`: The current position array.
  - `verticalSteps`: The number of vertical steps to move.
- **Returns:**
  - The updated position array or `null` if the movement is beyond the boundaries.

### `adjustHorizontal(int depth, int[] position, boolean right)`

- Adjusts the position array for horizontal movement.
- **Parameters:**
  - `depth`: The depth of the position array.
  - `position`: The current position array.
  - `right`: A boolean indicating if the movement is to the right.
- **Returns:**
  - The updated position array.

### `adjustVertical(int depth, int[] position, boolean up)`

- Adjusts the position array for vertical movement.
- **Parameters:**
  - `depth`: The depth of the position array.
  - `position`: The current position array.
  - `up`: A boolean indicating if the movement is up.
- **Returns:**
  - The updated position array.

## Example

### Input
```
1.2.3
2 3
```

### Output
```
outside
```

## Note
- The program assumes that the input is well-formed and that the initial position and steps are valid integers.
