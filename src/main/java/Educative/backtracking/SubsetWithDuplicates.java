package Educative.backtracking;

import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // TODO: Write your code here

        Arrays.sort(nums);

        subsets.add(new ArrayList<Integer>());
        int setStartIndex = 0, setEndIndex = 0;

        for(int i = 0; i < nums.length; i++){
            setStartIndex = 0;


            if(i > 0 && nums[i] == nums[i-1]){
                setStartIndex = setEndIndex + 1;
            }

            setEndIndex = subsets.size() - 1;

            for(int j = setStartIndex; j <= setEndIndex; j++){
                List<Integer> currentSet = new ArrayList<Integer>(subsets.get(j));
                currentSet.add(nums[i]);
                subsets.add(currentSet);
            }

        }

        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}