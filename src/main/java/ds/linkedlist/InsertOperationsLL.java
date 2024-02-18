package ds.linkedlist;

/**
 * Given a Linked List, the task is to insert a new node in this given Linked List at the following positions:
 *
 * At the front of the linked list
 * After a given node.
 * At the end of the linked list.
 */
public class InsertOperationsLL {

    /**
     * Adding new node at front of the linked list
     *
     * @param head
     * @param newNodeValue
     * @return
     */
    public Node addingFront(Node head, int newNodeValue){

        Node newNode = new Node(newNodeValue);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node addingLast(Node head, int newNodeValue){

        Node newNode = new Node(newNodeValue);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node currentNode = head;

        while (currentNode.next != null){
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;

        return head;

    }
}
