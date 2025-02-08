package slidingWindow;

public class ReplacingOnes {

    public static int findLength(int[] arr, int k){
        int onesCounter = 0;
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1){
                onesCounter++;
            }
            if (windowEnd - windowStart + 1 - onesCounter > k){
                if(arr[windowStart] == 1){
                    onesCounter--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(findLength(arr, 2)); // expected = 6
        int[] arr2 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
        System.out.println(findLength(arr2, 3)); // expected = 9
    }


}
