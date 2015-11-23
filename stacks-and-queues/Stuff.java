import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Stuff {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.next());
        int width = Integer.parseInt(scanner.next());
        int[][] a = new int[length][width];

        int start_row = Integer.parseInt(scanner.next());
        int start_column = Integer.parseInt(scanner.next());
        a[start_row][start_column] = 1;

        int goal_row = Integer.parseInt(scanner.next());
        int goal_column = Integer.parseInt(scanner.next());
        a[goal_row][goal_column] = 2;

        int numOfBlockers = Integer.parseInt(scanner.next());
        for (int i=0; i<numOfBlockers; i++) {
            int blockerRow = Integer.parseInt(scanner.next());
            int blockerColumn = Integer.parseInt(scanner.next());
            a[blockerRow][blockerColumn] = 9;
        }

        printMatrix(a);

        int answer = findSolution(start_row, start_column, a, 0,  new HashSet<String>());
        System.out.println("\n" + answer);

    }

    private static void printMatrix(int[][] a) {
        String s = "";
        for (int[] row : a) {
            s += Arrays.toString(row) + "\n";
        }
        System.out.println(s);
    }

    /* i and j are current row and column indices */
    private static int findSolution(int i, int j, int[][] a, int numOfSteps, HashSet<String> visited) {
        /* Move in all possible directions */
        int minimumSteps = Integer.MAX_VALUE;
        for (int q=-2; q <= 2; q++) {
            for (int w = -2; w <= 2; w++) {

                int row = i+q;
                int col = j+w;

                /* Should not have been visited already */
                if (visited.contains(row + " " + col)) {
                    continue;
                }
                visited.add(row + " " + col);

                if (!((Math.abs(q) == 2 && Math.abs(w) == 1) || (Math.abs(q) == 1 && Math.abs(w) == 2)))
                    continue;
                if ((row < 0 || col < 0 || row >= a.length || col >= a[i].length) || a[row][col] == 9) {
                    /* TODO: Base condition for FAIL */
                    continue;
                }

                if (i==0 && j==0)
                    System.out.print("");

                if (a[row][col] == 2) {
                    /* TODO: Base condition for SOLUTION */
                    return numOfSteps+1;
                }

                int currentSolution = findSolution(row, col, a, numOfSteps+1, new HashSet<>(visited));
                if (minimumSteps > currentSolution) {
                    minimumSteps = currentSolution;
                }
            }
        }

        /* Check for base condition */
        return minimumSteps;
    }
}
