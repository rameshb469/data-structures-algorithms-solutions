package ds.linkedlist;

public interface LinkedListMasterData {

    Node DUPLICATE_UNSORTED_LL = getDuplicateLinkedList();

    Node EMPTY_LINKED_LIST = null;

    Node TEST_RESULT_FOR_DUPLICATED_UNSORTED_LL = getTestResultForUnSortedLinkedList();

    static Node getTestResultForUnSortedLinkedList() {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        return head;
    }

    static Node getDuplicateLinkedList() {
        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(5);
        return head;
    }

}
