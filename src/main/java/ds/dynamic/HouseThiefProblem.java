package ds.dynamic;

/**
 *  There are 'N' number of houses build in a line
 *  A thief going steal the house with max value
 *  But he can't steal adjacent houses
 */
public class HouseThiefProblem {

    public static int dpTopDownApproach(int[] houses){
        int[] dp = new int[houses.length];
        return dpTopDownApproach(houses, 0, dp);
    }

    public static int dpBottomToTopApproach(int[] houses){

        int n = houses.length;
        int[] dp = new int[n+1];

        for (int i = n; i >= 0 ; i--) {
            dp[i] = Math.max(houses[i]+dp[i+2], dp[i+1]);
        }

        return dp[0];
    }

    public static int dpTopDownApproach(int[] houses, int index, int[] dp){

        if (index >= houses.length) return 0;

        // if we choose to steal the first house
        // v1 = houses[currentIndex]+rec(houses, index+2)
        if (dp[index] == 0){
            int v1 = houses[index]+dpTopDownApproach(houses, index+2, dp);
            int v2 = dpTopDownApproach(houses, index+1, dp);
            dp[index] = Math.max(v1, v2);
        }

        // otherwise,v2= 0+rec(houses, index+1)
        // return max(v1, v2)
        return dp[index];
    }

    public static void main(String[] args) {
        int[] houses = new int[]{6,7,1,30,8,2,4};
        System.out.println(dpTopDownApproach(houses));
        System.out.println("----------------------------");
        houses = new int[]{20,5,1,13,6,11,40};
        System.out.println(dpTopDownApproach(houses));
    }
}
