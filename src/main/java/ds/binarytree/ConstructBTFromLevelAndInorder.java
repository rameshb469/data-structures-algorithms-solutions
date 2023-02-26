package ds.binarytree;

import java.util.*;

/**
 * Constructing binary tree from level order and in-order traversals
 */
public class ConstructBTFromLevelAndInorder {


    public static BinaryTree buildTree(int[] inorder, int[] levelOrder){
        return null;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 8, 10, 12, 14, 20, 22};
        int[] level = {20, 8, 22, 4, 12, 10, 14};

        BinaryTree root = buildTree(inorder, level);
        LevelOrderTraverse.levelOrder(root).stream().forEach(System.out::println);
    }
}
