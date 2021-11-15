package LeetCodes.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC253MeetingRooms2 {


        public static int minMeetingRooms(int[][] intervals) {

            if(intervals.length == 0) return 0;
            if(intervals.length == 1) return 1;

            int[][] currentArray = intervals.clone();

            int count = 0;

            while(currentArray.length > 0){

                if(currentArray.length > 1){
                    currentArray = helper(currentArray);
                    count++;
                }else if(currentArray.length == 1){
                    count++;
                    break;
                }

            }
            return count;



        }

        public static int[][] helper(int[][] inputList){

            Arrays.sort(inputList, (a, b)-> a[1] - b[1]);

            int end = inputList[0][1];

            List<int[]> returnList = new ArrayList<>();

            for(int i = 1; i < inputList.length; i++){

                if(inputList[i][0] < end){
                    returnList.add(new int[]{inputList[i][0], inputList[i][1]});
                }else{
                    end = inputList[i][1];
                }

            }

            return returnList.toArray(new int[returnList.size()][]);
        }


    public static void main(String[] args) {

        minMeetingRooms(new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}});
    }


    }

