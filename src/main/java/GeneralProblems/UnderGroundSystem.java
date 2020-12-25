package GeneralProblems;

import java.util.HashMap;

public class UnderGroundSystem {
    static class UndergroundSystem {

        HashMap<Integer, Trip> trips = new HashMap<Integer, Trip>();

        final String DELIMITER  = ",";

        HashMap<String, TimeSummary> timeTable =  new HashMap<String,TimeSummary>();


        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {

            Trip temp = new Trip(stationName,t);
            trips.put(id,temp);
        }

        public void checkOut(int id, String stationName, int t) {

            Trip temp1 = trips.get(id);

            String timeTableKey = temp1.getStationName()+DELIMITER+stationName;

            double travelTime = t - temp1.getT();

            if(timeTable.containsKey(timeTableKey)){

                TimeSummary temp = timeTable.get(timeTableKey);

                double newT = temp.getTotalTime() + travelTime;
                int newCount = temp.getCounts() + 1;

                timeTable.put(timeTableKey, new TimeSummary(newT,newCount));
                trips.remove(id);
            }else{
                TimeSummary temp = new TimeSummary(travelTime, 1);
                timeTable.put(timeTableKey,temp);
                trips.remove(id);
            }

        }

        public double getAverageTime(String startStation, String endStation) {

            String timeTableKey = startStation+DELIMITER+endStation;

            if(timeTable.containsKey(timeTableKey)){
                TimeSummary temp = timeTable.get(timeTableKey);
                double totalTime = temp.getTotalTime();
                int counts = temp.getCounts();

                return totalTime/counts;
            }
            else{
                return 0;
            }
        }

        public class Trip{
            private String stationName;

            private double t;

            public Trip(String stationName, double t){
                this.stationName = stationName;
                this.t = t;
            }

            public double getT(){
                return this.t;
            }

            public String getStationName(){
                return this.stationName;
            }
        }

        public class TimeSummary{



            private double totalTime;

            private int counts;

            public TimeSummary(double totalTime, int counts){

                this.totalTime = totalTime;
                this.counts = counts;
            }

            public double getTotalTime(){
                return this.totalTime;
            }

            public int getCounts(){
                return this.counts;
            }

            public void setTotalTime(int t){
                this.totalTime = t;
            }

            public void setCount(int i){
                this.counts = i;
            }

        }


    }


   public static void main(String[] args) {
        UndergroundSystem obj = new UndergroundSystem();
         obj.checkIn(45,"Leyton",3);
         obj.checkOut(45,"Waterloo",15);
        obj.checkIn(32,"Leyton",10);
        obj.checkOut(32,"Waterloo",20);
         double param_3 = obj.getAverageTime("Leyton","Waterloo");
       System.out.println(param_3);
   }

}
