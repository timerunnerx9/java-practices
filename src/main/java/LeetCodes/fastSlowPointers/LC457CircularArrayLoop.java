package LeetCodes.fastSlowPointers;

public class LC457CircularArrayLoop {

        public boolean circularArrayLoop(int[] nums) {

            for(int i = 0; i < nums.length; i++){  // go through the array to loop through every element to see if they
                                                   // are in a loop

                boolean isForward = nums[i] > 0;  // find the current direction, if positive then it's going forward
                                                  // by the problem statement, all elements in the loop follow the same direction

                int slow = i, fast = i;   // we use the slow and fast pointer pattern to find out if there's a loop

                do{                        // use do while to run at least once

                    slow = getNextIndex(slow, nums, isForward);
                    fast = getNextIndex(fast, nums, isForward);

                    if(fast != -1){
                        fast = getNextIndex(fast, nums, isForward);  // run fast one more time to meet the slow-fast pattern
                    }
                }while(slow != fast && slow != -1 && fast != -1);


                if(slow != -1 && slow == fast){
                    return true;
                }

            }
            return false;

        }

        public int getNextIndex(int index, int[] nums, boolean isForward){

            boolean direction = nums[index] > 0;   // find the current direction, if it's different from the first, then we
                                                   // don't have a loop
            if(isForward != direction) return -1;

            int newIndex = (index + nums[index]) % nums.length;    // new index is the current index plus the number in the
                                                                   // element, if it's larger than the array's length, we
                                                                   // do a modular
            if(newIndex < 0){         // if the index turns out to be negative, we need to address it by adding the length
                newIndex += nums.length;  // which will be the correct new index
            }

            if(newIndex == index) return -1;   // if the newIndex is the same as the current index, that means we have a
                                               // loop of length 1, which by the problem statement, this is not a valid loop

            return newIndex;


        }

    }

