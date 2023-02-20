package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum depth or height of Binary tree
 */
public class MaxDepthOfBinaryTree {

    /**
     *
     * @param tree
     * @return
     */
    public static int maxDepth(BinaryTree tree){
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);
        int height = 0;

        while (!queue.isEmpty()){
            BinaryTree tempNode = queue.poll();

            if (tempNode != null){
                height++;
            }
        }
        return height;
    }
}
