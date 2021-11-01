package LeetCodes.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC3LengthOfLongestSubstring {
        public int lengthOfLongestSubstring(String s) {

            if(s.length() == 0 || s == null) return 0;

            int left = 0, maxLength = 0;
            Map<Character, Integer> seenMap = new HashMap<>();

            for(int right = 0; right < s.length(); right++){

                char currentChar = s.charAt(right);

                if(seenMap.containsKey(currentChar)){

                    left = Math.max(left, seenMap.get(currentChar) + 1);
                }

                seenMap.put(currentChar, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }

            return maxLength;
        }
    }

