package ds.sliding_window;

import java.util.*;

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
            while (!deque.isEmpty() && array[i] > array[deque.peekLast()] ){
                deque.removeLast();
            }

            deque.offer(i);

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
