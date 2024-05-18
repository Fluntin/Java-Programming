import java.util.Scanner;

public class Kvadranter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the initial quadrant position and steps to move
        String initialPosition = sc.nextLine();
        String steps = sc.nextLine();
        sc.close();

        String[] positionParts = initialPosition.split("\\.");
        String[] stepsParts = steps.split(" ");

        int[] position = new int[positionParts.length];
        for (int i = 0; i < positionParts.length; i++) {
            position[i] = Integer.parseInt(positionParts[i]);
        }

        int horizontalSteps = Integer.parseInt(stepsParts[0]);
        int verticalSteps = Integer.parseInt(stepsParts[1]);

        int depth = position.length - 1;

        // Check if the steps are beyond the grid boundaries
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

    private static int[] adjustHorizontal(int depth, int[] position, boolean right) {
        int limit;
        int limitLower;
        int limitUpper;
        int step;

        if (right) {
            limitLower = 2;
            limitUpper = 4;
            step = 1;
        } else {
            limitLower = 1;
            limitUpper = 3;
            step = -1;
        }

        while (depth > -1) {
            if (position[depth] == 1 || position[depth] == 2) {
                limit = limitLower;
            } else {
                limit = limitUpper;
            }

            position[depth] += step;

            if (position[depth] > limit) {
                position[depth] -= 2;
            } else if (position[depth] < limit) {
                position[depth] += 2;
            } else {
                break;
            }

            depth -= 1;
        }
        return position;
    }

    private static int[] adjustVertical(int depth, int[] position, boolean up) {
        int limit;
        int limitLower;
        int limitUpper;
        int step;

        if (up) {
            limitLower = 3;
            limitUpper = 4;
            step = 2;
        } else {
            limitLower = 1;
            limitUpper = 2;
            step = -2;
        }

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