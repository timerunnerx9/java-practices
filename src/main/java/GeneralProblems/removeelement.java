package GeneralProblems;

public class removeelement {


    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3,},3);

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while(i<n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else{
                i++;
            }
        }

        return i;
    }
}
