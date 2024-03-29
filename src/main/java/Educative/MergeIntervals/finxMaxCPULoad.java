package Educative.MergeIntervals;

import java.util.*;

public class finxMaxCPULoad {


    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    };

    static class MaximumCPULoad {

        public static int findMaxCPULoad(List<Job> jobs) {
            // TODO: Write your code here


            Collections.sort(jobs, (a, b)-> a.start - b.start);

            PriorityQueue<Job> minHeap = new PriorityQueue<Job>( (a, b)-> a.end - b.end);

            minHeap.offer(jobs.get(0));

            int maximumLoad = -1;
            int currentLoad = jobs.get(0).cpuLoad;

            for(int i = 1; i < jobs.size(); i++){

                if(jobs.get(i).start < minHeap.peek().end){
                    currentLoad = currentLoad + jobs.get(i).cpuLoad;
                    maximumLoad = Math.max(maximumLoad, currentLoad);

                }else{
                    currentLoad = jobs.get(i).cpuLoad;
                    maximumLoad = Math.max(maximumLoad, currentLoad);
                }

                minHeap.offer(jobs.get(i));

            }

            return maximumLoad;
        }


    }
    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }

}
