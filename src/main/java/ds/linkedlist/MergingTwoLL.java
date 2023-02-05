package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static ds.linkedlist.Node.print;

/**
 * <h1>Merging Linked Lists</h1>
 * <div class="TLQjVhfBX4gHWkO9qYsJ ae-workspace-dark"><div class="html">
 *   <p>
 *     You're given two Linked Lists of potentially unequal length. These Linked
 *     Lists potentially merge at a shared intersection node. Write a function
 *     that returns the intersection node or returns <span>None</span> /
 *     <span>null</span> if there is no intersection.
 *   </p>
 *   <p>
 *     Each <span>LinkedList</span> node has an integer <span>value</span> as well as
 *     a <span>next</span> node pointing to the next node in the list or to
 *     <span>None</span> / <span>null</span> if it's the tail of the list.
 *   </p>
 *   <p>
 *     Note: Your function should return an existing node. It should not modify
 *     either Linked List, and it should not create any new Linked Lists.
 *   </p>
 *   <h3>Sample Input</h3>
 * <pre><span class="CodeEditor-promptParameter">linkedListOne</span> = 2 -&gt; 3 -&gt; 1 -&gt; 4
 * <span class="CodeEditor-promptParameter">linkedListTwo</span> = 8 -&gt; 7 -&gt; 1 -&gt; 4
 * </pre>
 *   <h3>Sample Output</h3>
 * <pre>1 -&gt; 4 <span class="CodeEditor-promptComment">// The lists intersect at the node with value 1</span>
 * </pre>
 *   </div></div>
 *   <div class="ubkRh609gZAKC63eyoHt"><h3 class="vygxGX6EU5SRulNpPyt2">Hints</h3><div class="bkkMG8fczzJ203ky4pHV"><div class="
 *       m9qHEqW419vul78Ks_N4
 *       g48zh7pepCprgQNnhjYR
 *       wQOwj_AqZQK44GJW1N0E
 *       " tabindex="0"><div class="
 *       kDoyoLEgMLE4k325vN3f
 *       undefined
 *       j_lw6dN2omYx5lZJ8ABZ
 * <p>
 *       lVJy_CZchkfIT7EoMqL7"><div class="I58Rrhf2fmpCKtHv9Zj9">Hint 1</div><svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" xml:space="preserve" class="IRK2SKMnxjFj8TmtU5p0 "><path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path></svg></div><div class="wydVeRqMMtvFhbtm0Oda " style="transition: height 400ms linear 0s; height: 0px;"><div class="ya7hOTvkcvOlBTsWTi3l"><div class="U1quNvMraAr3Hbq2JfVQ"><p>
 *   All of the nodes after the intersection point of two Linked Lists will be the
 *   same.
 * </p>
 * </div></div></div></div></div><div class="bkkMG8fczzJ203ky4pHV"><div class="
 *       m9qHEqW419vul78Ks_N4
 *       g48zh7pepCprgQNnhjYR
 *       wQOwj_AqZQK44GJW1N0E
 *       " tabindex="0"><div class="
 *       kDoyoLEgMLE4k325vN3f
 *       undefined
 *       j_lw6dN2omYx5lZJ8ABZ
 * <p>
 *       lVJy_CZchkfIT7EoMqL7"><div class="I58Rrhf2fmpCKtHv9Zj9">Hint 2</div><svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" xml:space="preserve" class="IRK2SKMnxjFj8TmtU5p0 "><path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path></svg></div><div class="wydVeRqMMtvFhbtm0Oda " style="transition: height 400ms linear 0s; height: 0px;"><div class="ya7hOTvkcvOlBTsWTi3l"><div class="U1quNvMraAr3Hbq2JfVQ">
 * <p>
 *   If the two Linked Lists are of different lengths, then none of the extra nodes
 *   of the longer list at the beginning can be the intersection point, since the
 *   ends must be the same.
 * </p>
 * </div></div></div></div></div><div class="bkkMG8fczzJ203ky4pHV"><div class="
 *       m9qHEqW419vul78Ks_N4
 *       g48zh7pepCprgQNnhjYR
 *       wQOwj_AqZQK44GJW1N0E
 *       " tabindex="0"><div class="
 *       kDoyoLEgMLE4k325vN3f
 *       undefined
 *       j_lw6dN2omYx5lZJ8ABZ
 * <p>
 *       lVJy_CZchkfIT7EoMqL7"><div class="I58Rrhf2fmpCKtHv9Zj9">Hint 3</div><svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" xml:space="preserve" class="IRK2SKMnxjFj8TmtU5p0 "><path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path></svg></div><div class="wydVeRqMMtvFhbtm0Oda " style="transition: height 400ms linear 0s; height: 0px;"><div class="ya7hOTvkcvOlBTsWTi3l"><div class="U1quNvMraAr3Hbq2JfVQ">
 * <p>
 *   The length of the first list + the distance of the second head from the
 *   intersection point will be equal to the length of the second list + the
 *   distance of the first head from the intersection point. This can be proven
 *   using the information from hints 1 and 2.
 * </p></div></div></div></div></div>
 * <div >
 *     <div tabindex="0">
 *         <div>
 *             <div class="I58Rrhf2fmpCKtHv9Zj9">Optimal Space &amp; Time Complexity</div>
 *                  <div>O(n + m) time | O(1) space - where n is the length of the first Linked List, and m is the length of the second Linked List</div>
 *              </div>
 *            </div>
 *       </div>
 *   </div>
 * </div>
 */
public class MergingTwoLL {

    /**
     * Time complexity is O(m+n)
     * Space complexity is O(m) or O(n)
     *
     * Where m and n are length of linked lists
     *
     * @param linkedListOne
     * @param linkedListTwo
     * @return
     */
    public static Node mergingLinkedListWithBuffer(Node linkedListOne,
                                                   Node linkedListTwo){
        Node currentNodeOne = linkedListOne;
        Set<Integer> values = new HashSet<>();

        while (currentNodeOne != null){
            values.add(currentNodeOne.value);
            currentNodeOne = currentNodeOne.next;
        }

        Node currentNodeTwo = linkedListTwo;
        while (currentNodeTwo != null){
            if (values.contains(currentNodeTwo.value)){
                return currentNodeTwo;
            }
            currentNodeTwo = currentNodeTwo.next;
        }

        return null;
    }


    /**
     * Time complexity is O(m+n)
     * Space complexity is O(1)
     *
     * @param linkedListOne
     * @param linkedListTwo
     * @return
     */
    public static Node mergingLinkedLists(Node linkedListOne,
                                          Node linkedListTwo) {

        Node currentNodeOne = linkedListOne;
        int lengthOfNodeOne = 0;

        while (currentNodeOne != null) {
            lengthOfNodeOne++;
            currentNodeOne = currentNodeOne.next;
        }

        Node currentNodeTwo = linkedListTwo;
        int lengthOfNodeTwo = 0;

        while (currentNodeTwo != null) {
            lengthOfNodeTwo++;
            currentNodeTwo = currentNodeTwo.next;
        }

        int difference = lengthOfNodeTwo - lengthOfNodeOne;

        Node biggerNode = null;
        Node smallerNode = null;

        if (difference > 0) {
            biggerNode = linkedListTwo;
            smallerNode = linkedListOne;
        } else {
            biggerNode = linkedListOne;
            smallerNode = linkedListTwo;
        }

        for (int i = Math.abs(difference); i > 0; i--) {
            biggerNode = biggerNode.next;
        }

        while (biggerNode != null && smallerNode != null) {
            if (biggerNode.value == smallerNode.value) {
                return biggerNode;
            }
            biggerNode = biggerNode.next;
            smallerNode = smallerNode.next;
        }

        return null;
    }

    /**
     * Time complexity is O(m+n)
     * Space complexity is O(1)
     *
     * @param linkedListOne
     * @param linkedListTwo
     * @return
     */
    public static Node mergingLinkedLists2(Node linkedListOne,
                                           Node linkedListTwo) {
        Node currentNodeOne = linkedListOne;
        Node currentNodeTwo = linkedListTwo;

        if(currentNodeOne != currentNodeTwo){
            currentNodeOne = (currentNodeOne == null) ? linkedListTwo : currentNodeOne.next;
            currentNodeTwo = (currentNodeTwo == null) ? linkedListOne : currentNodeTwo.next;
        }
        return currentNodeOne;
    }

    public static void main(String[] args) {
        Node linkedListOne = new Node(1);
        linkedListOne.next = new Node(2);
        linkedListOne.next.next = new Node(3);
        linkedListOne.next.next.next = new Node(4);

        Node linkedListTwo = new Node(5);
        linkedListTwo.next = new Node(3);
        linkedListTwo.next.next = new Node(4);

        print(mergingLinkedLists2(linkedListOne, linkedListTwo));
        System.out.println();
        print(mergingLinkedListWithBuffer(linkedListOne, linkedListTwo));
        System.out.println();
        print(mergingLinkedLists(linkedListOne, linkedListTwo));

    }
}
