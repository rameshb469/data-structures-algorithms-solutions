package ds.binarytree;

/**
 * Binary Tree class
 */
public class BinaryTree {

    public int value;

    /**
     * left node
     */
    public BinaryTree left;

    /**
     * right node
     */
    public BinaryTree right;

    public BinaryTree(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Sample data for Binary Tree
     * @return
     */
    public static BinaryTree getBinaryTree(){
        BinaryTree tree = new BinaryTree(1);
        BinaryTree left = tree.left = new BinaryTree(2);
        BinaryTree right = tree.right = new BinaryTree(3);
        left.left = new BinaryTree(4);
        left.right = new BinaryTree(5);
        right.left = new BinaryTree(6);
        right.right = new BinaryTree(7);
        right.right.left = new BinaryTree(8);
        right.right.right = new BinaryTree(9);

        return tree;
    }
}
