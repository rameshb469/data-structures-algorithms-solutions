package ds.stack;


import ds.linkedlist.Node;

public class StackImplUsingLinkedList {

    private Node head = null;

    public void push(int value){
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if (isEmpty()) throw new RuntimeException("Stack is Empty");

        int value = head.value;
        head = head.next;
        return value;
    }

    public int peek(){
        if (isEmpty()) throw new RuntimeException("Stack is Empty");

        return head.value;
    }

    public void delete(){
        head = null;
    }

    public boolean isEmpty(){
        return (head == null);
    }
}
