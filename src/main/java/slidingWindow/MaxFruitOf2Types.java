package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitOf2Types {

    public static int maxFruitOf2Types(char[] arr){
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int max = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char right = arr[windowEnd];

            map.put(right, map.getOrDefault(right, 0) +1);
            while (map.size() > 2){
                char left = arr[windowStart];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                windowStart++;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'A', 'C'};
        System.out.println(maxFruitOf2Types(arr));
    }
}
