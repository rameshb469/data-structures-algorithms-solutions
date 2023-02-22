package ds.binarytree;

import java.util.*;

/**
 * Output: 1 2 3 4 5 6 7
 * Explanation:
 * Level 1: 1
 * Level 2: 2 3
 * Level 3: 7 6 5 4
 * Nodes are traversed in the alternate order from front or back in adjacent levels ,
 * so the output is 1 2 3 4 5 6 7.
 *
 * Input:
 *            10
 *          /     \
 *         20     30
 *       /    \
 *     40     60
 * Output: 10 20 30 60 40
 */
public class LevelOrderTraverseInSpiralForm {

    /**
     *
     * @param root
     * @return
     */
    public static List<Integer> findSpiral(BinaryTree root){

        List<Integer> results = new ArrayList<>();
        Stack<BinaryTree> rl = new Stack<>();
        Stack<BinaryTree> lr = new Stack<>();
        rl.add(root);

        while (!rl.isEmpty() || !lr.isEmpty()){

            while (!rl.isEmpty()) {
                BinaryTree tempNode = rl.pop();
                if (tempNode != null){
                    results.add(tempNode.value);

                    if (tempNode.right != null){
                        lr.push(tempNode.right);
                    }

                    if (tempNode.left != null){
                        lr.push(tempNode.left);
                    }
                }
            }

            while (!lr.isEmpty()) {
                BinaryTree tempNode = lr.pop();
                if (tempNode != null){
                    results.add(tempNode.value);

                    if (tempNode.right != null){
                        rl.push(tempNode.right);
                    }

                    if (tempNode.left != null){
                        rl.push(tempNode.left);
                    }
                }
            }

        }

        return results;
    }
}
