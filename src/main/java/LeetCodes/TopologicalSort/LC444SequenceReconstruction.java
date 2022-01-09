package LeetCodes.TopologicalSort;

import java.util.*;

public class LC444SequenceReconstruction {

    public static boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {

        List<Integer> orderedList = new ArrayList<>();


        // 1. initialize inDegree and graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer> > graph = new HashMap<>();

        for(int i : nums){
            inDegree.put(i, 0);
        }

        // 2. populate inDegree and create graph

        for(int i = 0; i < sequences.size(); i++){
            List<Integer> currList = sequences.get(i);
            for(int j = 0; j < currList.size() - 1; j++){
                int parent = currList.get(j), child = currList.get(j+1);
                inDegree.put(child, inDegree.get(child) + 1);
                graph.putIfAbsent(parent, new ArrayList<Integer>());
                graph.get(parent).add(child);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
            System.out.print("Key: " + entry.getKey());
            System.out.print(" Value: ");
            for(int i : entry.getValue()){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            System.out.print("Key: " + entry.getKey());
            System.out.print(" Value: " + entry.getValue());

            System.out.println();
        }



        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0) sources.add(entry.getKey());
        }

        while(!sources.isEmpty()){
            if(sources.size() > 1) return false; // at any point if we have more than one candidate in the resources list then
            // then it means we will have more than one topological sort outcome, we just exit
            int vertex = sources.poll();
            orderedList.add(vertex);
            List<Integer> children = graph.get(vertex);
            if(children != null){
                for(int child : children){
                    inDegree.put(child, inDegree.get(child) - 1);
                    if(inDegree.get(child) == 0) sources.add(child);
                }
            }
        }


        return orderedList.size() == nums.length;

    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> input1 = Arrays.asList(new Integer[]{5,2,6,3});
        List<Integer> input2 = Arrays.asList(new Integer[]{4,1,5,2});
        input.add(input1);
        input.add(input2);
        System.out.println(sequenceReconstruction(new int[]{4,1,5,2,6,3}, input));
    }
}
