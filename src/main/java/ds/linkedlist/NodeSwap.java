package ds.linkedlist;

/**
 * <h2>Node Swap<</h2>
 * <div class="TLQjVhfBX4gHWkO9qYsJ ae-workspace-dark"><div class="html">
 * <p>
 *   Write a function that takes in the head of a Singly Linked List, swaps every
 *   pair of adjacent nodes in place (i.e., doesn't create a brand new list), and
 *   returns its new head.
 * </p>
 * <p>
 *   If the input Linked List has an odd number of nodes, its final node should
 *   remain the same.
 * </p>
 * <p>
 *   Each <span>LinkedList</span> node has an integer <span>value</span> as well as
 *   a <span>next</span> node pointing to the next node in the list or to
 *   <span>None</span> / <span>null</span> if it's the tail of the list.
 * </p>
 * <p>
 *   You can assume that the input Linked List will always have at least one node;
 *   in other words, the head will never be <span>None</span> / <span>null</span>.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">head</span> = 0 -&gt; 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 <span class="CodeEditor-promptComment">// the head node with value 0</span>
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>1 -&gt; 0 -&gt; 3 -&gt; 2 -&gt; 5 -&gt; 4 <span class="CodeEditor-promptComment">// the new head node with value 1</span>
 * </pre>
 * </div></div>
 * <div class="html">
 * <p>
 *   Write a function that takes in the head of a Singly Linked List, swaps every
 *   pair of adjacent nodes in place (i.e., doesn't create a brand new list), and
 *   returns its new head.
 * </p>
 * <p>
 *   If the input Linked List has an odd number of nodes, its final node should
 *   remain the same.
 * </p>
 * <p>
 *   Each <span>LinkedList</span> node has an integer <span>value</span> as well as
 *   a <span>next</span> node pointing to the next node in the list or to
 *   <span>None</span> / <span>null</span> if it's the tail of the list.
 * </p>
 * <p>
 *   You can assume that the input Linked List will always have at least one node;
 *   in other words, the head will never be <span>None</span> / <span>null</span>.
 * </p>
 * <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">head</span> = 0 -&gt; 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 <span class="CodeEditor-promptComment">// the head node with value 0</span>
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>1 -&gt; 0 -&gt; 3 -&gt; 2 -&gt; 5 -&gt; 4 <span class="CodeEditor-promptComment">// the new head node with value 1</span>
 * </pre>
 * </div>
 */
public class NodeSwap {

    /**
     *
     * Time complexity is O(n)
     * Space complexity is O(1)
     *
     * @param head linked list head
     * @return
     */
    public Node nodeSwap(Node head) {

        Node currentNode = head;

        Node prevNode = null;
        while (currentNode != null && currentNode.next != null) {
            Node tempNode = currentNode.next;
            currentNode.next = tempNode.next;
            tempNode.next = currentNode;
            currentNode = currentNode.next;
        }

        return head;
    }
}
