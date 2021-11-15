package LeetCodes.MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC759EmployeeFreeTime {

// Definition for an Interval.
 static class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};


        public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {


            List<Interval> result = new ArrayList<>();

            List<Interval> freeInterval = new ArrayList<>();

            for(int i = 0; i < schedule.size(); i++){

                if(schedule.get(i).size() < 2) continue;
                Interval previous = schedule.get(i).get(0);

                for(int j = 1; j < schedule.get(i).size(); j++){

                    Interval newInterval = new Interval( previous.end, schedule.get(i).get(j).start);
                    freeInterval.add(newInterval);
                    previous = schedule.get(i).get(j);

                }

            }

            Collections.sort(freeInterval, (a, b)-> a.start - b.start);

            int currentStart = freeInterval.get(0).start;
            int currentEnd = freeInterval.get(0).end;

            for(int k = 1; k < freeInterval.size(); k++){

                if(freeInterval.get(k).start < currentEnd){
                    currentStart = Math.max(freeInterval.get(k).start, currentStart);
                    currentEnd = Math.min(currentEnd, freeInterval.get(k).end);
                }else{
                    result.add(new Interval(currentStart,currentEnd));
                    currentStart = freeInterval.get(k).start;
                    currentEnd = freeInterval.get(k).end;
                }

            }

            result.add(new Interval(currentStart,currentEnd));

            return result;

        }

    public static void main(String[] args) {
            List<List<Interval>> list = new ArrayList<>();
            List<Interval> list1 = new ArrayList<>(Arrays.asList(new Interval(1,3), new Interval(6,7)));
            List<Interval> list2 = new ArrayList<>(Arrays.asList(new Interval(2,4)));
            List<Interval> list3 = new ArrayList<>(Arrays.asList(new Interval(2,5), new Interval(9,12)));
            list.add(list1);
            list.add(list2);
            list.add(list3);
            List<Interval> resultList = employeeFreeTime(list);
            for(Interval i : resultList){
                System.out.println(String.format("Start: %s End: %s", i.start,i.end));
            }
    }
    }

