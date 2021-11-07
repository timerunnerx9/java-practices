package Educative.TwoPointers;

import java.util.Arrays;

public class ShortestWindowSort {

        public static int sort(int[] arr) {
            // TODO: Write your code here

            int[] arrCopy = arr.clone();
            Arrays.sort(arrCopy);

            int left = 0, right = arrCopy.length - 1;

            while(left < right){

                while(arr[left] == arrCopy[left] && left < right){
                    left++;
                }

                while(arr[right] == arrCopy[right] && left < right){
                    right--;
                }

                break;

            }

            return right - left ==0? 0: right - left + 1;
        }


    public static void main(String[] args) {
        sort(new int[]{1,2,3});
    }
    }

