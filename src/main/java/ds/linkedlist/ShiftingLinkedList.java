package ds.linkedlist;

/**
 *
 */
public class ShiftingLinkedList {

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static Node shiftLinkedList(Node head, int k) {

        Node currentNode = head;
        int length = 0;

        while (currentNode != null){
            length++;
            currentNode = currentNode.next;
        }

        if (length > 0){
            int movesRequired = (length < k) ? k % length : length;
            currentNode = head;

            if (movesRequired > 0) {
                Node prevNode = null;
                while (movesRequired > 0){
                    if (prevNode == null){
                        prevNode = currentNode;
                    } else {
                        prevNode.next = currentNode;
                    }
                    prevNode.next = currentNode;
                    currentNode = currentNode.next;
                    movesRequired--;
                }
                currentNode.next = prevNode;
            } else {
                
            }
        }

        return head;
    }
}
