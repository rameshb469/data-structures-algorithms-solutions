package ds.linkedlist;

/**
 * This class contains solution of removing duplicate from sorted linked list
 */
public class RemovingDuplicateInSortedLL {

    /**
     * Removing the  duplicates from sorted linked list
     *
     * @param head linked list head node
     * @return linked list with head node
     */
    public static Node removeDuplicates(Node head){
        Node currentNode = head;

        while (currentNode != null){

            Node distinctNode = currentNode.next;

            if (distinctNode != null && distinctNode.value == currentNode.value){
                distinctNode = distinctNode.next;
            }

            currentNode.next = distinctNode;
            currentNode = distinctNode;
        }

        return head;
    }
}
