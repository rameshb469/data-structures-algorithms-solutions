package ds.sliding_window;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Hard
 * Topics
 * Companies
 * Hint
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinWindowSubString {

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {

        if (t.isEmpty()) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            tMap.put(curr, 1+tMap.getOrDefault(t.charAt(i), 0));
            sMap.put(curr, 0);
        }

        

        int windowStart = 0;
        int length = Integer.MAX_VALUE;
        String rs = "";
        for (int windowEnd = 0; windowEnd < s.length();  windowEnd++) {
            char curr = s.charAt(windowEnd);
            if (tMap.containsKey(curr)){
                sMap.put(curr, 1+sMap.getOrDefault(curr, 0));
            }

            while (containsAll(sMap, tMap)){
                int cLength = windowEnd-windowStart+1;
                if (cLength < length){
                    length = Math.min(length, cLength);
                    rs = s.substring(windowStart, windowEnd+1);
                }
                char startChar = s.charAt(windowStart);
                if (sMap.containsKey(startChar)){
                    sMap.put(startChar, sMap.getOrDefault(startChar, 0)-1);
                }
                windowStart++;
            }
        }

        return rs;
    }

    private static boolean containsAll(Map<Character, Integer> sMap,
                                       Map<Character, Integer> tMap){
        for (var entry : tMap.entrySet()){
            int sCount = sMap.getOrDefault(entry.getKey(), 0);
            if (sCount < entry.getValue()){
                return false;
            }
        }

        return true;
    }

    public static String minWindow2(String s, String t) {

        int[] sMap = new int[128];
        int[] tMap = new int[128];

        for(char curr : t.toCharArray()){
            tMap[curr]++;
        }

        int windowStart = 0;
        int resLength = Integer.MAX_VALUE;
        String res = "";

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);

            if (tMap[curr] > 0){
                sMap[curr]++;
            }

            while (containsAll(sMap, t)){
                int windowLength = windowEnd-windowStart+1;
                if (resLength > windowLength){
                    res = s.substring(windowStart, windowEnd+1);
                    resLength = windowLength;
                }

                char startChar = s.charAt(windowStart++);
                if (sMap[startChar] > 0){
                    sMap[startChar]--;
                }
            }
        }

        return res;
    }

    private static boolean containsAll(int[] sMap,
                                       String t){
        
        for ( char curr : t.toCharArray()){
            if (sMap[curr] <= 0){
                return false;
            }
        }
        return true;
    }

}
