public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 1, 0, 1});
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, currentZeroIndex = -1;

        for(int left =0, right = 0; right<nums.length;right++){
            if(nums[right]==0){
                left = currentZeroIndex+1;
                currentZeroIndex = right;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
