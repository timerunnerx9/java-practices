package Educative.backtracking;

import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        // TODO: Write your code here

        Set<List<Integer>> resultSet = new HashSet<>();

        int currentSum = 0;

        boolean[] used = new boolean[arr.length];

        backtrack(triplets,resultSet, used, new ArrayList<Integer>(), arr);

        triplets = new ArrayList<>(resultSet);

        return triplets;
    }

    public static void backtrack(List<List<Integer>> triplets, Set<List<Integer>> resultSet, boolean[] used, List<Integer> tempList, int[] arr ){

        if(tempList.size() == 3){
            int currentSum = 0;
            for(Integer i : tempList){
                currentSum += i;
            }
            if(currentSum==0) {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.addAll(tempList);
                Collections.sort(newList);
                resultSet.add(newList);
            }
        }else{

            for(int j = 0; j < arr.length; j++){
                if(used[j]==true ) continue;
                tempList.add(arr[j]);
                used[j] = true;
                backtrack(triplets, resultSet, used, tempList, arr);
                used[j] = false;
                tempList.remove(tempList.size()-1);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}
