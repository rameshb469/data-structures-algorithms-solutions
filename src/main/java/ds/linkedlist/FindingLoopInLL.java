package ds.linkedlist;


/**
 * <p>
 * Write a function that takes in the head of a Singly Linked List that contains
 * a loop (in other words, the list's tail node points to some node in the list
 * instead of <span>None</span> / <span>null</span>). The function should return
 * the node (the actual node--not just its value) from which the loop originates
 * in constant space.
 * </p>
 *
 * <p>
 * Each <span>LinkedList</span> node has an integer <span>value</span> as well as
 * a <span>next</span> node pointing to the next node in the list.
 * </p>
 *
 * <pre><span class="CodeEditor-promptParameter">head</span> = 0 -&gt; 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6 <span class="CodeEditor-promptComment">// the head node with value 0</span>
 *                            ^         v
 *                            9 &lt;- 8 &lt;- 7
 * </pre>
 * <h3>Sample Output</h3>
 * <pre>4 -&gt; 5 -&gt; 6 <span class="CodeEditor-promptComment">// the node with value 4</span>
 * ^         v
 * 9 &lt;- 8 &lt;- 7
 * </pre>
 */
public class FindingLoopInLL {

    /**
     * <pre><span class="CodeEditor-promptParameter">head</span> = 0 -&gt; 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 -&gt; 6 <span class="CodeEditor-promptComment">// the head node with value 0</span>
     *                            ^         v
     *                            9 &lt;- 8 &lt;- 7
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>4 -&gt; 5 -&gt; 6 <span class="CodeEditor-promptComment">// the node with value 4</span>
     * ^         v
     * 9 &lt;- 8 &lt;- 7
     * </pre>
     */
    public static Node findLoop(Node head) {
        Node slowPointer = head.next;
        Node fastPointer = head.next.next;

        while (slowPointer != fastPointer) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        fastPointer = head;
        while (fastPointer != slowPointer) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        return fastPointer;
    }


}
