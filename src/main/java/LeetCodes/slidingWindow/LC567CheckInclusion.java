package LeetCodes.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LC567CheckInclusion {

    //s1 is pattern, s2 is the string to search
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> patternFreqMap = new HashMap<>(); // create a char frequency map to store the char we need to match

        for(int i = 0; i < s1.length(); i++){  // loop through the pattern, put all char in the mapp
            patternFreqMap.put(s1.charAt(i), patternFreqMap.getOrDefault(s1.charAt(i), 0)+1);
        }

        int left = 0, charMatched = 0; // create a window, charMatched is the unique char matched count

        for(int j = 0; j < s2.length(); j++){ // start creating a window

            char currentChar = s2.charAt(j);

            if(patternFreqMap.containsKey(currentChar)){  //check if the right char is one of the target chars

                patternFreqMap.put(currentChar, patternFreqMap.get(currentChar) -1); // if yes, reduce the needed char

                if(patternFreqMap.get(currentChar) == 0){  // if the amount of the current char is 0, that means we meet the
                    charMatched++;                         // number requirement
                }
            }

            if(charMatched == patternFreqMap.size()) return true;  // if we meet all the number requirements in the map, we have a
                                                                  // permutation
            if( j  >= s1.length() -1 ){ // if the current right boundary has exceeded the pattern's length, that means within
                                        // this window range we didn't find any match, it's time to move to the right, and shrink
                                        // from the left
                char leftChar = s2.charAt(left);
                if(patternFreqMap.containsKey(leftChar)){  // if the left char is our target char, we need to add it back to the
                                                           // requirement map
                    if(patternFreqMap.get(leftChar) == 0){ // check if it had met the requirement before
                        charMatched--;          // if yes, reduce the charMatched amount
                    }
                    patternFreqMap.put(leftChar, patternFreqMap.get(leftChar) + 1);  // add the char back to the freqMap
                }
                left++;  // increase the left boundary

            }

        }

        return false;

    }
}
