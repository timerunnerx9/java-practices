package LeetCodes.slidingWindow;

public class LC1004MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k){

        int left = 0, maxLength = 0, maxOneCount = 0;

        for(int right = 0; right < nums.length; right++){

            if(nums[right] == 1) maxOneCount++;

            if(right - left + 1 - maxOneCount > k){

                // check if the current window fits
                // the condition, if not, shrink the window. Even if num[left] is still 0
                // and the if(right - left + 1 - maxOneCount > k) didn't change, as long as
                // we have incremented left once, we will have a smaller maxLength
                if(nums[left] == 1) maxOneCount--;
                left++;

            }
            maxLength = Math.max(maxLength, right - left + 1);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,1,0,0,1}, 1));
    }
}
