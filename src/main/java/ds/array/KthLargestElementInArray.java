package ds.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array

 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : nums){
            queue.add(i);
        }

        int res = 0;
        for (int i = k; i > 0 ; i--) {
            res = queue.remove();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
