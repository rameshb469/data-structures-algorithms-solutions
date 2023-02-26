package ds.binarytree;

/**
 * <h1>Sum Tree</h1>
 *
 * Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and the sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 *
 * Following is an example of SumTree.
 *
 *           26
 *         /   \
 *       10     3
 *     /    \     \
 *   4      6      3
 */
public class SumTree {


    /**
     *
     * @param root
     * @return
     */
    public static int isSumTree(BinaryTree root){

        if (root == null) return 1;

        if (root.left == null && root.right == null) return 1;

        return sumTree(root);
    }

    private static boolean isleaf(BinaryTree node){
        if (node == null) return false;

        if (node.left == null && node.right == null) return true;

        else return false;
    }
    private static int sumTree(BinaryTree node) {

        if (node == null) return 0;

        int left = sumTree(node.left);
        if (left == -1) return -1;

        int right = sumTree(node.right);
        if (right == -1 ) return -1;

        int data = node.value;

        /**
         * we shouldn't consider the leafs of BT
         */
        return  (data == left+right || isleaf(node)) ? (data+left+right) : -1;
    }

    public static void main(String[] args) {

    }
}
