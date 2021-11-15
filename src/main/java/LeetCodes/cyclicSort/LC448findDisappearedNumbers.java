package LeetCodes.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class LC448findDisappearedNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            while(nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]){

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;

            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j + 1){
                result.add(j+1);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
