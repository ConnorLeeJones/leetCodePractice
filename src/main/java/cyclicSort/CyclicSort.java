package cyclicSort;

import java.util.Arrays;

public class CyclicSort {

    public static void cyclicSort(int[] nums){
        int i = 0;
        while (i < nums.length){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                swapNumbers(nums, i, j);
            } else {
                i++;
            }
        }
    }

    public static void swapNumbers(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
