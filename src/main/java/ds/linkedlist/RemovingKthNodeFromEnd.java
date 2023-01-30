package ds.linkedlist;

/**
 * This class contains solution of removing kth node from end
 */
public class RemovingKthNodeFromEnd {

    public static Node removeKthNodeFromEnd(Node head, int k){

        /**
         * initialize two pointer called first and second
         */
        Node first = head;
        Node second = head;

        /**
         * move first reference till k > 0 or first node null
         */

        while (k > 0 &&  first != null){
            first = first.next;
        }
        /**
         * If first node reference is null then set head = head.next and return it
         */

        if (first == null){
            head = head.next;
            return head;
        }

        /**
         * If first node reference is NOT NULL then, the move first and second pointer
         * till  fist pointer reach to end.
         */

        while (first != null){
            first = first.next;
            second = second.next;
        }

        /**
         * we will find kth position in the linked list
         * update the reference of second node.
         */
        second = second.next.next;

        return head;
    }
}
