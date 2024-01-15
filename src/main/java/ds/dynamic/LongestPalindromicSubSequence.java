package ds.dynamic;

public class LongestPalindromicSubSequence {

    public static int longestPalindromicSubSequence(String s){
        return longestPalindromicSubSequence(s, 0, s.length()-1);
    }

    private static int longestPalindromicSubSequence(String s, int startIndex, int endIndex){

        if (startIndex > endIndex) {  // already read the all chars
            return 0;
        }

        if (startIndex == endIndex) { // middle index
            return 0;
        }

        int c1= 0;
        if (s.charAt(startIndex) == s.charAt(endIndex)){
            c1 = 2+longestPalindromicSubSequence(s, startIndex+1, endIndex+1);
        }

        int c2 = longestPalindromicSubSequence(s, startIndex+1, endIndex);
        int c3 = longestPalindromicSubSequence(s, startIndex, endIndex-1);

        return Math.max(c1, Math.max(c2, c3));
    }
}
