package LeetCodes.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class LC986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList<>();

        int i = 0, j = 0;

        while( i < firstList.length && j < secondList.length ){

            if((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1])
                    || (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])){
                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                result.add(new int[]{start,end});
            }


            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
