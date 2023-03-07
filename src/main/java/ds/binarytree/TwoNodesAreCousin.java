package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * check given two nodes are cousins or not
 */
public class TwoNodesAreCousin {

    public static boolean isCousins(BinaryTree root, int x, int y){
        if (root == null) return false;

        if (root.left == null || root.right == null) return false;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTree xParent = null, yParent = null;
        int xHeight = -1, yHeight = -1, currentHeight = -1;

        /**
         * use level order traversal for finding height and parent
         *
         * if cousins, the node must be different parents and height must be same
         */
        while (!queue.isEmpty()) {
            currentHeight++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree current = queue.poll();

                if (current.left != null){
                    if (current.left.value != x && current.left.value != y){
                        queue.offer(current.left);
                    } else if (current.left.value == x) {
                        xParent = current;
                        xHeight = currentHeight;
                    } else {
                        yParent = current;
                        yHeight = currentHeight;
                    }
                }

                if (current.right != null){
                    if (current.right.value != x && current.right.value != y) {
                        queue.offer(current.right);
                    } else if (current.right.value == x) {
                        xParent = current;
                        xHeight = currentHeight;
                    } else {
                        yParent = current;
                        yHeight = currentHeight;
                    }
                }
            }
        }

        return (xHeight == yHeight && xParent != yParent) ? true : false;
    }
}
