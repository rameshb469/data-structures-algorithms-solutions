package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Binary Tree and a key, write a function that returns level of the key.
 *
 * For example, consider the following tree. If the input key is 3,
 * then your function should return 1. If the input key is 4, then your function should return 3.
 * And for key which is not present in key, then your function should return 0.
 *
 *           3
 *        /      \
 *      2         5
 *     /  \
 *    1   4
 */
public class LevelOfGivenNode {

    public static int getLevel(BinaryTree root, int key){

        if (root == null) return 0;

        if (root.value == key) return 1;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                BinaryTree currentNode =  queue.poll();

                if (currentNode.value == key) return level;

                if (currentNode.left != null) queue.offer(currentNode.left);

                if (currentNode.right != null) queue.offer(currentNode.right);
            }
        }

        return 0;
    }

}
