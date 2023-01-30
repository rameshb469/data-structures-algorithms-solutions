package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains solution of removing duplicates from unsorted linked list
 *
 * We can solve this multiple ways based on our requirement
 */
public class RemovingDuplicateInUnSortedLL {

    /**
     * We will use a buffer for removing duplicates from unsorted linked list
     *
     * @param head The Node head node
     * @return Node head without duplicate values
     */
    public static Node removingDuplicatesInUnSortedLLByUsingBuffer(Node head){

        /**
         * We create a new LinkedList reference and used this for iterate.
         * If we use {@link Node} head reference, we will loose head of linked list
         * so, we should create a separate LinkedList reference
         */
        Node currentNode = head;

        /**
         * Create {@link java.util.Set} object for buffer
         */
        Set<Integer> buffer = new HashSet<Integer>();

        /**
         * Initialize a Node reference for  previous Node
         *
         * NULL(prevNode) -> A(currentNode) -> B -> C
         */
        Node prevNode = null;

        /**
         * Iterate LinkedList till current node not equal to null and use currentNode reference
         */
        while (currentNode != null){

            /**
             * current node value
             */
            int currentNodeValue = currentNode.value;

            /**
             * If currentNode value already contains in the buffer,then remove it.
             * We can remove LinkedList node by updating the next node reference
             *
             * Ex : A -> B -> C -> D -> E -> F
             * If we want remove 'C', by updating the 'B' next node should be D
             * B.next = D
             */
            if (buffer.contains(currentNodeValue)){
                prevNode.next = currentNode.next;
                prevNode = currentNode.next;
                currentNode = currentNode.next.next;

            } else {
                buffer.add(currentNodeValue);
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    /**
     * remove duplicates without buffer
     *
     * Time complexity is O(n^2)
     * Space complexity is  O(1)
     *
     * @param head
     * @return
     */
    public Node removeDuplicateWithoutBuffer(Node head){

        Node innerNode = head;

        while (innerNode != null){

            Node outerNode = innerNode.next;
            Node prevNode = innerNode;

            while (outerNode != null){
                if (innerNode.value == outerNode.value){
                      prevNode.next = outerNode.next;
                    outerNode = outerNode.next;
                } else {
                    prevNode = outerNode;
                    outerNode = outerNode.next;
                }
            }
            innerNode = innerNode.next;
        }
        return head;
    }
}

