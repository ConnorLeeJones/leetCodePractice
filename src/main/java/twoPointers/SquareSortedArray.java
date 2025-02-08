package twoPointers;

import java.util.Arrays;

public class SquareSortedArray {

    public static int[] squareSortedArray(int[] arr){
        int[] result = new int[arr.length];
        int left = 0, right = arr.length - 1;
        int index = arr.length - 1;

        while (left <= right){
            if ((arr[left] * arr[left]) >= (arr[right] * arr[right])){
                result[index] = arr[left] * arr[left];
                left++;
            } else {
                result[index] = arr[right] * arr[right];
                right--;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareSortedArray(new int[]{-2, -1, 0, 2, 3}))); //expected = [0, 1, 4, 4, 9]
    }
}
