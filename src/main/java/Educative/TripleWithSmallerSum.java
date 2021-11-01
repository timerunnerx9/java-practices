package Educative;

import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        int count = 0;
        // TODO: Write your code here
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++){

            int left = i + 1, right = arr.length - 1;

            while(left < right){

                int currSum = arr[i] + arr[left] + arr[right];
                if( currSum < target){
                    count += right - left;
                    left++;
                }else if(currSum >=target){
                    right--;
                }

            }

        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
//        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}
