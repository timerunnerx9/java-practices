package Educative.modifiedBinarySearch;

public class searchInBitonicArray {


        public static int search(int[] arr, int key) {
            // TODO: Write your code here

            int start = 0, end = arr.length - 1, result = -1;

            while(start < end){

                int mid = start + (end - start)/2;

                if(arr[mid] > arr[mid + 1]){
                    end = mid;
                }else{
                    start = mid + 1;
                }

            }
            System.out.println(start);

            int peak = start;

            start = 0; end = peak;

            while(start <= end){

                int mid = start + (end-start)/2;

                if(arr[mid] > key){
                    end = mid - 1;
                }else if(arr[mid] < key){
                    start = mid + 1;
                }else{
                    result = mid;
                }

            }

            if(result != -1){
                return result;
            }

            start = peak;
            end = arr.length - 1;
            while(start <= end){

                int mid = start + (end - start) /2;
                if(arr[mid] > key){
                    start = mid + 1;
                }else if(arr[mid] < key){
                    end = mid - 1;
                }else{
                    result = mid;
                }
            }


            return result;



        }



        public static void main(String[] args) {
            System.out.println(search(new int[] { 1, 3, 8, 4, 3 }, 4));
            System.out.println(search(new int[] { 3, 8, 3, 1 }, 8));
            System.out.println(search(new int[] { 1, 3, 8, 12 }, 12));
            System.out.println(search(new int[] { 10, 9, 8 }, 10));
        }
    }

