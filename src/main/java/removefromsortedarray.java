public class removefromsortedarray {


    public static void main(String[] args) {
        removeElementFromSortedArray(new int[]{1,1,1,2, 2, 3,});
        System.out.println(removeElementFromSortedArray(new int[]{1,1,1,2, 2, 3,}));
    }

    public static int removeElementFromSortedArray(int[] nums) {

        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j]!=nums[i]) {
                i++;
                nums[i]=nums[j];
            }

        }
        return i+1;

    }
}
