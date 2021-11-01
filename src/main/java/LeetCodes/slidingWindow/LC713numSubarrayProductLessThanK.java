package LeetCodes.slidingWindow;

public class LC713numSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int result = 0;
        double product = 1;

        int left = 0;

        for(int right = 0; right < nums.length; right++){
            product *= nums[right];

            while(product >= k && left < nums.length){
                product /= nums[left++];

            }

            result += right - left + 1;


        }

        return result;

    }
}
