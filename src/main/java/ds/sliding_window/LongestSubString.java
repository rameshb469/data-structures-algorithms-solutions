package ds.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, find the length of the longest
 * substring
 * without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;

        int windowStart = 0;
        int maxCount = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);

            while (set.contains(curr)) {
                set.remove(s.charAt(windowStart));
                windowStart++;
            }

            set.add(curr);
            maxCount = Math.max(maxCount, windowEnd - windowStart + 1);
        }

        return maxCount;
    }
}
