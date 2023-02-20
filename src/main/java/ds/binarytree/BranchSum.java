package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Branch Sums</h1>
 * <p>
 * Write a function that takes in a Binary Tree and returns a list of its branch
 * sums ordered from leftmost branch sum to rightmost branch sum.
 * </p>
 * <p>
 * A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
 * branch is a path of nodes in a tree that starts at the root node and ends at
 * any leaf node.
 * </p>
 * <p>
 * Each <span>BinaryTree</span> node has an integer <span>value</span>, a
 * <span>left</span> child node, and a <span>right</span> child node. Children
 * nodes can either be <span>BinaryTree</span> nodes themselves or
 * <span>None</span> / <span>null</span>
 * <h3>Sample Input</h3>
 * <pre><span>tree</span> =
 *            1
 *         /     \
 *        2       3
 *      /   \    /  \
 *     4     5  6    7
 *   /   \  /
 *  8    9 10
 * </pre>
 * </p>
 * <pre>[15, 16, 18, 10, 11]
 * <span>// 15 == 1 + 2 + 4 + 8</span>
 * <span>// 16 == 1 + 2 + 4 + 9</span>
 * <span>// 18 == 1 + 2 + 5 + 10</span>
 * <span>// 10 == 1 + 3 + 6</span>
 * <span>// 11 == 1 + 3 + 7</span>
 * </pre>
 * <h3>Hints</h3>
 * <ul>
 *     <li>Try traversing the Binary Tree in a depth-first-search-like fashion.</li>
 *     <li> Recursively traverse the Binary Tree in a depth-first-search-like fashion,
 *                                      and pass a running sum of the values of every previously-visited
 *                                      node to each node that you're traversing.</li>
 *     <li> As you recursively traverse the tree, if you reach a leaf node
 *                  (a node with no "left" or "right" Binary Tree nodes),
 *                  add the relevant running sum that you've calculated to a list of sums
 *                  (which you'll also have to pass to the recursive function).
 *                  If you reach a node that isn't a leaf node, keep recursively traversing its
 *                  children nodes, passing the correctly updated running sum to them.
 *     </li>
 * </ul>
 * <h4>Hint 1</h4>
 * <p>
 *     <Try traversing the Binary Tree in a depth-first-search-like fashion.
 * </p>
 * <h4>Hint 2<h4>
 */
public class BranchSum {

    /**
     * we will use recursive approach to solve the problem.
     *
     * @param root
     * @return
     */
    public static List<Integer> branchSum(BinaryTree root) {
        List<Integer> results = new ArrayList<>();
        branchSum(root, 0, results);
        return results;
    }

    /**
     * @param bt      The Binary tree
     * @param sum     node sum
     * @param results results for storing the sum
     */
    private static void branchSum(BinaryTree bt, int sum, List<Integer> results) {
        if (bt == null) return;
        sum += bt.value;

        /**
         * if leaf node then we will add sum to results
         */
        if (bt.left == null && bt.right == null) {
            results.add(sum);
            return;
        }

        branchSum(bt.left, sum, results);
        branchSum(bt.right, sum, results);
    }
}
