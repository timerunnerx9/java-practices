package LeetCodes.modifiedBinarySearch;

public class LC33SearchInRotatedSortedArray {

        public static int search(int[] nums, int target) {

            if(nums.length == 0) return -1;

            int start = 0, end = nums.length - 1;

            while(start <= end){

                int mid = start + (end - start) / 2;


                if(nums[mid] == target) return mid;

                if(nums[start] < nums[mid]){

                    if(nums[start] <= target && target < nums[mid]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }

                }else{

                    if(nums[mid] < target && target <= nums[end]){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }

                }

            }

            return -1;
        }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1},1));
    }

}
