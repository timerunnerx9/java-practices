package LeetCodes.cyclicSort;

public class LC1539findKthPositive {
        public static int findKthPositive(int[] arr, int k) {
            for(int i : arr){
                if(i <= k) k++; else break;
            }
            return k;
        }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,4,6,8,10},3));
    }
}
