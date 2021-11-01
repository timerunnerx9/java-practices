package Educative.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {

        int left = 0, maxLength = 0, maxCharCount = 0;
        Map<Character, Integer> freqMap = new HashMap<Character,Integer>();

        for(int right = 0; right < s.length(); right++){

            char currentChar = s.charAt(right);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0)+1);
            maxCharCount = Math.max(freqMap.get(currentChar), maxCharCount);


            if(right - left + 1 - maxCharCount > k){

                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;

            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.characterReplacement("AABABBA", 1));
        System.out.println(CharacterReplacement.characterReplacement("abbcb", 1));
        System.out.println(CharacterReplacement.characterReplacement("abccde", 1));
    }
}

