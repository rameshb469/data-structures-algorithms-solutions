package ds.sliding_window;

public class LargestSubArraySum {

    public static void main(String[] args) {
        System.out.println(largestSubArraySum(new int[]{100, 200, 300, 400}, 2));
    }

    public static int largestSubArraySum(int[] array, int k){

        int length = array.length;
        if (length < k){
            throw new RuntimeException("Invalid k value");
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=array[i];
        }

        int window_max = sum;
        for (int i = k; i < length; i++) {
            int temp = window_max-array[i-k]+array[i];
            window_max = Math.max(window_max, temp);
        }
        return window_max;
    }
}
