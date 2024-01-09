package ds.linkedlist;

import static ds.linkedlist.LinkedListSolutions.printNode;

/**
 * You're given two Linked Lists of potentially unequal length. Each Linked List
 * represents a non-negative integer, where each node in the Linked List is a
 * digit of that integer, and the first node in each Linked List always
 * represents the least significant digit of the integer. Write a function that
 * returns the head of a new Linked List that represents the sum of the integers
 * represented by the two input Linked Lists.
 * <p>
 * linkedListOne = 2 -> 4 -> 7 -> 1
 * linkedListTwo = 9 -> 4 -> 5
 * Sample Output = 1 -> 9 -> 2 -> 2
 */
public class SumOfLinkedList {

    /**
     * @param linkedListOne
     * @param linkedListTwo
     * @return
     */
    public static Node sumOfLinkedLists(Node linkedListOne, Node linkedListTwo) {
        Node newLinkedListNode = new Node(0);
        Node currentNode = newLinkedListNode;

        Node nodeOne = linkedListOne;
        Node nodeTwo = linkedListTwo;
        int curry = 0;

        // we should also include curry because curry
        while (nodeOne != null || nodeTwo != null || curry != 0) {
            int firstValue = (nodeOne != null) ? nodeOne.value : 0;
            int secondValue = (nodeTwo != null) ? nodeTwo.value : 0;

            int sum = firstValue + secondValue + curry;
            currentNode.next = new Node(sum % 10);
            currentNode = currentNode.next;

            curry = sum / 10;
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;
        }

        return newLinkedListNode.next;
    }

    public static void main(String[] args) {
        Node linkedListOne = new Node(2);
        linkedListOne.next = new Node(4);
        linkedListOne.next.next = new Node(7);
        linkedListOne.next.next.next = new Node(1);

        Node linkedListTwo = new Node(9);
        linkedListTwo.next = new Node(4);
        linkedListTwo.next.next = new Node(5);
        printNode(sumOfLinkedLists(linkedListOne, linkedListTwo));
    }
}
