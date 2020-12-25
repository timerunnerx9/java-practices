package GeneralProblems;

public class HillNumbers {

    public static void main(String[] args) {

        validMountainArray(new int[]{0,3,2,1});
    }

    public static boolean validMountainArray(int[] arr) {

        if(arr.length<3) return false;

        int slow = 0;
        int fast = 1;
        while(fast<arr.length){
            if(arr[fast++]<=arr[slow++]){
                return false;
            }
        }

        if (fast == arr.length-1) return false;

        int fastest = fast+1;

        while(fastest < arr.length){
            if(arr[fastest++]>=arr[fast++]){
                return false;
            }
        }

        return true;

    }
}
