package ds.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a Binary Tree, check whether the Binary tree contains a duplicate sub-tree of size 2 or more.
 * Note: Two same leaf nodes are not considered as the subtree size of a leaf node is one.
 * Input :  Binary Tree
 *
 *                A
 *
 *              /    \
 *            B        C
 *          /   \       \
 *         D     E       B
 *                      /  \
 *
 *                     D    E
 *
 *   we can see 'BDE' is duplicate sub tree
 */
public class DuplicateSubTree {

    public static int dupSub(BinaryTree root){
        Map<Integer, BinaryTree> nodeMap = new HashMap<>();

        return dupSub(root, nodeMap) ? 1 : -1;
    }

    static boolean dupSub(BinaryTree node, Map<Integer, BinaryTree> nodeMap) {

        if (node == null) return false;

        if (nodeMap.containsKey(node.value)){
            BinaryTree tree = nodeMap.get(node.value);

            if (tree != null&& !isLeaf(node) && tree.left == node.left && tree.right == node.right){
                return true;
            }

        } else {
            nodeMap.put(node.value, node);
            return dupSub(node.left, nodeMap) || dupSub(node.right, nodeMap);
        }
        return false;
    }

    static boolean isLeaf(BinaryTree tree) {
        if (tree != null) {
            return tree.left == null && tree.right == null;
        }
        return true;
    }

}
