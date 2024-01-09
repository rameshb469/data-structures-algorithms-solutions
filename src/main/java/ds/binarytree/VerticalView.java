package ds.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *         4
 *         2
 *         1 5 6
 *         3 8
 *         7
 *         9
 *
 *                      1
 *              2               3
 *         4        5     6         7
 *                              8       9
 */

public class VerticalView {

    public static void main(String[] args) {


        Map<Integer, List<Integer>> map = verticalView(BinaryTree.getBinaryTree());

        for (var entry : map.entrySet()){
            System.out.println("HD value : "+entry.getKey());
            entry.getValue().forEach(e -> System.out.println(e+"->"));
            System.out.println("---------------------------");
        }

    }


    public static Map<Integer, List<Integer>> verticalView(BinaryTree tree){

        // we need pass horizontal Distance (HD)
        // for root HD = 0 and left is -1 and right is +1
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalView(tree, 0, map);

        return map;
    }

    public static void verticalView(BinaryTree tree, int hd, Map<Integer, List<Integer>> map){

        if (tree == null) return;

        List<Integer> values = map.get(hd);

        map.computeIfAbsent(hd, val-> new ArrayList<>()).add(tree.value);

        if (values == null) {
            values = new ArrayList<>();
        }
        values.add(tree.value);
        map.put(hd, values);

        verticalView(tree.left, hd-1, map);
        verticalView(tree.right, hd+1, map);
    }
}
