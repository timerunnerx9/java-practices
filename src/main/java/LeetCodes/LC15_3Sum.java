package LeetCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15_3Sum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();

            Arrays.sort(nums);

            for(int i = 0; i<nums.length-2; i++){

                if(nums[i]>0) continue;

                if(i==0 || (i>0 &&nums[i]!=nums[i-1])){

                    int slow = i+1, fast = nums.length -1, target = 0 - nums[i];

                    while(slow<fast){
                        if(nums[slow]+nums[fast]==target){
                            res.add(Arrays.asList(nums[i],nums[slow],nums[fast]));

                            while(slow < fast && nums[slow]==nums[slow+1])slow++;
                            while(fast > slow && nums[fast]==nums[fast-1])fast--;
                            slow++;
                            fast--;

                        }else if(nums[slow]+nums[fast]<target){
                            slow++;
                        }else{
                            fast--;
                        }

                    }

                }
            }

            return res;
        }
    }
}
