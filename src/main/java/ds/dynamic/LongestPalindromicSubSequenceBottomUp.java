package ds.dynamic;

public class LongestPalindromicSubSequenceBottomUp {

    public static int longestPalindromicSubSequence(String s){

        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        // dp[i][j] = max(dp[i][j+1], dp[i+1][j]) if both are not same
        // dp[i][j] = max(2+dp[i+1][j+1],dp[i][j+1], dp[i+1][j])

        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if (j < i) dp[i][j] = 0;
                else if (i == j) dp[i][j] = 1;
                else if(s.charAt(i) == s.charAt(j)){
                    int c1 = 2+dp[i+1][j+1];
                    dp[i][j] =  Math.max(c1, Math.max(dp[i+1][j], dp[i][j+1]));
                } else {
                    dp[i][j] =  Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubSequence("bbbab"));
    }
}
