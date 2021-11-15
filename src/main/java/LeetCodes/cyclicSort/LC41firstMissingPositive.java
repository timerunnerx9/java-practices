package LeetCodes.cyclicSort;

public class LC41firstMissingPositive {

        public static int firstMissingPositive(int[] nums) {

            for(int i = 0; i < nums.length; i++){

                while(nums[i] != i+1 && nums[i] != nums[nums[i]-1]){

                    if(nums[i] < 1 || nums[i] > nums.length) break;
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;

                }

            }

            for(int j = 0; j<nums.length; j++){

                if(nums[j] != j+1) return j+1;

            }

            return nums.length + 1;


        }

    public static void main(String[] args) {
        firstMissingPositive(new int[]{1,1});
    }
}

