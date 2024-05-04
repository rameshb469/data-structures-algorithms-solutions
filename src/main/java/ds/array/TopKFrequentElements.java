package ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 347. Top K Frequent Elements

 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k){

        Map<Integer,Integer> countMap = new HashMap<>();
        List<Integer> rs = new ArrayList<>();
        for (int n : nums){
            int count = countMap.getOrDefault(n, 0)+1;
            if (count > k) continue;
            countMap.put(n, count);
            if (count == k){
                rs.add(n);
            }
        }

        int[] arr = new int[rs.size()];
        int i=0;
        for(int n : rs){
            arr[i++]=n;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] res = topKFrequent(new int[]{1,1,1,1,4,4,4,2,2,2,3}, 2);
        for (int value : res){
            System.out.println(value);
        }
    }
}
