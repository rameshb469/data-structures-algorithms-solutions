package ds.dynamic;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 */
public class LongestCommonSubSequenceBottomUp {

    public static int longestCommonSubSequence(String s1, String s2){

        int M = s1.length();
        int N = s2.length();
        int[][] dp = new int[M+1][N+1];

        // dp[i][j]= 1 if s1[i] == s2[j]
        // dp[i][j] = max(dp[i+1][j], dp[i], [j+1])

        for (int i = M-1; i >= 0 ; i--) {
            for (int j = N-1; j >= 0 ; j--) {

                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = Math.max(1+dp[i+1][j+1], Math.max(dp[i+1][j], dp[i][j+1]));
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubSequence("abcde", "ace"));
    }
}
