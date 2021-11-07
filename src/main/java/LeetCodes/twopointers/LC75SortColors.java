package LeetCodes.twopointers;

public class LC75SortColors {

    public void sortColors(int[] nums) {
        int slow = 0, fast = 0;
        for(int i = 0; i < 3; i++){
            fast = slow;
            while(fast < nums.length){
                if(nums[fast] == i){
                    int slowEle = nums[slow];
                    nums[slow] = i;
                    nums[fast] = slowEle;
                    slow++;
                }
                fast++;
            }
        }
    }
}
