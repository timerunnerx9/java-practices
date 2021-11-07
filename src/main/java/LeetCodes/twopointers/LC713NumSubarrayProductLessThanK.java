package LeetCodes.twopointers;

public class LC713NumSubarrayProductLessThanK {

        public static int numSubarrayProductLessThanK(int[] nums, int k) {

            int count = 0;
            if(k <= 1) return 0;
            double product = 1;
            int left = 0;

            for(int right = 0; right < nums.length; right++){

                product *= nums[right];


                while(product >= k && left <= right){

                    product /= nums[left++];

                }

                count += right - left + 1;
            }


            return count;


        }


    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[] {3,4,5},2);
    }
    }

