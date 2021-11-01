package Educative;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        // TODO: Write your code here

        if(str.length()==0 || str==null){
            throw new IllegalArgumentException();
        }

        int maxLength = 0;
        int left = 0;
        Map<Character,Integer> freqMap = new HashMap<Character, Integer>();

        for(int right = 0; right < str.length(); right++){

            char currentChar = str.charAt(right);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar,0)+1);

            while(freqMap.size() > k){
                freqMap.put(str.charAt(left), freqMap.get(str.charAt(left)) - 1);
                if(freqMap.get(str.charAt(left))==0){
                    freqMap.remove(str.charAt(left));
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left +  1);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}