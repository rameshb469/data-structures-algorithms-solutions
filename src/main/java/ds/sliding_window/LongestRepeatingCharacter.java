package ds.sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacter {

    public static int longestRepeatingCharacter(String s, int k){

        // first we will maintain two pointer l and r
        int l = 0;
        // we have character counter
        Map<Character, Integer> counterMap = new HashMap<>();
        // we will iterate each and every char

        int maxCount = Integer.MIN_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char curr = s.charAt(r);
            counterMap.put(curr, counterMap.getOrDefault(curr, 0)+1);
            int maxCharCount = Collections.max(counterMap.values());
            while ((r-l+1)-maxCharCount <= k){
                counterMap.put(s.charAt(l), counterMap.getOrDefault(s.charAt(l), 0)-1);
                l++;
            }
            counterMap.put(curr, counterMap.getOrDefault(curr, 0)+1);
            maxCount = Math.max(maxCount, r-l+1);
        }

        return  maxCount;

    }
}
