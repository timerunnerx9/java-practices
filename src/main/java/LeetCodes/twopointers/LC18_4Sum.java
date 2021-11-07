package LeetCodes.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4Sum {

        public static List<List<Integer>> fourSum(int[] nums, int target) {


            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);

            if(nums.length < 4) return result;

            for(int i = 0; i < nums.length - 3; i++){

                if(i > 0 && nums[i] == nums[i-1]) continue;

                for(int j = i + 1; j < nums.length - 2; j++){

                    if( j > i + 1 && nums[j] == nums[j-1]) continue;

                    int newTarget = target - nums[i] - nums[j];

                    searchPair(nums, newTarget, j, result, i, j);

                }
            }

            return result;


        }


        public static void searchPair(int[] nums, int target, int startIndex, List<List<Integer>> result, int i, int j){

            int left = startIndex + 1;
            int right = nums.length - 1;

            while(left < right){

                if(nums[left] + nums[right] == target){
                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else if(nums[left] + nums[right] > target){
                    right--;
                }
            }

        }


    public static void main(String[] args) {
        fourSum(new int[] {2,2,2,2,2},8);
    }
}
