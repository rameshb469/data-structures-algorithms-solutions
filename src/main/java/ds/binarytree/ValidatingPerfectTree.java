package ds.binarytree;

import com.sun.source.doctree.SeeTree;

import java.util.Set;

/**
 * validating given tree is Perfect or not
 */
public class ValidatingPerfectTree {

    /**
     * Below is an idea to check whether a given Binary Tree is perfect or not.
     *
     * Find depth of any node (in below tree we find depth of leftmost node). Let this depth be d.
     * Now recursively traverse the tree and check for following two conditions.
     * Every internal node should have both children non-empty
     * All leaves are at depth ‘d’
     *
     * @param root
     * @return
     */
    public static boolean isPerfect(BinaryTree root){
        int depth = depth(root);
        return isPerfect(root, depth, 0);
    }

    /**
     * This function tests if a binary tree is perfect
     * or not. It basically checks for two things :
     * 1) All leaves are at same level
     * 2) All internal nodes have two children
     *
     */
    static boolean isPerfect(BinaryTree tree, int depth, int level){

        // An empty tree is perfect
        if (tree == null) return true;

        if (tree.left == null && tree.right == null) {
            return (depth == level+1);
        }

        if (tree.left == null || tree.right == null) return false;

        return isPerfect(tree.left, depth, level+1) && isPerfect(tree.right, depth, level+1);
    }

    static int depth(BinaryTree tree){
        Set<Integer> integers = null;
        int depth = 0;

        while (tree != null){
            depth++;
            tree = tree.left;
        }
        return depth;
    }
}
