package ds.linkedlist;

/**
 * Single linked list representation
 *
 * @author ramesh.battula
 *
 */
public class Node {

    /**
     * value of linked list
     */
    public int value;

    /**
     * next node reference
     */
    public Node next;

    /**
     * Initialize Node object with given value
     *
     * @param value The linked list value
     */
    public Node(int value){
        this.value = value;
        this.next = null;
    }

    static void print(Node head){
        while (head != null){
            System.out.print(head.value+((head.next != null) ? " -->" : ""));
            head = head.next;
        }
    }

}
