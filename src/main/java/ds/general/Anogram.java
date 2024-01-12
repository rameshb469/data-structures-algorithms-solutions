package ds.general;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Checking the  given 2 string anogram or not
 */
public class Anogram {

    /**
     * Checking the anogram
     *
     * @param s1 The first string
     * @param s2 The second string
     * @return true if both string are anogram
     */
    public static boolean isAnogram(String s1, String s2){

        if (s1.length() == s2.length()){

            char[] s1Chars = s1.toCharArray();
            char[] s2Chars = s2.toCharArray();

            Arrays.sort(s1Chars);  // O(n logn)
            Arrays.sort(s2Chars);

            for (int i = 0; i < s1.length(); i++) {
                if (s1Chars[i] != s2Chars[i]){
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isAnogram("abcdef", "cdefcb"));
    }
}
