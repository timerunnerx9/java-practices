package LeetCodes.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC30SubstringwithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        Map<String, Integer> freqMap = new HashMap<String,Integer>();

        for(String word : words){
            freqMap.put(word, freqMap.getOrDefault(word,0) + 1);
        }

        int wordCount = words.length, wordLength = words[0].length();


        for(int i = 0; i <= s.length() - wordCount * wordLength; i++){

            Map<String,Integer> seenMap = new HashMap<String,Integer>();

            for(int j = 0; j < wordCount; j++){

                int nextWordIndex = i + j * wordLength;
                String currentWord = s.substring(nextWordIndex, nextWordIndex + wordLength);

                if(!freqMap.containsKey(currentWord)) break;

                seenMap.put(currentWord, seenMap.getOrDefault(currentWord, 0) + 1);

                if(seenMap.get(currentWord) > freqMap.getOrDefault(currentWord,0)) break;

                if(j + 1 == wordCount){
                    result.add(i);
                }

            }
        }

        return result;
    }
}
