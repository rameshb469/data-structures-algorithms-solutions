package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * check given two nodes are cousins or not
 */
public class TwoNodesAreCousin {

    public static boolean isCousins(BinaryTree root, int x, int y){

        if (root == null || root.value ==  x || root.value == y) return false;

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        BinaryTree xParent = null;
        BinaryTree yParent = null;

        int xHeight = -1, yHeight = -1;
        int currentHeight = -1;
        while (!queue.isEmpty()) {
            currentHeight++;
            for (int i = 0; i < queue.size(); i++) {
                BinaryTree currentNode = queue.poll();
                if (currentNode.left != null) {
                    if (currentNode.left.value != x || currentNode.left.value != y) {
                        queue.offer(currentNode.left);
                    } else if (currentNode.left.value == x) {
                        xParent = currentNode;
                        xHeight = currentHeight;
                    } else {
                        yHeight = currentHeight;
                        yParent = currentNode;
                    }
                }

                if (currentNode.right != null){
                    if (currentNode.right.value != x || currentNode.right.value != y) {
                        queue.offer(currentNode.right);
                    } else if (currentNode.right.value == x) {
                        xParent = currentNode;
                        xHeight = currentHeight;
                    } else if (currentNode.right.value == y){
                        yParent = currentNode;
                        yHeight = currentHeight;
                    }
                }

            }

        }

        return (xHeight ==  yHeight && xParent != null);
    }
}
