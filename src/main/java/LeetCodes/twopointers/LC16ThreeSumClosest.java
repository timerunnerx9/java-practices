package LeetCodes.twopointers;

import java.util.Arrays;

public class LC16ThreeSumClosest {

        public static int threeSumClosest(int[] nums, int target) {


            int globalSum = Integer.MAX_VALUE, currentSum = 0;

            Arrays.sort(nums);

            for(int i = 0; i < nums.length -2; i++){

                int left = i + 1;
                int right = nums.length - 1;

                while(left < right){

                    currentSum = nums[i] + nums[left] + nums[right];
                    globalSum = Math.abs(currentSum - target) < Math.abs(globalSum - target)? currentSum:globalSum;
                    if(currentSum == target){
                        return target;
                    }else if(currentSum > target){
                        right--;
                    }else{
                        left++;
                    }

                }




            }

            return globalSum;
        }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,2,5,10,11},
        12));
    }
}

