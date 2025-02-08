package slidingWindow;

public class MaxSumOfSubarray {

    public static int findMaxSum(int k, int[] arr){
        int max = 0;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1){
                max = Math.max(max, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k=3;
        System.out.println(findMaxSum(k, arr));
    }
}
