package twoPointers;

public class TripletSumCloseToZero {

    public static int searchTriplet(int[] arr, int targetSum){
        int result = Integer.MAX_VALUE;
        int left, right;
        for (int i = 0; i < arr.length-2; i++) {
            left = i+1;
            right = arr.length-1;
            while (left < right){
                int currentSum = arr[i] + arr[left] + arr[right];
                int diff = targetSum - currentSum;
                if (currentSum == targetSum){
                    return (currentSum);
                }
                if (Math.abs(diff) < targetSum){
                    result = currentSum;
                }
                if (diff > 0){
                    left++;
                }
                right--;

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchTriplet(new int[]{-2, 0, 1, 2}, 2));
    }
}
