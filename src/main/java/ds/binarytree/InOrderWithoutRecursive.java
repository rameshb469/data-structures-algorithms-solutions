package ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Inorder traversal without recursive method
 */
public class InOrderWithoutRecursive {

    /**
     * 1) Create an empty stack S.
     * 2) Initialize current node as root
     * 3) Push the current node to S and set current = current->left until current is NULL
     * 4) If current is NULL and stack is not empty then
     *      a) Pop the top item from stack.
     *      b) Print the popped item, set current = popped_item->right
     *      c) Go to step 3.
     * 5) If current is NULL and stack is empty then we are done.
     *
     * @param root
     * @return
     */
    public static List<Integer> inOrder(BinaryTree root){

        List<Integer> rs = new ArrayList<>();
        BinaryTree current = root;
        Stack<BinaryTree> stack = new Stack<>();

        // traverse the tree
        while (current != null && !stack.isEmpty()){

            /* Reach the left most Node of the
            curr Node */
            while (current != null){

                 /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree
                  */
                stack.add(current);
                current = current.left;
            }

            /* Current must be NULL at this point */
            current = stack.pop();
            rs.add(current.value);
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            current = current.right;
        }

        return rs;
    }
}
