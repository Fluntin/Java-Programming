import java.util.Scanner;

public class Kvadranter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //-----------------------------------------------------------------------------------
        // Read the Input:
        // Read the initial quadrant position and steps to move
        //-----------------------------------------------------------------------------------
        String initialPosition = sc.nextLine();
        String steps = sc.nextLine();
        sc.close();

        //-----------------------------------------------------------------------------------
        // Split the input strings into parts
        // The initial position is split by the '.' character
        // The steps are split by the ' ' character
        //-----------------------------------------------------------------------------------
        String[] positionParts = initialPosition.split("\\."); // Exemple: ["1", "3", "2"]
        String[] stepsParts = steps.split(" "); // stepsParts contains the steps to move

        //-----------------------------------------------------------------------------------
        // Convert the position and steps parts to integer arrays
        //-----------------------------------------------------------------------------------
        int[] position = new int[positionParts.length]; // Array to store the initial position of size equal to the number of parts
        
        //-----------------------------------------------------------------------------------
        // Convert the string parts to integers 
        // Exemple: ["1", "3", "2"] -> [1, 3, 2]
        for (int i = 0; i < positionParts.length; i++) { 
            position[i] = Integer.parseInt(positionParts[i]); 
        }

        //-----------------------------------------------------------------------------------
        int horizontalSteps = Integer.parseInt(stepsParts[0]); // Number of steps to move horizontally
        int verticalSteps = Integer.parseInt(stepsParts[1]); // Number of steps to move vertically


        //-----------------------------------------------------------------------------------
        // Depth represents the number of times the paper has been subdivided inot quadrants
        // It determines tge size of the grid
        int depth = position.length - 1;

        //-----------------------------------------------------------------------------------
        // Check if the steps are beyond the grid boundaries
        // If the steps are outside the boundaries, print "outside" and return
        //-----------------------------------------------------------------------------------
        if (Math.abs(horizontalSteps) >= Math.pow(2, depth + 1) || Math.abs(verticalSteps) >= Math.pow(2, depth + 1)) {
            System.out.println("outside");
            return;
        }

        // Process horizontal movement (right/left)
        position = moveHorizontally(depth, position, horizontalSteps);

        // Process vertical movement (up/down)
        position = moveVertically(depth, position, verticalSteps);

        // Check if we moved outside the boundaries after processing both movements
        if (position == null) {
            System.out.println("outside");
        } else {
            // Construct the final position string
            StringBuilder finalPosition = new StringBuilder();
            for (int i = 0; i <= depth; i++) {
                finalPosition.append(position[i]);
                if (i < depth) {
                    finalPosition.append(".");
                }
            }
            System.out.println(finalPosition.toString());
        }
    }

    //-----------------------------------------------------------------------------------
    // Move the position horizontally
    // The method returns the new position after moving horizontally
    // If the movement is outside the boundaries, the method returns null
    //-----------------------------------------------------------------------------------
    private static int[] moveHorizontally(int depth, int[] position, int horizontalSteps) {
        boolean movingRight = horizontalSteps > 0;
        horizontalSteps = Math.abs(horizontalSteps);

        for (int i = 0; i < horizontalSteps; i++) {
            int initialQuadrant = position[0];
            position = adjustHorizontal(depth, position, movingRight);
            if ((movingRight && initialQuadrant > position[0]) || (!movingRight && initialQuadrant < position[0])) {
                return null;  // Moved outside
            }
        }
        return position;
    }

    //-----------------------------------------------------------------------------------
    // Move the position vertically
    // The method returns the new position after moving vertically
    // If the movement is outside the boundaries, the method returns null
    //-----------------------------------------------------------------------------------
    private static int[] moveVertically(int depth, int[] position, int verticalSteps) {
        boolean movingUp = verticalSteps > 0;
        verticalSteps = Math.abs(verticalSteps);

        for (int i = 0; i < verticalSteps; i++) {
            int initialQuadrant = position[0];
            position = adjustVertical(depth, position, movingUp);
            if ((movingUp && initialQuadrant > position[0]) || (!movingUp && initialQuadrant < position[0])) {
                return null;  // Moved outside
            }
        }
        return position;
    }

    //-----------------------------------------------------------------------------------
    // Horizontal adjustments
    // If I'm moving right from quadrant 1 I can end up in quadrant 2 or 4 depending on the depth
    // If the movement goes beyond the boundaries of the current level, it needs to wrap around or adjust the higher-level quadrants appropriately.
    //-----------------------------------------------------------------------------------
    private static int[] adjustHorizontal(int depth, int[] position, boolean right) {
        int limit;
        int limitLower;
        int limitUpper;
        int step;

        //-----------------------------------------------------------------------------------
        // If moving right, the limits are 2 and 4
        if (right) {
            limitLower = 2;
            limitUpper = 4;
            step = 1;
        
        //-----------------------------------------------------------------------------------
        // If moving left, the limits are 1 and 3
        } else {
            limitLower = 1;
            limitUpper = 3;
            step = -1;
        }

        //-----------------------------------------------------------------------------------
        // As long as the depth is greater than -1
        // Check if the position is in the lower or upper limit
        while (depth > -1) {
            
            //-----------------------------------------------------------------------------------
            // If the position is in quadrant 1 or 2, the limit is the lower limit
            if (position[depth] == 1 || position[depth] == 2) {
                limit = limitLower;
            } else {
                limit = limitUpper;
            }

            //-----------------------------------------------------------------------------------
            // Adjust the position
            position[depth] += step;

            //-----------------------------------------------------------------------------------
            // If the position is greater than the limit, wrap around by subtracting 2
            if (position[depth] > limit) {
                position[depth] -= 2;
            
            //-----------------------------------------------------------------------------------
            // If the position is less than the limit, wrap around by adding 2
            } else if (position[depth] < limit) {
                position[depth] += 2;

            //-----------------------------------------------------------------------------------
            // If the position is equal to the limit, we are done because we are within the boundaries
            } else {
                break;
            }

            //-----------------------------------------------------------------------------------
            // Move to the next depth
            depth -= 1;
        }
        return position;
    }

    //-----------------------------------------------------------------------------------
    // Vertical adjustments
    // If I'm moving up from quadrant 1 I can end up in quadrant 3 or 4 depending on the depth
    // If the movement goes beyond the boundaries of the current level, it needs to wrap around or adjust the higher-level quadrants appropriately.
    //-----------------------------------------------------------------------------------
    private static int[] adjustVertical(int depth, int[] position, boolean up) {
        int limit;
        int limitLower;
        int limitUpper;
        int step;

        //-----------------------------------------------------------------------------------
        // If moving up, the limits are 3 and 4
        if (up) {
            limitLower = 3;
            limitUpper = 4;
            step = 2;

        //-----------------------------------------------------------------------------------
        // If moving down, the limits are 1 and 2
        } else {
            limitLower = 1;
            limitUpper = 2;
            step = -2;
        }

        //-----------------------------------------------------------------------------------
        // As long as the depth is greater than -1
        // Check if the position is in the lower or upper limit
        while (depth > -1) {
            if (position[depth] == 1 || position[depth] == 3) {
                limit = limitLower;
            } else {
                limit = limitUpper;
            }

            position[depth] += step;

            if (position[depth] > limit) {
                position[depth] -= 4;
            } else if (position[depth] < limit) {
                position[depth] += 4;
            } else {
                break;
            }

            depth -= 1;
        }
        return position;
    }
}