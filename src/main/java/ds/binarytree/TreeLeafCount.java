package ds.binarytree;

/**
 * Counting leafs
 */
public class TreeLeafCount {

    public static int leafCount(BinaryTree root){
         int count = 0;
        leafCount(root, 0);
        return count;
    }

    private static int leafCount(BinaryTree root, int count){
        if (root != null){
            if (root.left == null && root.right == null){
                count+=1;
                return count;
            } else {
                int lc =  (root.left != null)  ? leafCount(root.left, count) : 0;
                int rc = (root.right != null) ? leafCount(root.right, count) : 0;
                return lc+rc;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);

        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        System.out.println("Height(Depth) of tree is: "
                + leafCount(root));
    }
}
