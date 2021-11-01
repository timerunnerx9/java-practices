package Educative;

class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        // TODO: Write your code here

        int start = 0, end = 1;

        while(reader.get(end)!= Integer.MAX_VALUE){

            int result = binarySearch(reader, start,end,key);

            if(result==-1){
                end*=2;
            }else{
                return result;
            }

        }

        return -1;
    }



    public static int binarySearch(ArrayReader reader, int left, int right, int key){

        while(left <= right){

            int mid = left + (right - left)/2;

            if(reader.get(mid) < key){
                left = mid + 1;
            }else if(reader.get(mid) > key){
                right = mid - 1;
            }else{
                return mid;
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}
