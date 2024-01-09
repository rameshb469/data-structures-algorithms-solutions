package ds.array;

/**
 * Array data stracture
 */
public class ArrayDS<T> {

    private T[] data;

    private static int DEFAULT_SIZE = 100;

    public static void main(String[] args) {
        insert();
    }

    public static void insert(){
        int array[] = new int[DEFAULT_SIZE];
        boolean b[] = new boolean[DEFAULT_SIZE];
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
