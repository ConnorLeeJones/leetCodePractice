package slidingWindow;

public class NoRepeatSubstring {
    
    public static int noRepeatSubstring(String s){
        int windowStart = 0;
        int max = Integer.MIN_VALUE;
        char[] alpha = new char[26];

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            alpha[right - 'a']++;
            while (alpha[right - 'a'] > 1){
                char left = s.charAt(windowStart);
                alpha[left - 'a']--;
                windowStart++;
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(noRepeatSubstring("abccde"));
    }
}
