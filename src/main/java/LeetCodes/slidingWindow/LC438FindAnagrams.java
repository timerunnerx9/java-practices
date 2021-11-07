package LeetCodes.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> freqMap = new HashMap<Character,Integer>();

        for(int i = 0; i < p.length(); i++){
            freqMap.put(p.charAt(i), freqMap.getOrDefault(p.charAt(i), 0)+1);
        }

        int left = 0, matched = 0, right = 0;

        while(right < s.length() ){

            char currentChar = s.charAt(right++);

            if(freqMap.containsKey(currentChar)){

                freqMap.put(currentChar, freqMap.get(currentChar) - 1);

                if(freqMap.get(currentChar) == 0){
                    matched++;
                }

            }

            if(matched == freqMap.size()){
                result.add(left);
            }

            if(right - left   >= p.length() ){

                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)){

                    if(freqMap.get(leftChar) == 0){
                        matched--;
                    }

                    freqMap.put(leftChar, freqMap.get(leftChar)+1);

                }
                left++;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }
}
