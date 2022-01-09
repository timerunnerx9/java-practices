package LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC140WordBreakII {

    static HashMap<String, List<String>> memo = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();

        if(s.length() == 0 || s == null){
            return res;
        }

        if(wordDict.contains(s)){
            res.add(s);  // if the string is a valid word, we just add it to the result
        }

        for(int i = 1; i < s.length(); i++){// starting from the first char, we find the first valid word from the back
            String remainingString = s.substring(i);
            if(wordDict.contains(remainingString)){

                List<String> subList = wordBreak(s.substring(0, i), wordDict); //call the same function on the 0-i chars

                if(subList.size() > 0){
                    for(String word : subList){
                        res.add(word + " " + remainingString);
                    }
                }


            }
        }

        memo.put(s,res);

        return res;


    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));

        System.out.println(wordBreak("catsanddog", dict));
    }
}
