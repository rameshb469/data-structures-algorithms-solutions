package ds.bst;

import ds.binarytree.BinaryTree;

/**
 * Searching given key using iteration
 *
 */
public class SearchingKeyWithIteration {


    /**
     * Finding the given key in BST
     *
     * @param tree The Root node of BST
     * @param key The key we need to search
     * @return true if it found, otherwise return false
     */
    public static boolean iterativeSearch(BinaryTree tree, int key){

        while (tree != null) {

            if (tree.value > key) {
                tree = tree.left;
            } else if (tree.value < key) {
                tree = tree.right;
            } else
                return true;
        }

        return false;
    }

    public static BinaryTree insert(BinaryTree tree, int key) {

        if (tree == null) {
            tree = new BinaryTree(key);
            return tree;
        } else if (tree.value > key) {
            tree.left = insert(tree.left, key);
        } else if (tree.value < key) {
            tree.right = insert(tree.right, key);
        }

        return tree;
    }

    public static void main(String[] args) {
        BinaryTree root = null;
        root = insert(root, 50);
        insert(root, 30);
        insert(root, 20);
        insert(root, 40);
        insert(root, 70);
        insert(root, 60);
        insert(root, 80);
        if (iterativeSearch(root, 15))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
