package LeetCodes;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRoomsIIHeap {
    public int minMeetingRooms(int[][] intervals) {
        // null check
        if(intervals == null || intervals.length<1) return 0;

        // sort the array
        Arrays.sort(intervals,(int[] a, int[] b)->(a[0] - b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (int[] a, int[] b)->(a[1]-b[1])
        );

        minHeap.offer(intervals[0]);

        for(int i = 1;i<intervals.length;i++){
            if(minHeap.peek()[1]<=intervals[i][0]){
                //means you dont need a new room
                minHeap.poll(); //removing the one with the earliest end time
            }
            minHeap.offer(intervals[i]);
        }
        return minHeap.size();
    }

}
