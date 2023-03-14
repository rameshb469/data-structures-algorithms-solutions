package ds.bst;

import ds.binarytree.BinaryTree;

/**
 * <h1>Binary Search Tree Operations</h1>
 * <ul>
 *     <li>Inserting of New Node</li>
 *     <li>Searching the an existing Node</li>
 *     <li>Deleting the existing Node</li>
 * </ul>
 */
public class BSTOperations {

    /**
     * Adding new node to {@link BinaryTree}
     *
     * @param root Root node of BST
     * @param key  The value of element
     * @return return root node of BST
     */
    public static BinaryTree add(BinaryTree root, int key) {
        // we will add the new node to leaf
        // if key > node value then move right
        // if key < node value then move left

        if (root == null) {
            root = new BinaryTree(key);
            return root;
        } else if (root.value > key) {
            root.left = add(root.left, key);
        } else if (root.value < key) {
            root.right = add(root.right, key);
        }

        return root;
    }


    /**
     * Searching element from given BST
     *
     * @param root The Root node of BST
     * @param key  The element we need to search
     * @return return node if it found, otherwise return null;
     */
    public static BinaryTree search(BinaryTree root, int key) {

        if (root == null || root.value == key)
            return root;

        else if (root.value > key)
            root.left = search(root.left, key);

        else
            root.right = search(root.right, key);

        return null;
    }


    /**
     * Delete an existing key from Binary Search Tree (BST)
     *
     * @param root The Root node of BST
     * @param key  the element need to delete it
     * @return The Root node of BST
     */
    public static BinaryTree delete(BinaryTree root, int key) {

        if (root == null)
            return null;

        else if (root.value > root.value) {
            root.left = delete(root.left, key);
        } else // if any one of node is empty
            if (root.value < root.value) {
                root.right = delete(root.right, key);
            } else if (root.left == null)
                return root.right;

            else if (root.right == null)
                return root.left;

            else {
                // If both node are not  null then
                // find the successor of BST
                // mean find min value  from right subtree
                int minValue = getMin(root.right);
                root.value = minValue;
                root.right = delete(root.right, minValue);
            }

        return root;
    }

    /**
     * Get minimum value from given BST
     *
     * @param bst Binary Search Tree Node
     * @return minimum value of given BST
     */
    private static int getMin(BinaryTree bst) {

        int minValue = bst.value;

        while (bst != null) {
            minValue = bst.value;
            bst = bst.left;
        }
        return minValue;
    }
}
