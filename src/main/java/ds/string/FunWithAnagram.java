package ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * compare the current string to adjacent string if both are anogram then remove it.
 */
public class FunWithAnagram {

    public static void main(String[] args) {

        List<String> arr = new ArrayList<>();
        arr.add("abc");
        arr.add("bca");
        arr.add("cba");
        arr.add("cfa");
        System.out.println(funWithAnagram(arr));
    }

    public static List<String> funWithAnagram(List<String> text) {

        List<String> sorted = text.stream()
                .map(FunWithAnagram::sort)
                .collect(Collectors.toList());

        String curr = sorted.get(0);
        for (int i = 0; i < text.size() - 1; i++) {
            String next = sorted.get(i + 1);
            if (curr.equalsIgnoreCase(next)) {
                text.remove(i + 1);
            } else {
                curr = next;
            }
        }
        return text;
    }


    private static String sort(String text) {
        char[] chars = text.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
