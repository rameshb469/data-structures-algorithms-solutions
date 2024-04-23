package ds.sliding_window;

public class LongestSubArraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLargestSum(new int[]{1,3,5,6,3,4,6,8,1,4,5}, 10));
    }

    public static int minSubArrayLargestSum(int[] array, int sum){

        int minWindowSize = Integer.MAX_VALUE;
        int windowStart = 0;
        int currentSum = 0;

        //1,3,5,6,3,4,6,8,1,4,5
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            currentSum+=array[windowEnd];

            while (currentSum >= sum){
                minWindowSize = Math.min(minWindowSize, windowEnd-windowStart+1);
                currentSum-=array[windowStart];
                windowStart++;
            }

        }

        return minWindowSize;
    }
}
