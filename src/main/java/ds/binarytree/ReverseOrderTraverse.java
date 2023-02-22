package ds.binarytree;

import java.util.*;

/**
 * Given a binary tree of size N, find its reverse level order traversal.
 * ie- the traversal must begin from the last level.
 * <p>
 * Example 1:
 * <p>
 * Input :
 * 1
 * /   \
 * 3     2
 * <p>
 * Output: 3 2 1
 * Explanation:
 * Traversing level 1 : 3 2
 * Traversing level 0 : 1
 * <p>
 * Example 2:
 * <p>
 * Input :
 * 10
 * /  \
 * 20   30
 * / \
 * 40  60
 * <p>
 * Output: 40 60 20 30 10
 * Explanation:
 * Traversing level 2 : 40 60
 * Traversing level 1 : 20 30
 * Traversing level 0 : 10
 */
public class ReverseOrderTraverse {

    /**
     * using queue and stack we can do this
     * <p>
     * Time complexity O(n)
     * Space complexity O(n)
     *
     * @param node
     * @return
     */
    public List<Integer> reverseLevelOrder(BinaryTree node) {
        List<Integer> results = new ArrayList<>();
        /**
         * storing the nodes
         */
        Queue<BinaryTree> queue = new LinkedList<>();
        /**
         * storing the values in reverse order
         */
        Stack<Integer> values = new Stack<>();
        queue.offer(node);

        while (!queue.isEmpty()) {

            BinaryTree tempNode = queue.poll();
            if (tempNode != null){
                values.add(tempNode.value);

                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }

                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
            }
        }

        if (!values.isEmpty()){
            results.add(values.pop());
        }
        return results;
    }

}
