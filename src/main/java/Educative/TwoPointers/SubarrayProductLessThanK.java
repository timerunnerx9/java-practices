package Educative.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {


        public static List<List<Integer>> findSubarrays(int[] arr, int target) {
            List<List<Integer>> subarrays = new ArrayList<>();
            // TODO: Write your code here

            int left = 0, right = arr.length - 1;

            while(left < right){

                List<Integer> newList = new ArrayList<>();
                int currentProd = 1;
                for(int i = left; i <= right; i++){
                    if(arr[i] * currentProd < target){
                        newList.add(arr[i]);
                        subarrays.add(new ArrayList<>(newList));
                    }else{
                        newList = new ArrayList<>();
                        break;
                    }

                }

                left++;

            }

            return subarrays;
        }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
    }


