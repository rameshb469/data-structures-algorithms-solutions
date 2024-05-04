package ds.stack;

import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 6, 2, 3};
        print(nextSmallElement(input));
        print(new int[]{1,0,2,2,0,0});
        System.out.println("-------------------");
        print(nextGreaterElement(input));
        print(new int[]{5,5,6,0,0,0});
        System.out.println("-------------------");
        print(prevSmallElement(input));
        print(new int[]{0, 0, 1,5,1,2});
        System.out.println("-------------------");
        print(prevGreatElement(input));
        print(new int[]{0,2,0,0,6,6});


    }

    // input  : [2,1,5,6,2,3]
    // output : [1,0,2,2,0,0]
    public static int[] nextSmallElement(int[] array) {

        Stack<Integer> stack = new Stack<>();
        // monotonic increase stack : increasing order bottom to top
        int[] results = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {

            int current = array[i];
            while (!stack.isEmpty() && stack.peek() > current) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek();
            }

            stack.push(current);
        }

        return results;

    }

    // input  : [2,1,5,6,2,3]
    // output : [5,5,6,0,0]
    public static int[] nextGreaterElement(int[] array) {

        int[] results = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = array.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < array[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return results;
    }

    // input  : [2,1,5,6,2,3]
    // output : [0, 0, 1,5,2]
    public static int[] prevSmallElement(int[] array) {
        int[] results = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() > array[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return results;
    }

    // input  : [2,1,5,6,2,3]
    // output : [0,2,0,0,6,0]
    public static int[] prevGreatElement(int[] array) {
        int[] results = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && stack.peek() < array[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                results[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return results;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }
}
