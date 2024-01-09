package ds.array;

/**
 * Given two sorted arrays and a number x, find the pair whose sum is closest to x and the pair has an element from each array.
 * We are given two arrays ar1[0…m-1] and ar2[0..n-1] and a number x, we need to find the pair ar1[i] + ar2[j]
 * such that absolute value of (ar1[i] + ar2[j] – x) is minimum.
 *
 * Example:
 *
 * Input:  ar1[] = {1, 4, 5, 7};
 *         ar2[] = {10, 20, 30, 40};
 *         x = 32
 * Output:  1 and 30
 *
 * Input:  ar1[] = {1, 4, 5, 7};
 *         ar2[] = {10, 20, 30, 40};
 *         x = 50
 * Output:  7 and 40
 */
public class ClosestPair {

    public static void main(String[] args) {
        printClosest(new int[]{1, 4, 5, 7}, new int[]{10, 20, 30, 40}, 4, 4, 32);
    }

    static void printClosest(int a[], int b[], int m, int n, int x) {

        // Initlize the result index as 0
        int res_l = 0, res_r = 0;
        /**
         * left array index inilize as Zero and
         * right array index as last index
         */
        int l = 0, r = n-1;
        // Initilize diff as Integer MAX_VALUE
        int diff = Integer.MAX_VALUE;

        while (l < m && r >= 0) {

            if (Math.abs(a[l]+b[r]-x) < diff ) {
                diff = Math.abs(a[l]+b[r]-x);
                res_l = l;
                res_r = r;
            }

            if (a[l]+b[r] > x) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(a[res_l] +"--->"+b[res_r]);
    }

    /**
     * sample soluions and time complex city O(n^2)
     * @param ar1
     * @param ar2
     * @param x
     */
    static void printClosest(int ar1[], int ar2[], int x){
        int diff = Integer.MAX_VALUE;
        Integer first_index = null, last_index  = null;
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar2.length; j++) {
                if (Math.abs(ar1[i]+ar2[j]-x ) < diff) {
                    diff = Math.abs(ar1[i]+ar2[j]-x);
                    first_index = i;
                    last_index = j;
                }
            }
        }

        if (first_index != null && last_index != null){
            System.out.println(ar1[first_index]+"--->"+ar2[last_index]);
        }
    }
}
