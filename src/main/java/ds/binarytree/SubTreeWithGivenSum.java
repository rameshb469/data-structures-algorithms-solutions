package ds.binarytree;

/**
 * You are given a binary tree and a given sum. The task is to check if there exists a subtree
 * whose sum of all nodes is equal to the given sum.
 * <p>
 * 1
 * /    \
 * 3        6
 * /   \       \
 * 5     9       6
 * /
 * 8
 * <p>
 * Examples :
 * <p>
 * // For above tree
 * Input : sum = 17
 * Output: Yes
 * // sum of all nodes of subtree {3, 5, 9} = 17
 * Input : sum = 11
 * Output: No
 * // no subtree with given sum exist
 */
public class SubTreeWithGivenSum {

    /**
     * Checking given sum existing in the sub-tree
     *
     * @param root the root of binary tree
     * @param sum  The given sum
     * @return true if present, otherwise return false
     */
    public static boolean sumOfSubtree(BinaryTree root, int sum) {
        if (root == null) return false;

        int currentSum = root.value + ((root.left != null) ? root.left.value : 0)
                + ((root.right != null) ? root.right.value : 0);

        if (sum == currentSum) return true;

        return sumOfSubtree(root.left, sum) || sumOfSubtree(root.right, sum);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(6);
        tree.left.left = new BinaryTree(5);
        tree.left.right = new BinaryTree(9);
        tree.right.left = new BinaryTree(6);

        System.out.println(sumOfSubtree(tree, 17));
        System.out.println(sumOfSubtree(tree, 12));
        System.out.println(sumOfSubtree(tree, 11));
    }
}
