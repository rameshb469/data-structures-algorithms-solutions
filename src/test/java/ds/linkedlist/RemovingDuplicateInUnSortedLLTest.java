package ds.linkedlist;

import static ds.linkedlist.Node.print;

public class RemovingDuplicateInUnSortedLLTest {

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);

        System.out.println("Before removing duplicates....... ");
        print(head);
        System.out.println("After removing duplicates....... ");
        print(RemovingDuplicateInUnSortedLL.removingDuplicatesInUnSortedLLByUsingBuffer(head));
    }
}
