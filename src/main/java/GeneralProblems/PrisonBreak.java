package GeneralProblems;

import java.util.*;

public class PrisonBreak {
    public static void main(String[] args) {

        int N = 3, M = 3;

        // Given arrays
        int[] H = { 2 };
        int[] V = { 2 };

        // Function call to find the largest
        // area when a series of horizontal &
        // vertical bars are removed
        largestArea(N, M, H, V);

    }

    static void largestArea(int N, int M, int[] H, int[] V){

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 1; i < N + 2; i++){
            set1.add(i);
        }

        for(int i = 1; i < M + 2; i++){
            set2.add(i);
        }

        for(int i = 0; i< H.length; i++){
            set1.remove(H[i]);
        }

        for(int i = 0; i < V.length; i++){
            set2.remove(V[i]);
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        Iterator it1 = set1.iterator();
        Iterator it2 = set2.iterator();

        while(it1.hasNext()){
            list1.add((Integer) it1.next());
        }

        while(it2.hasNext()){
            list2.add((Integer) it2.next());
        }

        int maxH = 0, pointer1 = 0, maxV = 0, pointer2 = 0;

        for(int i = 0; i < list1.size(); i++){
            maxH = Math.max(maxH, list1.get(i)-pointer1);
            pointer1 = list1.get(i);
        }

        for(int i = 0; i < list2.size(); i++){
            maxV = Math.max(maxV, list2.get(i)-pointer2);
            pointer2 = list2.get(i);
        }

        System.out.println(maxH * maxV);

    }


}
