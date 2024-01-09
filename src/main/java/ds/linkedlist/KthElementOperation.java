package ds.linkedlist;

public class KthElementOperation {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(4);
        printNode(node);
        removeKthNodeFromEnd(node, 2);
        System.out.println("after");
        printNode(node);
    }

    // k =4  0 (F,S) -> 1 -> 2 -> 3

    // 0 (F) -> 1 -> 2 -> 3-> null(S)

    public static void removeKthNodeFromEnd(Node head, int k){
        // create two pointer and both points to head;
        Node first = head;
        Node second = head;
        int counter = 1;
        // second pointer move by kth positions
        while (counter <= k && second != null){
            second = second.next;
            counter++;
        }
        // If second pointer is null then remove header
        if (second == null){
            head.value = first.next.value;
            head.next = first.next;
            return;
        }
        // If second pointer next element is null then
        // update fist pointer to next to next element
        while (second.next != null) {
            second = second.next;
            first = first.next;
        }

        first.next = first.next.next;
        // fi second pointer next is not null then move 1pointer each
    }

    static void printNode(Node node){
        while (node != null){
            System.out.println(node.value+"-->");
            node = node.next;
        }
    }
}
