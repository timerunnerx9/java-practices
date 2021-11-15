package LeetCodes.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

        public static int[][] merge(int[][] intervals) {

            if(intervals.length < 2) return intervals;

            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(intervals, (int[] a, int[] b)-> (a[0] - b[0]));

            int currentStart = intervals[0][0];
            int currentEnd = intervals[0][1];

            for(int i = 1; i < intervals.length; i++){

                int iStart = intervals[i][0];
                int iEnd = intervals[i][1];


                if(iStart <= currentEnd){
                    currentEnd = Math.max(currentEnd, iEnd);
                }else{
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(currentStart);
                    tempList.add(currentEnd);
                    result.add(tempList);
                    currentStart = iStart;
                    currentEnd = iEnd;
                }

            }

            int[][] returnResult = new int[result.size()][2];

            for(int j = 0; j < result.size(); j++){

                returnResult[j][0] = result.get(j).get(0);
                returnResult[j][1] = result.get(j).get(1);

            }

            return returnResult;


        }

    public static void main(String[] args) {
        merge(new int[][]{{1,3},{8,10},{2,6},{15,18}});



    }
    }

