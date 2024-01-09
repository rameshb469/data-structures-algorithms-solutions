package ds.array._2d;

import java.util.Arrays;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        int[][] array= new int[][]{{1,2},{2,3}, {3,4}, {1,3}};

        System.out.println(array.toString());
        Arrays.sort(array[0]);
        System.out.println(array.toString());
        for(int i=0; i< array.length; i++){
            for (int j = 0; j < array[i].length; j++) {
                System.out.println(array[i][j]);
            }
        }
    }
}
