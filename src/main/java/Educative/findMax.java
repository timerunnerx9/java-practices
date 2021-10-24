package Educative;

class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        // TODO: Write your code here

        int left = 0, right = arr.length - 1;

        while(left < right){
            int midIndex = left + (right - left)/2;   //find the middle index

            // do the search in the larger part because we are looking for the biggest value
            if(arr[midIndex] < arr[midIndex + 1]){   // if the the value at midIndex + 1 is larger than the value at mid
                left = midIndex + 1;    // do the search on the larger part [ mid + 1 --- end ]
            }else{
                right = midIndex;   // if the value at the midIndex + 1 is lesser than the value at mid, do the search in
                // [ begin -- mid ]
            }


        }

        return arr[left];
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
    }
}
