package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Class contains all solution of  linked list.
 */
public class LinkedListSolutions {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(4);
        node.next.next.next = new Node(5);
        node.next.next.next.next = new Node(5);
        printNode(node);
        removeSortedNodesDuplicatesWithoutExtraSpace(node);
        System.out.println("After removing duplicate values");
        printNode(node);
    }

    static void printNode(Node node){
        while (node != null){
            System.out.println(node.value+"-->");
            node = node.next;
        }
    }

    /**
     * Remove duplicates from unsorted linked list
     * Brute force approach
     *
     * Time complexity O(n)
     * Space complexity O(n)
     * @param node
     */
    public static void removeDuplicates(Node node){
        // Create a list for storing the data
        Set<Integer> values = new HashSet<>();
        Node prevNode = null;
        while (node != null){

            //checking the node value existing in values
            if (values.contains(node.value)){
                prevNode.next = node.next;
            } else {
                prevNode = node;
                values.add(node.value);
            }
            node = node.next;
        }
    }

    /**
     * Removed duplicate nodes without using extra space
     *
     * Time complexity O(n^2)
     * Space complexity O(1)
     *
     * @param node
     */
    void removeDuplicatesWithoutExtraSpace(Node node){
        Node currentNode = node;
        while (currentNode != null){
            Node runnerNode = currentNode;
            while (runnerNode.next != null){
                if (runnerNode.next.value == currentNode.value){
                    runnerNode.next = runnerNode.next.next;
                }else {
                    runnerNode.next = runnerNode.next.next;
                }
            }
            currentNode = null;
        }
    }

    /**
     * Removed duplicate nodes from sorted linked list
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     * @param node Sorted linked list
     */
    static void removeSortedNodesDuplicatesWithoutExtraSpace(Node node){
        // 1 -> 1 -> 2 -> 3 -> 3 -> 4 -> 5
        while (node != null){
            // find the distinct node and link it.
            Node distinctNode = node.next;
            while (distinctNode != null && distinctNode.value == node.value){
                distinctNode = distinctNode.next;
            }
            // assign next as distinct node
            node.next = distinctNode;
            // update the pointer to distinct node
            node = distinctNode;
        }
    }
}
