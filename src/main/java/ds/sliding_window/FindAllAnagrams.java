package ds.sliding_window;

import java.util.*;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        var rs = findAllAnagrams("cbaebabacd", "abc");
        for (int r : rs) {
            System.out.print(r + " ");
        }
    }

    // * Input: s = "cbaebabacd", p = "abc"
    public static List<Integer> findAllAnagrams(String s, String t){

        if (s.length() < t.length()) return Collections.emptyList();

        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            tMap.put(curr, tMap.getOrDefault(curr, 0)+1);
            sMap.put(curr, 0);
        }

        int windowStart = 0;
        List<Integer> results = new ArrayList<>();
        int currentIndex = 0;

        for (int windowEnd = 0; windowEnd < t.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);
            if (sMap.containsKey(curr)){
                sMap.put(curr, sMap.getOrDefault(curr, 0)+1);
            }

            if (sMap.equals(tMap)){
                results.add(windowStart);
            }
        }

        for (int windowEnd = t.length(); windowEnd < s.length(); windowEnd++) {
            char curr = s.charAt(windowEnd);
            char firstChar = s.charAt(windowStart++);
            if (sMap.containsKey(firstChar)){
                sMap.put(firstChar, sMap.getOrDefault(firstChar, 0)-1);
            }

            if (sMap.containsKey(curr)){
                sMap.put(curr, sMap.getOrDefault(curr, 0)+1);
            }

            if (sMap.equals(tMap)){
                results.add(windowStart);
            }
        }

        return results;
    }
}
