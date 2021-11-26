package LeetCodes.twoHeaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC480MedianSlidingWindow {

    public static double[] medianSlidingWindow(int[] nums, int k) {


        List<Double> resultList = new ArrayList<>();

        int left = 0, right = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> a-b);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b)-> b-a);

        while(right < nums.length){

            while((right - left ) < k ){

                if(maxHeap.isEmpty() || maxHeap.peek() >= nums[right]){
                    maxHeap.offer(nums[right]);
                }else{
                    minHeap.offer(nums[right]);
                }


                if(maxHeap.size() > minHeap.size()+1){
                    minHeap.offer(maxHeap.poll());
                }else if(minHeap.size() > maxHeap.size()){
                    maxHeap.offer(minHeap.poll());
                }


                right++;

            }


            if(maxHeap.size() == minHeap.size()){

                resultList.add( maxHeap.peek()/2.0 + minHeap.peek()/ 2.0);

            }else{

                resultList.add(maxHeap.peek()*1.0);
            }

            if(maxHeap.peek() >= nums[left]){
                maxHeap.remove(nums[left]);
            }else{
                minHeap.remove(nums[left]);
            }
            left++;


            if(maxHeap.size() > minHeap.size()+1){
                minHeap.offer(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()){
                maxHeap.offer(minHeap.poll());
            }

        }

        double[] result = new double[resultList.size()];

        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
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


        double[] result = medianSlidingWindow(new int[] {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
        }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
