package ds.array;

import java.util.*;

/**
 * Find the pair of min abs of given array
 *
 * A = {-2,-1, 4, 7, 9, 10, 12}
 * Output : -2 -1
 *          9 10
 */
public class MinAbsDiffPair {

    public static void main(String[] args) {
        printAbsMinDiff(Arrays.asList(-2,-1, 4, 7, 9, 10, 12));
    }

    public static void printAbsMinDiff(List<Integer> values){

        Collections.sort(values);

        int min_diff = Integer.MAX_VALUE;
        Map<Integer,Integer> pair = new LinkedHashMap<>();
        for (int i = 0; i < values.size()-1; i++) {

            int diff = Math.abs(values.get(i)-values.get(i+1));
            if (min_diff == diff) {
                pair.put(values.get(i), values.get(i+1));
            }

            if (min_diff > diff){
                pair.clear();
                pair.put(values.get(i), values.get(i+1));
                min_diff = diff;
            }
        }

        for (Map.Entry<Integer,Integer> entry : pair.entrySet()){
            System.out.print(entry.getKey()+" "+entry.getValue());
            System.out.println();
        }
    }
}
