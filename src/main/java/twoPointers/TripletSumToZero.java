package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr){
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        int left;
        int right;
        for (int i = 0; i < arr.length-2; i++) {
            left = i+1;
            right = arr.length-1;
            while (left <= right) {
                if (arr[left] + arr[right] == arr[i] * -1) {
                    triplets.add(new ArrayList<>(Arrays.asList(arr[left], arr[right], arr[i])));
                    left++;
                    right--;
                } else if (arr[left] + arr[right] > arr[i] * -1){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
