package ds.sliding_window;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static  int frequencyOfMostFrequentElement(int[] array, int k){

        Arrays.sort(array);

        int windowStart = 0, windowEnd = 0;
        int res = 0, total = 0;
        for (windowEnd = 0; windowEnd < array.length; windowEnd++) {

            total += array[windowEnd];
            // affortable or not

            while (array[windowEnd]*(windowEnd-windowStart+1) > total+k){
                total -= array[windowStart];
                windowStart++;
            }

            res = Math.max(res, windowEnd-windowStart+1);
        }

        return res;
    }
}
