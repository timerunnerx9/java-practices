package Educative;


    class MinSizeSubArraySum {
        public static int findMinSubArray(int S, int[] arr) {
            // TODO: Write your code here

            int currentSum = 0, left = 0, right = 0, windowLength = Integer.MAX_VALUE, globalLength = Integer.MAX_VALUE;

            while (right < arr.length) {

                currentSum += arr[right];

                while (currentSum >= S) {

                    windowLength = right - left + 1;
                    globalLength = Math.min(windowLength, globalLength);
                    currentSum -= arr[left];
                    left++;

                }
                right++;
            }


            return globalLength == Integer.MAX_VALUE ? 0 : globalLength;

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

