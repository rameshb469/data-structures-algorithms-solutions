package ds.binarytree;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class BottomView {

    public static void main(String[] args) {
        bottomView(BinaryTree.getBinaryTree())
                .stream()
                .forEach(System.out::println);
    }

    public static List<Integer> bottomView(BinaryTree tree) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, BinaryTree> map = new TreeMap<>();

        queue.offer(new Pair(0, tree));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int hd = pair.hd;
            BinaryTree node = pair.node;

            map.put(hd, node);

            if (node.left != null) {
                queue.offer(new Pair(hd - 1, node.left));
            }

            if (node.right != null) {
                queue.offer(new Pair(hd + 1, node.right));
            }
        }

        return map.values().stream().mapToInt(bt -> bt.value).boxed().collect(toList());
    }
}
