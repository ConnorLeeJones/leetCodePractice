package slidingWindow;

public class MinSizeSubArray {

    public static int findMinSubArray(int S, int[] arr){
        int windowStart = 0;
        int min = Integer.MAX_VALUE;
        int windowSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while(windowSum >= S){
                min = Math.min(min, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        System.out.println(findMinSubArray(7, arr));
    }
}
