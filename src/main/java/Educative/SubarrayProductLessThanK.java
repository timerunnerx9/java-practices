package Educative;

import java.util.ArrayList;
import java.util.List;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        // TODO: Write your code here

        for(int i = 0; i < arr.length; i++){
            int currProduct = 1;

            for(int j = i; j < arr.length; j++){

                currProduct *= j;
                if(currProduct < target){
                    List<Integer> newList = new ArrayList<Integer>();

                    for(int k = i; k<=j; k++){
                        newList.add(arr[k]);
                    }
                    subarrays.add(newList);
                }
            }
        }
        return subarrays;
    }


    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}

