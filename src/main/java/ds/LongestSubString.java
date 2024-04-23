package ds;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    // "abcabcbb"
    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        Set<Character> values = new HashSet<>();

        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (!values.contains(curr)){
                values.add(curr);
                temp++;
            } else {
                if (count < temp){
                    count = temp;
                }
                values.clear();
                values.add(curr);
                temp = 1;
            }
        }

        return count;

    }
}
