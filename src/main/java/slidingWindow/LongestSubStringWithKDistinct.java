package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinct {

    public static int LongestSubStringWithKDistinct(String str, int k){
        int max = Integer.MIN_VALUE;
        int windowStart = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            Character right = str.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.size() > k){
                Character left = str.charAt(windowStart);
                map.put(left, map.get(left) -1);
                if (map.get(left) == 0){
                    map.remove(left);
                }
                windowStart++;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;

//        int[] alpha = new int[26];
//        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
//            alpha[str.charAt(windowEnd) - 'a']++;
//            while(alpha[str.charAt(windowEnd) - 'a'] <= 2){
//                max = Math.max(max, windowEnd - windowStart + 1);
//                alpha[str.charAt(windowStart) - 'a']--;
//                windowStart++;
////                windowEnd++;
//            }
//        }
//        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubStringWithKDistinct("araaci", 2));
    }

}
