package ds.dynamic;

import java.util.Arrays;

public class TripleStepProblem {


    /**
     * A child is running up a staircase with 'n' steps and hop either
     * 1 step, 2 steps, or 3 steps at a time.
     *
     * Implement a method to count how many possible ways the child run up the stairs
     * @param n The  number of steps
     * @return The number of possible ways run up the stairs
     */
    public int tripleStep(int n){

        if (n < 0) return 0;
        else if (n == 0) return 1;
        else return tripleStep(n-1)+tripleStep(n-2)+tripleStep(n-3);
    }

    public static int tripleStep(int n, int[] dp){
        if (n < 0) return 0;
        else if (n == 0) return 1;
        else if (dp[n] == 0) {
            dp[n] = tripleStep(n-1, dp)+tripleStep(n-2, dp)+tripleStep(n-3,dp);
            return dp[n];
        } else return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp =new int[n+1];
        Arrays.fill(dp, -1);
        tripleStep(n, dp);
        System.out.println("tripleStep(n, dp)"+tripleStep(n, dp));
    }
}
