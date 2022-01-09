package Educative.modifiedBinarySearch;

public class Order_agnosticBinarySearch {

        public static int search(int[] arr, int key) {
            // TODO: Write your code here

            int left = 0, right = arr.length - 1;

            boolean asc = arr[left] > arr[right] ? true : false;

            while(left <= right){

                int mid = left + (right - left) /2 ;

                if(asc){

                    if(arr[mid] < key){
                        left = mid + 1;

                    }else if(arr[mid] > key){
                        right = mid - 1;

                    }else if(arr[mid] == key){
                        return mid;
                    }
                }else{

                    if(arr[mid] < key){
                        right = mid - 1;

                    }else if(arr[mid] > key){
                        left = mid + 1;

                    }else if(arr[mid] == key){
                        return mid;
                    }


                }

            }


            return -1;
        }

        public static void main(String[] args) {
            System.out.println(search(new int[] { 4, 6, 10 }, 10));
            System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
            System.out.println(search(new int[] { 10, 6, 4 }, 10));
            System.out.println(search(new int[] { 10, 6, 4 }, 4));
        }

}
