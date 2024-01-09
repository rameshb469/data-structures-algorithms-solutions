package ds.bst;

import ds.binarytree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution to construct Balanced BST.
 *
 * By using this solution we can convert skew BST to balanced BST
 *
 * Input:
 *          4
 *         /
 *        3
 *       /
 *      2
 *     /
 *    1
 * Output:
 *       3            3           2
 *     /  \         /  \        /  \
 *    1    4   OR  2    4  OR  1    3   OR ..
 *     \          /                   \
 *      2        1                     4
 *
 */
public class ConstructingBalancedBST {


    /**
     * Convert to Skew BST to Balanced BST with minimum height
     *
     * <ul>
     *     <li>First store elements in in-order traversal</li>
     *     <li>Build a balanced BST from the above created sorted array using the recursive approach discussed here</li>
     * </ul>
     *
     * Input:
     *           4
     *         /   \
     *        3     5
     *       /       \
     *      2         6
     *     /           \
     *    1             7
     * Output:
     *        4
     *     /    \
     *    2      6
     *  /  \    /  \
     * 1    3  5    7
     *
     * @param tree
     * @return
     */
    public static BinaryTree buildBalancedBST(BinaryTree tree) {

        List<Integer> values = new ArrayList<>();
        inorderTraversal(tree, values);
        int[] array = values.stream().mapToInt(i->i).toArray();
        return buildBalancedBST(array, 0, array.length-1);
    }

    private static BinaryTree buildBalancedBST(int[] array, int start, int end) {

        if (start > end) return  null;

        int mid = (start + end) / 2;

        BinaryTree tree = new BinaryTree(array[mid]);

        tree.left = buildBalancedBST(array, start, mid-1);
        tree.right = buildBalancedBST(array, mid+1, end);

        return tree;
    }

    /**
     * in order traversals
     * @param tree
     * @param values
     */
    private static void inorderTraversal(BinaryTree tree, List<Integer> values) {

        if (tree == null) return;

        if (tree.left != null) inorderTraversal(tree.left, values);
        values.add(tree.value);
        if (tree.right != null) inorderTraversal(tree.right, values);
    }
}
