package ds.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MorrisTraversal {

    public static List<Integer> inOrder(BinaryTree root){
        List<Integer> results = new ArrayList<>();
        BinaryTree currentNode = root;

        while (currentNode != null) {

            if (currentNode.left ==null) {
                results.add(currentNode.value);
                currentNode = currentNode.right;
            } else {
                BinaryTree prevNode = currentNode.left;
                while (prevNode != null && prevNode != currentNode){
                    prevNode = prevNode.right;
                }

                if (prevNode.right == null){
                    prevNode.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    prevNode.right = null;
                    results.add(currentNode.value);
                    currentNode = currentNode.right;
                }
            }
        }

        return  results;
    }
}
