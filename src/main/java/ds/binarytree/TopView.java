package ds.binarytree;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class TopView {

    public static void main(String[] args) {


        topView(BinaryTree.getBinaryTree())
                .stream()
                .forEach(System.out::println);

    }

    public static List<Integer> topView(BinaryTree tree) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, BinaryTree> map = new TreeMap<>();

        queue.offer(new Pair(0, tree));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int hd = pair.hd;
            BinaryTree node = pair.node;

            if (!map.containsKey(hd)) {
                map.put(hd, node);
            }

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


class Pair {
    public int hd;
    public BinaryTree node;

    public Pair(int first, BinaryTree second) {
        this.hd = first;
        this.node = second;
    }
}