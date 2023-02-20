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
}
