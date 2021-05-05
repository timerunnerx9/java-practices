package GeneralProblems;

import java.util.Arrays;

public class QuickSortArray {

    public static void main(String[] args) {


        int[] array = new int[] { 12, 13, 10, 3, 6, 90, 70,1 };

        // Let's sort using quick sort
        quickSort( array, 0, array.length - 1 );

        // Verify sorted array
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr, int left, int right){
        if(arr.length == 0 || arr == null){
            return;
        }

        if(left>=right){
            return;
        }

        int mid = left + (right - left)/2;
        int pivot = arr[mid];

        int i = left, j = right;

        while(i <= j){

            while(arr[i] < pivot){
                i++;
            }

            while(arr[j] > pivot){
                j--;
            }

            if(i<=j){
                swap(arr, i, j);
                i++;
                j--;
            }

        }

        if(left < j){
            quickSort(arr, left, j);
        }

        if(right > i){
            quickSort(arr, i, right);
        }


    }


    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
