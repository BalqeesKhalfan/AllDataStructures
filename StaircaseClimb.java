import java.util.Scanner;

public class StaircaseClimb {

    // Function to calculate the number of distinct ways to climb the staircase
    public static int calculateDistinctWaysToClimb(int totalSteps) {
        // Base cases for 0, 1, and 2 steps
        if (totalSteps <= 0) {
            return 0;
        } else if (totalSteps == 1) {
            return 1;
        } else if (totalSteps == 2) {
            return 2;
        }

        // Create an array to store the number of ways to reach each step
        int[] dp = new int[totalSteps + 1];
        dp[1] = 1;
        dp[2] = 2;

        // Calculate the number of ways for each step using dynamic programming
        for (int i = 3; i <= totalSteps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Print the number of ways to climb each step
        printWaysToClimbEachStep(totalSteps, dp);

        // Return the result for the top step
        return dp[totalSteps];
    }

    // Function to print the number of ways to climb each step
    private static void printWaysToClimbEachStep(int totalSteps, int[] dp) {
        System.out.println("Ways to climb each step:");

        for (int i = 1; i <= totalSteps; i++) {
            System.out.println("Step " + i + ": " + dp[i]);
        }

        System.out.println("Total ways to climb " + totalSteps + " steps: " + dp[totalSteps]);
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of steps
        System.out.print("Enter the number of steps in the staircase: ");

        // Read the user input
        int totalSteps = scanner.nextInt();

        // Call the calculateDistinctWaysToClimb function to calculate the result
        int waysToClimb = calculateDistinctWaysToClimb(totalSteps);

        // Display the final result
        System.out.println("Final result: Ways to climb " + totalSteps + " steps: " + waysToClimb);

        // Close the Scanner to avoid resource leaks
        scanner.close();
    }
}
