package ds.array;

import java.util.Arrays;

/**
 * Given two arrays of integers, compute the pair of values (one value in each array)
 * with the smallest (non-negative) difference. Return the difference.
 *
 * Examples :
 *
 *
 *
 * Input : A[] = {l, 3, 15, 11, 2}
 *         B[] = {23, 127, 235, 19, 8}
 * Output : 3
 * That is, the pair (11, 8)
 *
 * Input : A[] = {l0, 5, 40}
 *         B[] = {50, 90, 80}
 * Output : 10
 * That is, the pair (40, 50)
 */
public class SmallestDiffPair {

    public static void main(String[] args) {
        System.out.println(findSmallestDifference(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}, 5, 5));
        System.out.println(findMinDiff(new int[]{1, 19, -4, 31, 38, 25, 100}, 7));
    }

    /**
     *
     * @param
     * @param B
     * @param m
     * @param n
     * @return
     */
    static int findSmallestDifference(int A[], int B[],
                                      int m, int n){
        Arrays.sort(A);
        Arrays.sort(B);

        int result = Integer.MAX_VALUE;
        int a = 0, b = 0;

        /**
         * A[] = {5, 10, 40}
         *  B[] = {50, 80, 90}
         */
        while (a < m && b < n) {
            if (Math.abs(A[a] - B[b]) < result) {
                result = Math.abs(A[a] - B[b]);
            }

            if (A[a] < B[b]) {
                a++;
            } else {
                b++;
            }

        }
        return result;
    }

    // Returns minimum difference between any pair
    static int findMinDiff(int[] arr, int n) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for (int i = 0; i < n-1; i++) {
            if (arr[i+1] - arr[i] < diff) {
                diff = arr[i+1] - arr[i];
            }
        }
        return diff;

    }
}
