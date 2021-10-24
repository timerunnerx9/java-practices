package Educative;

public class SortedArraySquares {


    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        // TODO: Write your code here
        int left = 0, right = arr.length - 1, largestNumberIndex = arr.length - 1;

        while(left <= right){
            int leftSquared = arr[left] * arr[left];
            int rightSquared = arr[right] * arr[right];

            if(leftSquared <= rightSquared){
                squares[largestNumberIndex] = rightSquared;
                right--;
            }else{
                squares[largestNumberIndex] = leftSquared;
                left++;
            }

            largestNumberIndex--;

        }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
