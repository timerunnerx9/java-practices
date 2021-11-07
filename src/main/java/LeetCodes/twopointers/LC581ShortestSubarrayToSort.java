package LeetCodes.twopointers;

public class LC581ShortestSubarrayToSort {

        public static int findUnsortedSubarray(int[] nums) {

            int leftBoundIndex = nums.length + 1;
            int rightBoundIndex = -1;

            int leftMax = Integer.MIN_VALUE;
            int rightMin = Integer.MAX_VALUE;

            // from left to right

            for(int i = 0; i < nums.length; i++){

                leftMax = Math.max(nums[i], leftMax);
                if(nums[i] < leftMax){
                    rightBoundIndex = i;
                }

            }

            // from right to left

            for(int j = nums.length - 1; j>=0; j--){

                rightMin = Math.min(rightMin,nums[j]);
                if(nums[j] > rightMin){
                    leftBoundIndex = j;
                }


            }

            if(rightBoundIndex - leftBoundIndex > 0){
                return rightBoundIndex - leftBoundIndex + 1;
            }else{
                return 0;
            }

        }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
    }
}
