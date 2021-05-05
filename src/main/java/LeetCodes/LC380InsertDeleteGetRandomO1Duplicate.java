package LeetCodes;

import java.util.*;

public class LC380InsertDeleteGetRandomO1Duplicate {

    class RandomizedSet{
        ArrayList<Integer> nums;
        HashMap<Integer, Set<Integer>> locs;
        Random rand = new Random();

        public RandomizedSet(){
            nums = new ArrayList<>();
            locs = new HashMap<Integer, Set<Integer>>();
        }

        public boolean insert(int val){
            boolean contain = locs.containsKey(val);
            if(!contain) locs.put(val, new HashSet<Integer>());
            locs.get(val).add(nums.size());
            nums.add(val);
            return !contain;

        }

        public boolean remove(int val){
            boolean contain = locs.containsKey(val);
            if(!contain) return false;
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);

            if(loc < nums.size()-1){
                int lastone = nums.get(nums.size()-1); // get the last element
                nums.set(loc,lastone); // set the removed location to the last one
                locs.get(lastone).remove(nums.size()-1); // remove the last index from the last element
                locs.get(lastone).add(loc); // add the new locatio to the new value that is taking the old lastone's place
            }

            nums.remove(nums.size()-1);
            if(locs.get(val).isEmpty()) locs.remove(val);
            return true;
        }


        public int getRandom(){
            return nums.get(rand.nextInt(nums.size()));
        }
    }

}
