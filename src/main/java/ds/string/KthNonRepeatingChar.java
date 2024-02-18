package ds.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * K’th Non-repeating Character
 * Given a string str of length n (1 <= n <= 106) and a number k, the task is to find the kth non-repeating character in the string.
 *
 * Examples:
 *
 * Input : str = geeksforgeeks, k = 3
 * Output : r
 * Explanation: First non-repeating character is f, second is o and third is r.
 *
 * Input : str = geeksforgeeks, k = 2
 * Output : o
 */
public class KthNonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(kthNonRepeatingChar("geeksforgeeks", 3));
    }

    /**
     * @param text
     * @param k
     * @return
     */
    public static char kthNonRepeatingChar(String text, int k){

        Map<Character,Integer> charMap = new LinkedHashMap<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (charMap.containsKey(chars[i])){
                int value = charMap.get(chars[i]);
                charMap.put(chars[i], value+1);
            } else {
                charMap.put(chars[i], 1);
            }
        }

        int count = 1;
        for (Map.Entry<Character,Integer> entry : charMap.entrySet()){
            if (entry.getValue() == 1){
                if (count == k) return entry.getKey();
                count++;
            }
        }

        return "".charAt(0);
    }

    public int v(int x){return 0;}
    public long v(int x, int y){return 0;}
}
