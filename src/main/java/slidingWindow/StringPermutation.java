package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern){
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char c: pattern.toCharArray()){
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        int windowStart = 0;
        int matched = 0;

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char windowEndChar = str.charAt(windowEnd);
            if (patternMap.containsKey(windowEndChar)){
                patternMap.put(windowEndChar, patternMap.get(windowEndChar) - 1);
                if (patternMap.get(windowEndChar) == 0){
                    matched++;
                }
            }
            if (matched == patternMap.size()){
                return true;
            }
            if(windowEnd >= pattern.length()){
                char windowStartChar = str.charAt(windowStart++);
                if (patternMap.containsKey(windowStartChar)){
                    patternMap.put(windowStartChar, patternMap.get(windowStartChar) + 1);
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        String str ="bcdxabcdy";
        String pattern = "bcdyabcdx";
        System.out.println(findPermutation(str, pattern)); //expected = true

        str="oidbcaf"; pattern="abc";
        System.out.println(findPermutation(str, pattern));

        str="odicf"; pattern="dc";
        System.out.println(findPermutation(str, pattern)); //expected = false
    }

}
