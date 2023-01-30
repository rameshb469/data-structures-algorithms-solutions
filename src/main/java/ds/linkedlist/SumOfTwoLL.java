package ds.linkedlist;

import static ds.linkedlist.Node.print;

/**
 * You're given two Linked Lists of potentially unequal length. Each Linked List
 * represents a non-negative integer, where each node in the Linked List is a
 * digit of that integer, and the first node in each Linked List always
 * represents the least significant digit of the integer. Write a function that
 * returns the head of a new Linked List that represents the sum of the integers
 * represented by the two input Linked Lists.
 */
public class SumOfTwoLL {

    /**
     * Sample input
     *  linkedListOne = 2 -> 4 -> 7 -> 1 (1 7 4 2)
     *  linkedListTwo = 9 -> 4 -> 5      (5 4 9)
     *  ---------------------------------
     *  total =  1 9 2 2
     * @param linkedListOne
     * @param linkedListTwo
     * @return
     */
    public static Node sumOfLinkedLists(Node linkedListOne, Node linkedListTwo) {

        /**
         * Create two linked list reference for storing head and adding next nodes
         */
        Node head = new Node(1);
        Node currentNode = head;

        /**
         * initialize carry as zero
         */
        int carry =  0;

        /**
         * iterate 2 given linked list till linked list null or carry not equal to zero
         */
        while (linkedListOne != null || linkedListTwo != null || carry != 0){
            /**
             * capture the values of both linked list values
             *
             * if linked list null then set default values as 0
             */
            int first = (linkedListOne != null) ? linkedListOne.value : 0;
            int second = (linkedListTwo != null) ? linkedListTwo.value : 0;

            /**
             * adding both linked list values and carry value
             */
            int sum = (first + second + carry);

            /**
             * we have set carry by diving sum by 10
             */
            carry = sum / 10;

            /**
             * create a new node with value sum % 10
             * and move currentNode linked list
             */
            currentNode.next = new Node(sum % 10);
            currentNode = currentNode.next;

            /**
             * move linkedListOne by one place
             */
            if (linkedListOne != null)
                linkedListOne = linkedListOne.next;

            /**
             * move linkedListOne by one place
             */
            if (linkedListTwo != null)
                linkedListTwo = linkedListTwo.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node linkedListOne = new Node(2);
        linkedListOne.next = new Node(4);
        linkedListOne.next.next = new Node(7);
        linkedListOne.next.next.next = new Node(1);

        Node linkedListTwo = new Node(9);
        linkedListTwo.next = new Node(4);
        linkedListTwo.next.next = new Node(5);

        print(sumOfLinkedLists(linkedListOne, linkedListTwo));
    }
}
