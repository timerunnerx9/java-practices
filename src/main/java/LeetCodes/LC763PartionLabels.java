package LeetCodes;

import java.util.ArrayList;
import java.util.List;

public class LC763PartionLabels {
    class Solution {
        public List<Integer> partitionLabels(String S) {

            List<Integer> res = new ArrayList<>();

            if(S.length()==0 || S == null) return res;

            int[] charMap = new int[26];

            for(int i = 0 ; i<S.length(); i++){
                charMap[S.charAt(i)-'a'] = i;
            }

            int start = 0;
            int end = 0;

            for(int j =0; j<S.length(); j++){
                int currEnd = charMap[S.charAt(j)-'a'];
                end = Math.max(currEnd,end);

                if(j==end){
                    res.add(end-start+1);
                    start = end + 1;
                }
            }


            return res;
        }
    }
}
