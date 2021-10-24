package Educative;
import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Write your code here

        backtrack(result, new ArrayList<Integer>(), nums);

        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums){

        if(tempList.size() == nums.length){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                tempList.remove(tempList.size()-1);
            }

        }

    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
