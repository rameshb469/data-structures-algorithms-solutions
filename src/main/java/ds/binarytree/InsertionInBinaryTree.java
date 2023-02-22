package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h1>Insertion in a Binary Tree in level order</h1>
 * The idea is to do an iterative level order traversal of the given tree using queue.
 * If we find a node whose left child is empty, we make a new key as the left child of the node.
 * Else if we find a node whose right child is empty, we make the new key as the right child.
 * We keep traversing the tree until we find a node whose either left or right child is empty.
 *
 * Inserting 12
 *
 *          10                              10
 *     11        9       ==>        11              9
 *   7         15   8           7      12       15      8
 *
 *
 * //
 */
public class InsertionInBinaryTree {

    public void insertLevelOrder(BinaryTree root, int value){

        if (root == null) {
            root = new BinaryTree(value);
            return;
        }

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BinaryTree tempNode = queue.poll();

            if (tempNode.left == null){
                tempNode.left = new BinaryTree(value);
                return;
            } else {
                queue.add(tempNode.left);
            }

            if (tempNode.right == null){
                tempNode.right = new BinaryTree(value);
                return;
            } else {
                queue.add(tempNode.right);
            }
        }
    }
}
