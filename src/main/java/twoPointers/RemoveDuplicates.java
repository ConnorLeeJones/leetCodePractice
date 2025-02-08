package twoPointers;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr){
        int nextNonDuplicate = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[nextNonDuplicate - 1] != arr[i]){
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{2, 3, 3, 3, 6, 9, 9})); //expected = 4
//        System.out.println(removeDuplicates(new int[]{2, 2, 2, 11})); //expected = 4

    }
}
