package ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import static ds.binarytree.LevelOrderTraverse.levelOrder;

/**
 * Given a binary tree, delete a node from it by making sure that the tree shrinks from the bottom
 * (i.e. the deleted node is replaced by the bottom-most and rightmost node).
 * This is different from BST deletion. Here we do not have any order among elements,
 * so we replace them with the last element.
 *
 *              10                                  30
 *           20    30  == deleting 10 ==>         20
 */
public class DeletingNodeBinaryTree {

    /**
     * To avoid the above error and also to avoid doing BFS twice (1st iteration while searching
     * the rightmost deepest node, and 2nd while deleting the rightmost deepest node),
     * we can store the parent node while first traversal and after setting the rightmost deepest node’s data
     * to the node needed deletion, easily delete the rightmost deepest node.
     *
     * @param root
     * @param value
     */
    public static BinaryTree deleteNode(BinaryTree root, int value){

       if (root == null) {
           return null;
       }

       if (root.left == null && root.right == null){
           return (root.value == value) ? null : root;
       }

       Queue<BinaryTree> queue = new LinkedList<>();
       queue.offer(root);
       BinaryTree keyNode = null, prevNode = null, lastNode = null;

       while (!queue.isEmpty()){
           lastNode = queue.poll();

           if (lastNode != null){
               if (lastNode.value == value) {
                   keyNode = lastNode;
               }

               if (lastNode.left != null){
                   prevNode = lastNode;
                   queue.offer(lastNode.left);
               }

               if (lastNode.right != null){
                   prevNode = lastNode;
                   queue.offer(lastNode.right);
               }
           }
       }

       if (keyNode != null){
            keyNode.value = lastNode.value;

            if (prevNode.left == lastNode){
                prevNode.left = null;
            } else {
                prevNode.right = null;
            }
       }

       return root;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(11);
        root.left.left = new BinaryTree(7);
        root.left.right = new BinaryTree(12);
        root.right = new BinaryTree(9);
        root.right.left = new BinaryTree(15);
        root.right.right = new BinaryTree(8);

        System.out.print("Inorder traversal "
                + "before deletion:");
        levelOrder(root).stream().forEach(System.out::println);

        int key = 11;
        deleteNode(root, key);

        System.out.print("\nInorder traversal "
                + "after deletion:");
        levelOrder(root).stream().forEach(System.out::println);
    }
}
