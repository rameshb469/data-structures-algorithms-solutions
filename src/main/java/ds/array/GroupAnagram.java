package ds.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupMap = new LinkedHashMap<>(strs.length);

        for(String value : strs){
            String sorted = sort(value);
            List<String> rs = groupMap.getOrDefault(sorted, new ArrayList<>());
            rs.add(value);
            groupMap.put(sorted, rs);
        }

        return groupMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    private static String sort(String value){
        char[] chars = value.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{"a"}));
        System.out.println(groupAnagrams(new String[]{""}));
    }
}
