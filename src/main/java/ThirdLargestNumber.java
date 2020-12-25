import java.util.Arrays;

public class ThirdLargestNumber {
    public static void main(String[] args) {

        thirdMax(new int[]{2,2,3,1});
        System.out.println( thirdMax(new int[]{2,2,3,1}));
    }

    public static int thirdMax(int[] nums) {

        if(nums.length<2){
            Arrays.sort(nums);
            return nums[nums.length-1];
        }

        Arrays.sort(nums);

        int i = nums.length-1;
        int j = i-1;
        while(j>=0){
            if(nums[i]==nums[j]){
                nums[j-1]=nums[i];
                j--;
            }
            i--;
        }


        return nums[nums.length-3];
    }
}
