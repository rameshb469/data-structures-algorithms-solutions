package ds.linkedlist;

import static ds.linkedlist.Node.print;

/**
 * <h2>Merge Linked Lists</h2>
 *
 * <p>
 * Write a function that takes in the heads of two Singly Linked Lists that are
 * in sorted order, respectively. The function should merge the lists in place
 * (i.e., it shouldn't create a brand new list) and return the head of the merged
 * list; the merged list should be in sorted order.
 * </p>
 *
 * <p>
 * Each <span>LinkedList</span> node has an integer <span>value</span> as well as
 * a <span>next</span> node pointing to the next node in the list or to
 * <span>None</span> / <span>null</span> if it's the tail of the list.
 * </p>
 *
 * <p>
 * You can assume that the input linked lists will always have at least one node; in other
 * words, the heads will never be <span>None</span> / <span>null</span>.
 * </p>
 *
 * <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">headOne</span> = 2 -&gt; 6 -&gt; 7 -&gt; 8 <span class="CodeEditor-promptComment">// the head node with value 2</span>
 * <span class="CodeEditor-promptParameter">headTwo</span> = 1 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 9 -&gt; 10 <span class="CodeEditor-promptComment">// the head node with value 1</span>
 * </pre>
 *
 * <h3>Sample Output</h3>
 * <pre>1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6 -&gt; 7 -&gt; 8 -&gt; 9 -&gt; 10 <span class="CodeEditor-promptComment">// the new head node with value 1</span>
 * </pre>
 */
public class MergingTwoSortedLL {

    /**
     * Merging two nodes and create a new linked list
     * <p>
     * Time complexity is O(n)
     * Space complexity is O(n)
     *
     * @param headOne first Linked list head
     * @param headTwo second linked list head
     * @return merged linked list
     */
    public static Node mergeLinkedListsWithNewNode(Node headOne, Node headTwo) {

        Node resultNode = new Node(1);
        Node tempNode = resultNode;

        while (headOne != null && headTwo != null) {
            if (headOne.value > headTwo.value) {
                tempNode.next = new Node(headTwo.value);
                headTwo = headTwo.next;
            } else {
                tempNode.next = new Node(headOne.value);
                headOne = headOne.next;
            }
            tempNode = tempNode.next;
        }

        if (headOne != null) {
            tempNode.next = headOne;
        }

        if (headTwo != null) {
            tempNode.next = headTwo;
        }

        return resultNode.next;
    }

    /**
     * Merging two nodes without creating a new linked list
     * <p>
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     * @param headOne first Linked list head
     * @param headTwo second linked list head
     * @return merged linked list
     */
    public static Node mergeLinkedLists(Node headOne, Node headTwo) {

        Node nodeOne = headOne;
        Node nodeTwo = headTwo;
        Node prevNode = null;

        while (nodeOne != null && nodeTwo != null){

            if (nodeOne.value < nodeTwo.value){
                prevNode = nodeOne;
                nodeOne = nodeOne.next;
            } else {
                if (prevNode != null){
                    prevNode.next = nodeTwo;
                }
                prevNode = nodeTwo;
                nodeTwo = nodeTwo.next;
                prevNode.next = nodeOne;
            }
        }

        if (nodeOne == null){
            prevNode.next = nodeTwo;
        }

        return (headOne.value < headTwo.value) ? headOne : headTwo;
    }

    public static void main(String[] args) {

//        headOne = 2 -> 6 -> 7 -> 8 // the head node with value 2
//        headTwo = 1 -> 3 -> 4 -> 5 -> 9 -> 10 // the head node with value 1
        Node linkedListOne = new Node(2);
        linkedListOne.next = new Node(6);
        linkedListOne.next.next = new Node(7);
        linkedListOne.next.next.next = new Node(8);

        Node linkedListTwo = new Node(1);
        linkedListTwo.next = new Node(3);
        linkedListTwo.next.next = new Node(4);
        linkedListTwo.next.next.next = new Node(5);
        linkedListTwo.next.next.next.next = new Node(9);
        linkedListTwo.next.next.next.next.next = new Node(10);

        print(mergeLinkedLists(linkedListOne, linkedListTwo));
    }
}