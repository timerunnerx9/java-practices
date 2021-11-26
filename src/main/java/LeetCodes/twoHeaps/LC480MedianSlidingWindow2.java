package LeetCodes.twoHeaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LC480MedianSlidingWindow2 {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        int start = 0;

        TreeSet<Integer> left = new TreeSet<>((a, b)-> nums[a] != nums[b]? Integer.compare(nums[b], nums[a]) : a - b);
        TreeSet<Integer> right = new TreeSet<>((a,b)-> nums[a] != nums[b]? Integer.compare(nums[a],nums[b]) : a - b);



        for(int i = 0; i < nums.length; i++){

            if(left.isEmpty() || nums[i] <= left.first()){
                left.add(i);
            }else{
                right.add(i);
            }

            // left.add(i);
            // right.add(left.pollFirst());

            if(left.size() > right.size()+1) right.add(left.pollFirst());

            if(right.size() > left.size()) left.add(right.pollFirst());

            if(left.size() + right.size() == k){

                if(left.size() == right.size()){
                    result[start] = nums[left.first()]/2.0 + nums[right.first()] / 2.0;
                }else{
                    result[start] = nums[left.first()] * 1.0;
                }

                if(!left.remove(start)) right.remove(start);
                start++;

            }



        }

        return result;
    }




    public static void main(String[] args) {

//        double[] result = medianSlidingWindow(new int[] { 1, 2, -1, 3, 5 }, 2);
//        System.out.print("Sliding window medians are: ");
//        for (double num : result)
//            System.out.print(num + " ");
//        System.out.println();
//
//
//        result = medianSlidingWindow(new int[] { 1, 2, -1, 3, 5 }, 3);
//        System.out.print("Sliding window medians are: ");
//        for (double num : result)
//            System.out.print(num + " ");


        double[] result = medianSlidingWindow(new int[] {4,2,3,1,4,2}, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
