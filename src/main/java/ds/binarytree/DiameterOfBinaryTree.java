package ds.binarytree;

/**
 * The diameter/width of a tree is defined as the number of nodes on the longest path between two end nodes.
 *
 * The diagram below shows two trees each with a diameter of nine, the leaves that form
 * the ends of the longest path are shaded (note that there is more than one path in each tree
 * of length nine, but no path longer than nine nodes).
 */
public class DiameterOfBinaryTree {

    static int maxDepth = 0;

    public static int getDiameter(BinaryTree root){
        getMaxDepth(root);
        return maxDepth;
    }

    private static int getMaxDepth(BinaryTree root){

        if (root == null) return 0;

        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);

        maxDepth = Math.max(maxDepth, leftDepth+rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
