package LeetCodes.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC57InsertIntervals {

        public static int[][] insert(int[][] intervals, int[] newInterval) {


            List<List<Integer>> returnList = new ArrayList<>();

            if(intervals.length == 0 ) return new int[][] { {newInterval[0],newInterval[1]} };

            int i = 0;

            while(i < intervals.length && intervals[i][1] < newInterval[0]){

                List<Integer> tempList = new ArrayList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[i][1]);
                returnList.add(tempList);

            }

            while(i < intervals.length && intervals[i][0] <= newInterval[1]){

                int start = Math.min(intervals[i][0], newInterval[0]);
                int end = Math.max(intervals[i][1], newInterval[1]);

                returnList.add(Arrays.asList(start,end));

            }

            while(i < intervals.length){
                returnList.add(Arrays.asList(intervals[i][0], intervals[i][1] ));
            }

            int[][] returnArray = new int[returnList.size()][2];

            for(int j = 0; j < returnList.size(); j++){
                returnArray[j][0] = returnList.get(j).get(0);
                returnArray[j][1] = returnList.get(j).get(1);
            }

            return returnArray;
        }

    public static void main(String[] args) {
        System.out.println(insert(new int[][]{{1,3},{6,9}}, new int[]{2,5}));
    }

    }

