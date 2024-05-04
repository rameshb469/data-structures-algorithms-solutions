package ds.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MonotonicDecreasingStack {

    public static void main(String[] args) {
        int[] rs = dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        for (int r : rs){
            System.out.print(r+" ");
        }
    }

    /**
     * Get Next maximum values
     * @param temperatures values
     * @return next value max list
     */
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<List<Integer>> monotonicStack = new Stack<>();
        int[] results = new int[temperatures.length];
        for(int i= temperatures.length-1; i>= 0; i--){

            while (!monotonicStack.isEmpty() && monotonicStack.peek().get(1) < temperatures[i]){
                monotonicStack.pop();
            }

            if(!monotonicStack.isEmpty()){
                results[i] = monotonicStack.peek().get(0)-i;
            }

            monotonicStack.push(Arrays.asList(i, temperatures[i]));
        }

        return results;
    }
}
