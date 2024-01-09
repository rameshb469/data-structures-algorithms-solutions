package ds.stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * stack implementation
 */
public class StackImplUsingArray {

    private int[] elements = null;

    private int topIndex = -1;

    // creating stack
    public StackImplUsingArray(int size){
        elements = new int[size];
    }

    public void push(int value){

        if (isFull()) throw new RuntimeException("Stack is full");

        elements[++topIndex] = value;
    }

    public int pop(){
        if (isEmpty()) throw new RuntimeException("Stack is Empty");

        int value = elements[topIndex--];
        return value;
    }

    public int peek(){
        if (isEmpty()) throw new RuntimeException("Stack is Empty");
        return elements[topIndex];
    }

    public void delete(){
        elements = null;
    }

    public boolean isEmpty(){
        return (topIndex == -1);
    }

    public boolean isFull(){
        return (topIndex == elements.length-1);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<Integer>();
        Queue<Integer> queue2 = new ArrayDeque<>();
    }
}
