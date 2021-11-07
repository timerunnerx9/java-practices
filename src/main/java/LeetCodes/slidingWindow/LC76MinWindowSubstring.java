package LeetCodes.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC76MinWindowSubstring {
    public String minWindow(String s, String t) {

        int minLength = s.length() + 1, left = 0, matched = 0, subStart = 0;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(char c : t.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for(int right = 0; right < s.length(); right++){

            char currentChar = s.charAt(right);

            if(freqMap.containsKey(currentChar)){
                freqMap.put(currentChar, freqMap.get(currentChar) - 1);

                if(freqMap.get(currentChar) == 0){
                    matched++;
                }
            }

            while(matched == freqMap.size()){

                if(right - left + 1 < minLength){
                    minLength = right - left + 1;
                    subStart = left;
                }

                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)){
                    if(freqMap.get(leftChar) == 0){
                        matched--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }

                left++;

            }

        }

        return minLength <= s.length() ? s.substring(subStart, subStart + minLength) : "";
    }
}
