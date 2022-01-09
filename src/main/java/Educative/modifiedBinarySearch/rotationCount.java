package Educative.modifiedBinarySearch;

public class rotationCount {

        public static int countRotations(int[] arr) {
            // TODO: Write your code here


            int left = 0, right = arr.length - 1;

            while(left < right){

                int mid = left + (right - left) / 2;

                if(mid > 0 && arr[mid] < arr[mid - 1]) return mid;

                if( arr[left] <= arr[mid] && arr[mid] > arr[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }

            }

            return arr[left];
        }

        public static void main(String[] args) {
            System.out.println(countRotations(new int[] { 7,8,9,2,3,4,5}));
            System.out.println(countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
            System.out.println(countRotations(new int[] { 1, 3, 8, 10 }));
        }
    }


