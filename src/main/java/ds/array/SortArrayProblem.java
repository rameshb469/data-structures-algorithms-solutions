package ds.array;

public class SortArrayProblem {

    public static int[] sortArrayByParity(int[] nums) {

        if(nums.length <= 1) return nums;

        int[] result = new int[nums.length];

        for(int i=0; i< nums.length; i++){

            if(nums[i] % 2 == 0){
                result[i] = nums[i];
            } else {
                result[nums.length-1-i] = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        print(sortArrayByParity(new int[]{3,1,2,4}));
    }

    private static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
