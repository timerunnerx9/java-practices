package LeetCodes;

import java.util.HashMap;
import java.util.Map;

public class LC560SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {

            Map<Integer,Integer> presum = new HashMap<Integer,Integer>();

            int sum = 0, counter=0;

            presum.put(0,1);

            for(int i = 0; i < nums.length; i++){
                sum += nums[i];

                if(presum.containsKey(sum-k)){
                    counter += presum.get(sum-k);
                }
                presum.put(sum, presum.getOrDefault(sum,0)+1);
            }

            return counter;
        }
    }
}
