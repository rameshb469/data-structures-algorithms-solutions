package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Example:
 *
 * Input:
 *         10
 *      /      \
 *    20       30
 *   /  \        \
 *  40   50      70
 *
 * Data Array (Contains preorder traversal)
 * 10 20 40 50 30 70
 *
 * Structure Array
 * 1 1 1 0 0 1 0 0 1 0 1 0 0
 * 1 indicates data and 0 indicates NULL
 *
 */
public class SuccinctEncoding {

    public static void succinctEncoding(BinaryTree root){
        List<Integer> values = new ArrayList<>();
        List<Boolean> order = new ArrayList<>();

        if (root != null){
            succinctEncoding(root, values, order);
        }

        for (Integer value : values) System.out.print(value+" -->");
        System.out.println();
        for (Boolean or : order) System.out.print(or+"-->");
    }

    public static void succinctEncoding(BinaryTree node,
                                        List<Integer> values,
                                        List<Boolean> order) {
        if (node == null) {
            values.add(null);
            order.add(false);
        } else {
            values.add(node.value);
            order.add(true);

            if (node.left != null) {
                succinctEncoding(node.left, values, order);
            } else {
                values.add(null);
                order.add(false);
            }

            if (node.right != null){
                succinctEncoding(node.right, values, order);
            } else {
                values.add(null);
                order.add(false);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(6);
        tree.left.left = new BinaryTree(5);
        tree.left.right = new BinaryTree(9);
        tree.right.left = new BinaryTree(6);

        succinctEncoding(tree);
    }
}
