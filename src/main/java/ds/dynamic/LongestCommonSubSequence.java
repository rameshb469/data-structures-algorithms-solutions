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
public class LongestCommonSubSequence {

    /**
     * Given two strings
     * @param s1 The first string
     * @param s2 The second string
     * @return length of common subsequence
     */
    public static int longestCommonSubSequence(String s1, String s2){
        return longestCommonSubSequence(s1, s2, 0, 0);
    }


    public static int longestCommonSubSequence(String s1, String s2, int i1, int i2){

        if (s1.length() == i1 || s2.length() == i2){
            return 0;
        }

        int c1 = 0;
        if (s1.charAt(i1) == s2.charAt(i2)){
            return 1+longestCommonSubSequence(s1, s2, i1+1, i2+1);
        }

        int c2 = longestCommonSubSequence(s1, s2, i1+1, i2);
        int c3 = longestCommonSubSequence(s1, s2, i1, i2+1);

        return Math.max(c1, Math.max(c2, c3));
    }
}
