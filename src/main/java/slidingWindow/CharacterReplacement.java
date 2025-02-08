package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k){
        int windowStart = 0;
        int maxLength = 0;
        int maxCharacterCount = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            map.put(right, map.getOrDefault(right, 0) + 1);
            maxCharacterCount = Math.max(maxCharacterCount, map.get(right));

            if (windowEnd - windowStart + 1 - maxCharacterCount > k){
                char left = s.charAt(windowStart);
                map.put(left, map.get(left) - 1);
//                if (map.get(left) == 0){
//                    map.remove(left);
//                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("aabccbb", 2)); //expected: 5
        System.out.println(characterReplacement("abbcb", 1)); //expected: 4
        System.out.println(characterReplacement("abccde", 1)); //expected: 3


    }
}
