package Educative.CyclicSort;

import java.util.ArrayList;
import java.util.List;

public class findNumbers {

        public static int[] findNumbers(int[] nums) {
            // TODO: Write your code here


            for(int i = 0; i < nums.length; i++){

                while(nums[i] != i+1){

                    if(nums[i] == nums[nums[i] -1]) break;

                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;

                }
            }


            for(int j = 0; j < nums.length; j++){

                if(nums[j] != j+1){
                    return new int[]{nums[j], j+1};
                }

            }


            return new int[]{-1,-1};

        }

    public static void main(String[] args) {

            findNumbers(new int[]{3,1,2,5,2});
    }
    }


