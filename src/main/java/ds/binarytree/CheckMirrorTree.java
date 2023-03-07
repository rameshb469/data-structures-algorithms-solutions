package ds.binarytree;

/**
 * Given two Binary Trees, write a function that returns true if two trees are mirror of each other,
 * else false. For example, the function should return true for following input trees.
 *
 * This problem is different from the problem discussed here.
 * For two trees ‘a’ and ‘b’ to be mirror images, the following three conditions must be true:
 *
 * Their root node’s key must be same
 * Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
 * Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
 *
 * This will work for
 * <ul>
 *     <li>Foldable Tree</li>
 *     <li>Symmetric Tree</li>
 *     <li>Mirror Tree</li>
 * </ul>
 */
public class CheckMirrorTree {


    public static boolean isMirror(BinaryTree r1, BinaryTree r2) {

        if (r1 == null && r2 == null) return true;

        if (r1 == null || r2 == null) return false;

        return r1.value == r2.value
            && isMirror(r1.left, r2.right) && isMirror(r2.left, r1.right);
    }
}


