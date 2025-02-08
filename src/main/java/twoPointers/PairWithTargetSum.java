package twoPointers;

import java.util.Arrays;

public class PairWithTargetSum {

    public static int[] pairWithTargetSum(int[] arr, int target){
        int leftPointer = 0, rightPointer = arr.length - 1;

        while (leftPointer < rightPointer){
            int currentSum = arr[leftPointer] + arr[rightPointer];
            if (currentSum == target){
                return new int[]{leftPointer, rightPointer};
            }
            if (currentSum < target){
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pairWithTargetSum(new int[]{1, 2, 3, 4, 6}, 6)));
    }

}
