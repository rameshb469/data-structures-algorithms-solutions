package ds.binarytree;

import ds.linkedlist.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Maximum depth or height of Binary tree
 */
public class MaxDepthOfBinaryTree {

    /**
     * Calculate max depth of tree using recursively
     * <p>
     * max_depth = max(max dept of left subtree,  max depth of right subtree) + 1
     * <p>
     * Time complexity is O(n)
     * Space complexity is O(n)
     *
     * @param tree
     * @return
     */
    public static int maxDepth(BinaryTree tree) {

        if (tree == null) {
            return 0;
        } else {
            return Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
        }


    }

    /**
     * This method also uses the concept of Level Order Traversal but we wont be adding null in the Queue.
     * Simply increase the counter when the level increases and push the children of current node into
     * the queue, then remove all the nodes from the queue of the current Level.
     *
     * @param tree {@link BinaryTree}
     */
    public static int maxDepthWithQueue(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);
        int height = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree tempNode = queue.poll();

                if (tempNode.left != null){
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null){
                    queue.add(tempNode.right);
                }
            }
            height++;
        }
        return height;
    }

    /**
     * Follow the below steps to Implement the idea:
     *
     * Traverse the tree in level order traversal starting from root.
     * Initialize an empty queue Q, a variable depth and push root, then push null into the Q.
     * Run a while loop till Q is not empty.
     * Store the front element of Q and Pop out the front element.
     * If the front of Q is NULL then increment depth by one and if queue is not empty then push NULL into the Q.
     * Else if the element is not NULL then check for its left and right children and if they are not NULL push them into Q.
     * Return depth.
     * 
     * @param tree
     * @return
     */
    public static int maxDepthWithQueueNull(BinaryTree tree){
       Queue<BinaryTree> queue = new LinkedList<>();
       queue.add(tree);
       queue.add(null);
       int depth = 0;
       
       while (!queue.isEmpty()){
           BinaryTree tempNode = queue.poll();
           if (tempNode == null) {
               depth++;
           }

           if (tempNode != null){
               if (tempNode.left != null){
                   queue.add(tempNode.left);
               }

               if (tempNode.right != null){
                   queue.add(tempNode.right);
               }
           } else if (!queue.isEmpty()) {
               queue.add(null);
           }
       }
       return depth;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);

        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);

        System.out.println("Height(Depth) of tree is: "
                + maxDepth(root));
        System.out.println("Height(Depth) of tree is: "
                + maxDepthWithQueue(root));

        System.out.println("Height(Depth) of tree is: "
                + maxDepthWithQueueNull(root));
    }
}
