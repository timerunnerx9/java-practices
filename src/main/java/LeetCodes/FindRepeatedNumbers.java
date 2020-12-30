package LeetCodes;

public class FindRepeatedNumbers {
    public int findRepeatNumber(int[] nums) {

        for(int i = 0; i<nums.length; i++){
            while(nums[i]!=i){
                if(nums[nums[i]]==nums[i]) return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
