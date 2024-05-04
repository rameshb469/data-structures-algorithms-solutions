package ds.sliding_window;

import java.util.*;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class SlidingWindowMaximum {

    // [9,-2,3,4,5,-3,4,7,3,8,4], k = 3
    public static int[] slidingWindowMax(int[] array, int k){

        int n = array.length;
        int[] result = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {

            // remove which not in the current window
            while (!deque.isEmpty() && deque.peek() <= i-k){
                deque.poll();
            }

            // removing not needed values form queue
            // i.e remove all elements which are less then current element
            // them remove from last

            while (!deque.isEmpty() && array[i] > array[deque.peekLast()] ){
                deque.removeLast();
            }

            deque.offer(i);

            // start adding the results
            if (i >= k-1){
                result[index++] = array[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var list = slidingWindowMax(new int[]{9,-2,3,4,5,-3,4,7,3,8,4}, 3);
        for(int val : list){
            System.out.println(val+" ");
        }
    }
}
