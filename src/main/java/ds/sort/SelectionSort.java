package ds.sort;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from unsorted part and putting it at the beginning.
 * The algorithm maintains two subarrays in a given array.
 *
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * In every iteration of selection sort, the minimum element (considering ascending order)
 * from the unsorted subarray is picked and moved to the sorted subarray.
 *
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 *
 */
public class SelectionSort {

    public int[] sort(int array[]) {
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                int selection_index = i;
                for (int j = (i+1); j < array.length; j++) {
                    if (array[selection_index] > array[j]) {
                        selection_index = j;
                    }
                }
                int temp = array[selection_index];
                array[selection_index] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
