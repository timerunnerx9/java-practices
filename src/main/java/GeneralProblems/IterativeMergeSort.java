package GeneralProblems;

import java.util.ArrayList;
import java.util.List;

public class IterativeMergeSort {

    public int[] sortArray(int[] nums) {

        if(nums==null || nums.length ==0) return nums;
        mergeSort(nums);

        return nums;

    }

    private void mergeSort(int[] nums){
        for(int size =1; size< nums.length; size*=2){
            for(int i = 0; i<nums.length-size; i+=2*size){
                int mid = i + size -1;
                int end = Math.min(i+2 * size -1, nums.length-1);
                merge(nums,i,mid,end);
            }
        }
    }

    private void merge(int[] nums,int start,int mid, int end){
        int[] tmp = new int[end-start+1];
        int i  = start, j = mid + 1, k=0;
        while(i<=mid || j<=end){
            if(i>mid || j <=end && nums[i] > nums[j]){
                tmp[k++] = nums[j++];
            }else{
                tmp[k++] = nums[i++];
            }
        }
        System.arraycopy(tmp,0,nums,start,end-start+1);
    }
}
