package ds.string;

/**
 * Given a string, find lexicographically next string.
 *
 * Examples:
 *
 * Input : geeks
 * Output : geekt
 * The last character 's' is changed to 't'.
 *
 * Input : raavz
 * Output : raawz
 * Since we can't increase last character,
 * we increment previous character.
 *
 * Input :  zzz
 * Output : zzza
 * If string is empty, we return ‘a’.
 * If string contains all characters as ‘z’, we append ‘a’ at the end.
 * Otherwise we find first character from end which is not z and increment it.
 */
public class lexicographicallyNextString {

    public static String next(String s){

        if (s == null || s.length() == 0) return "a";

        int lastCharIndex = s.length()-1;

        while (s.charAt(lastCharIndex) != 'z' && lastCharIndex >=0 ){
            lastCharIndex--;
        }

        if (lastCharIndex == -1) return s+"a";

        char newChar = (char) (((int)s.charAt(lastCharIndex))+1);

        return s.substring(0, lastCharIndex)+newChar+s.substring(lastCharIndex+1);
    }
}
