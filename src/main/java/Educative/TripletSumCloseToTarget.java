package Educative;

import java.util.*;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        // TODO: Write your code here

        int  globalSum = Integer.MAX_VALUE/2;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++){


            globalSum =  helper(arr, i + 1, targetSum, arr[i], globalSum);

        }
        return globalSum;
    }


    public static int helper(int[] arr, int left, int targetSum, int firstNumber, int globalSum){


        int right = arr.length - 1;

        while(left < right ){

            int currentSum = arr[left] + arr[right] + firstNumber;

            int currDiff = Math.abs(currentSum - targetSum);
            int globalDiff = Math.abs(globalSum - targetSum);

            if(currDiff < globalDiff){
                globalSum = currentSum;
            }

            if(currentSum > targetSum){
                right--;
            }else{
                left++;
            }

        }

        return globalSum;


    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] {  1, 1, -1, -1,3 }, -1));
//        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
//        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}
