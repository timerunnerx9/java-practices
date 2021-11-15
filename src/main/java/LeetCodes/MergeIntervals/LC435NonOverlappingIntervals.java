package LeetCodes.MergeIntervals;

import java.util.Arrays;

public class LC435NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

            Arrays.sort(intervals, (a,b)-> a[1] - b[1]); //

            int end = intervals[0][1];
            int count = 1;

            for(int i = 1; i < intervals.length; i++){

                if(intervals[i][0] >= end){
                    count++;
                    end = intervals[i][1];
                }

            }

            return intervals.length - count;
        }


    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{-3035,30075},{1937,6906},{11834,20971},{44578,45600},{28565,37578},{19621,34415},
                {32985,36313},{-8144,1080},{-15279,21851},{-27140,-14703},{-12098,16264},{-36057,-16287},{47939,48626},
                {-15129,-5773},{10508,46685},{-35323,-26257}});
    }
}
