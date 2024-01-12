package ds.dynamic;

/**
 * <ul>
 *     <li>Given the weights and profits of 'N' items </li>
 *     <li>We are asking put  these items in Knapsack which has capacity is 'C'</li>
 *     <li>Restrict is that  we can't break item into smaller unit (fractional units)</li>
 *     <li>Challenges to find the maximum profits from knapsack</li>
 * </ul>
 *
 * <div>
 *     <h4>Profits : {31, 26, 72, 17}</h4>
 *     <h4>Weights : {3,1,5,2} </h4>
 *     <h4>Knapsack capacity is 7 </h4>
 * </div>
 */
public class KnapsackProblem {

    public static int knapsack(int[] profits, int[] weights, int capacity){
        // {31, 26, 72, 17}
        return knapsack(profits, weights, capacity, 0);
    }

    public static int knapsackMemoization(int[][] dp, int[] profits, int[] weights, int capacity, int currentIndex){

        if (capacity <=0 || currentIndex>= profits.length){
            return 0;
        }

        if (dp[currentIndex][capacity] == 0){
            // if we pick the current value
            int p1 = 0;
            if (weights[currentIndex] <= capacity){
                p1 = profits[currentIndex]+knapsackMemoization(dp, profits, weights, capacity-weights[currentIndex], currentIndex+1);
            }

            // if not picking the current value
            int p2 = knapsackMemoization(dp, profits, weights, capacity, currentIndex+1);

            dp[currentIndex][capacity] = Math.max(p1, p2);
        }

        return dp[currentIndex][capacity];
    }

    /**
     * Knapsack problem
     *
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @return
     */
    public static int knapsack(int[] profits, int[] weights, int capacity, int currentIndex){

        // Base condition
        if (capacity <= 0 || currentIndex >= profits.length || currentIndex >= weights.length)
            return 0;

        // If we select the first elements then
        // profit = profits[currentIndex]+moving  to next element
        //  <h4>Profits : {31, 26, 72, 17}</h4>
        //  <h4>Weights : {3,1,5,2} </h4>
        //  <h4>Knapsack capacity is 7 </h4>

        int p1 = 0;

        if (weights[currentIndex] <= capacity){
            p1 = profits[currentIndex]+knapsack(profits, weights,
                    capacity-weights[currentIndex], currentIndex+1);
        }

        int p2 = knapsack(profits, weights, capacity, currentIndex+1);

        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int[] profits = new int[]{31,26,72,17};
        int[] weights = new int[]{3,1,5,2};
        int knapsack = 7;

        System.out.println(knapsack(profits, weights, knapsack));

        int[][] dp = new int[profits.length+1][knapsack+1];
        System.out.println("using memoization"
                +knapsackMemoization(dp,profits,weights,knapsack, 0));
    }
}
