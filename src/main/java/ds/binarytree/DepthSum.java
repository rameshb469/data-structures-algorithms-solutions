package ds.binarytree;

public class DepthSum {

    public static int nodeDepths(BinaryTree root) {
       return nodeDepths(root, 0);
    }

    private static int nodeDepths(BinaryTree node, int sum){
        if (node == null) return 0;

        return sum + nodeDepths(node.left, sum+1) + nodeDepths(node.right, sum+1);
    }
}
