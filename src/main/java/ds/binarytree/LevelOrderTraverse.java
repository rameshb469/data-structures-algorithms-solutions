package ds.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Level order traverse
 */
public class LevelOrderTraverse {

    public static List<Integer> levelOrder(BinaryTree tree){

        List<Integer> results = new ArrayList<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()){
            BinaryTree tempNode = queue.poll();
            if (tempNode != null){
                results.add(tempNode.value);

                if (tempNode.left != null){
                    queue.add(tempNode.left);
                }

                if (tempNode.right != null){
                    queue.add(tempNode.right);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(2);
        System.out.println(levelOrder(tree));
    }
}
