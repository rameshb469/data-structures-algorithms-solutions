package ds.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 * Hard
 * Topics
 * Companies
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 */
public class MaxHistogramArea {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }

    public static int largestRectangleArea(int[] heights) {
        // find the mi heights till left and right
        // find out the area = current_height *(right-left+1)

        // 2,1,5,6,2,3
        // stack = [1]
        // left = [0,0,]
        Stack<Integer> indexStack = new Stack<>();

        int[] leftMinIndex = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (!indexStack.isEmpty() && heights[indexStack.peek()] >= heights[i]){
                indexStack.pop();
            }
            if (!indexStack.isEmpty()){
                leftMinIndex[i] = indexStack.peek()+1;
            }
            indexStack.push(i);
        }

        // find out the next min value

        indexStack.clear();
        int[] rightMinIndex = new int[heights.length];

        Arrays.fill(rightMinIndex, heights.length-1);
        for (int i = heights.length-1; i >= 0; i--) {
            while (!indexStack.isEmpty() && heights[indexStack.peek()] >= heights[i]){
                indexStack.pop();
            }
            if (!indexStack.isEmpty()){
                rightMinIndex[i] = indexStack.peek()-1;
            }
            indexStack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currArea = heights[i] * (rightMinIndex[i]-leftMinIndex[i]+1);
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
