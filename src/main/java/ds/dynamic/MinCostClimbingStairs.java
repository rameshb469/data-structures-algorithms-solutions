package ds.dynamic;

/**
 * 746. Min Cost Climbing Stairs
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairs(cost, 0);
    }

    public static int minCostClimbingStairs(int[] cost, int index){

        if(index>= cost.length) return 0;

        // if pick the current step
        int c1 = cost[index]+minCostClimbingStairs(cost, index+1);
        int c2 = cost[index]+minCostClimbingStairs(cost, index+2);
        int c3 = minCostClimbingStairs(cost, index+1);

        return Math.min(c1, Math.min(c2, c3));
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
