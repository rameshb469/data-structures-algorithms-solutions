package ds.binarytree;

/**
 * Solution for finding size of Binary Tree
 */
public class SizeOfBinaryTree {

    /**
     * finding size of binary tree
     *
     * @param root The Binary Tree
     * @return size of Binary Tree
     */
    public static int getSize(BinaryTree root) {
        return getSize(root, 0);
    }

    public static int getSize(BinaryTree node, int currentSize) {

        if (node == null) return 0;

        return getSize(node.left) + 1 + getSize(node.right);
    }
}
