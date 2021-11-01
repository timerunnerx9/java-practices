package Educative.SlidingWindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // TODO: Write your code here

        int left = 0, right = 0, currSize = 0, currSum = 0, globalSize = Integer.MAX_VALUE;

        while(left <= right && right < arr.length){

            currSum += arr[right];
            while(currSum >= S){
                currSize = right - left + 1 ;
                globalSize = Math.min(currSize, globalSize);
                currSum -= arr[left];
                left++;
            }
            right++;


        }

        return globalSize;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
