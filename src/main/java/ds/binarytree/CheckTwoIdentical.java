package ds.binarytree;

/**
 * Write a function to determine if two trees are identical or not:
 *
 * Two trees are identical when they have the same data and the arrangement of data is also the same
 *
 * Examples:
 *
 * Input:             1                    1
 *                  /   \                /   \
 *                2      3            2      3
 *              /                    /
 *            4                   4
 *
 * Output: Both trees are identical
 *
 * Input:             1                    1
 *                  /   \                /   \
 *                2      3            5      3
 *                      /             /
 *                   4             4
 *
 * Output: Trees are not identical
 */
public class CheckTwoIdentical {


    /**
     * Follow the given steps to solve the problem:
     *
     *  If both trees are empty then return 1(Base case)
     *      Else If both trees are non-empty
     *  Check data of the root nodes (tree1->data ==  tree2->data)
     *  Check left subtrees recursively
     *  Check right subtrees recursively
     *  If the above three statements are true then return 1
     *      Else return 0 (one is empty and the other is not)
     * @param r1
     * @param r2
     * @return
     */
    public static boolean isIdentical(BinaryTree r1, BinaryTree r2) {

        if (r1 == null && r2 == null) return true;

        if (r1 == null || r2 == null) return false;
        
        return r1.value == r2.value
                && isIdentical(r1.left, r2.left)
                && isIdentical(r1.right, r2.right);
    }
}
