package info.sandroalmeida;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) return 0;

        int left = 0;
        int right = 0;
        Map<Character, Integer> mapChars = new HashMap<>();
        mapChars.put(s.charAt(right), 1);
        int maxLength = 1;

        while(right < s.length() - 1){
            while(mapChars.size() <= k){
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                if(right >= s.length()) break;
                mapChars.put(s.charAt(right), mapChars.getOrDefault(s.charAt(right), 0) + 1);
            }
            while(mapChars.size() > k){
                if(mapChars.get(s.charAt(left)) == 1)
                    mapChars.remove(s.charAt(left));
                else
                    mapChars.put(s.charAt(left), mapChars.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aa";
        int k = 1;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }
}
