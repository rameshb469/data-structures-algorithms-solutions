package ds.sliding_window;

public class MaximumProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }

    public static int maxProfit(int[] array) {
        // we use two pointers
        // first pointer find the buy pointer
        // second pointer find the sell point
        // if array[left] > array[right]
        // then move left pointer and right pointer by 1

        int length = array.length;
        int left = 0;
        int right = 1;

        int maxProfit = Integer.MIN_VALUE;
        while (right < length) {
            // if transition profitable
            int profit = array[right] - array[left];
            if (profit > 0) {
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // we have move lowest point
                left = right;
            }
            right = right + 1;
        }
        return maxProfit;
    }

}
