package ds.binarytree;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Constructing the Binary Tree from given in order and pre-order array values
 */
public class ConstructingBTFromInOrderAndPreOrder {

    public  static BinaryTree construct(int[] inOrder, int[] preOrder) {
        Map<Integer,Integer> iMap = new IdentityHashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            iMap.put(inOrder[i], i);
        }
        return buildTree(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1, iMap);
    }


    private static int getIndex(int[] array, int element){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == element) return i;
        }
        return -1;
    }
    /**
     * Construct binary tree for given values
     *
     * @param preOrder pre-order array
     * @param pStart pre-order array start index
     * @param pEnd
     * @param inOrder
     * @param iStart
     * @param iEnd
     * @param iMap
     * @return
     */
    private static BinaryTree buildTree(int[] preOrder, int pStart, int pEnd,
                                 int[] inOrder, int iStart, int iEnd, Map<Integer,Integer> iMap){
        if (pStart > pEnd || iStart > iEnd) return null;

        BinaryTree root = new BinaryTree(preOrder[pStart]);
         int rootIndex = iMap.get(root.value);
        int iLeft  = rootIndex - iStart;

        root.left = buildTree(preOrder, pStart+1, pStart+iLeft,
                              inOrder, iStart, rootIndex-1, iMap);

        root.right = buildTree(preOrder, pStart+iLeft+1, pEnd,
                               inOrder, rootIndex+1, iEnd, iMap);

        return root;
    }

    public static void main(String[] args) {
        int in[] = new int[]{7 ,3 ,11 ,1 ,17 ,3 ,18};
        int pre[] = new int[] { 1 ,3 ,7 ,11 ,3 ,17 ,18};
        BinaryTree root = construct(in, pre);
        LevelOrderTraverse.levelOrder(root).stream().forEach(System.out::println);
    }
}
