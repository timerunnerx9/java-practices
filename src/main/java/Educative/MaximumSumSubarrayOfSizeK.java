package Educative;

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here

        int windowSum = 0, globalSum = 0, left = 0, right = 0;

        while(right < arr.length-1 ){

            windowSum += arr[right];
            right++;

            if( (right - left)==k ){
                globalSum = Math.max(windowSum, globalSum);
                windowSum -= arr[left];
                left++;
            }

        }

        return globalSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
