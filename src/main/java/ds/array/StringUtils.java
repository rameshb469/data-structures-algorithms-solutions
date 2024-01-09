package ds.array;

import java.util.Arrays;

public class StringUtils {

    /**
     * Check given string is unique or not
     * @param value The string value
     * @return true if all chars are unique other wise return false
     *
     * Time complexity is O(n^2)
     * Space complexity is O(1)
     */
    public boolean isUniqueChars(String  value){

        char[] chars = value.toCharArray();

        for (int i = 0; i < chars[i]; i++) {
            for (int j = (i+1); j < chars[i]; j++) {
                if (chars[i] == chars[j]) return true;
            }
        }

        return false;
    }

    /**
     * Check given string is unique or not
     *
     * Time  Complexity is O(n)
     * Space Complexity is O(1)
     *
     * @param value
     * @return
     */
    public static boolean isUniqueCharsMoreOptimistic(String value){
        if (value.length() > 128) return false;

        boolean[] ch_set = new boolean[128];
        for (int i = 0; i < value.length(); i++) {
            int val = value.charAt(i);
            if (ch_set[val]){
                return false;
            }
            ch_set[val] = true;
        }
        return true;
    }

    /**
     * Checking  given string are permutation or not
     *
     * Time complexity is O(nlogn)
     * Space complexity is
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean permutation(String s, String t){

        if (s.length() != t.length()) return false;

        return sort(s).equals(t);
    }

    public static boolean permutationSolution(String s, String t){

        if (s.length() != t.length()) return false;

        boolean[] chars = new boolean[128];

        int s_count = 0;
        for (int i = 0; i < s.length(); i++) {
            s_count+=s.charAt(i);
        }

        int t_count = 0;
        for (int i = 0; i < t.length(); i++) {
            t_count+=t.charAt(i);
        }

        return (s_count == t_count);
    }

    private static String sort(String value){
        char[] chars = value.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(isUniqueCharsMoreOptimistic("sabdwkes"));
        System.out.println(permutationSolution("dig", "god"));
    }



}
