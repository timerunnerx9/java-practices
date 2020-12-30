package LeetCodes;

import java.util.*;

public class LC207CourseSchedule_topological_sort {

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // create a indegree array
            int[] indegree = new int[numCourses];

            // create a graph
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for(int i = 0; i< prerequisites.length; i++){
                indegree[prerequisites[i][0]]++;

                if(graph.containsKey(prerequisites[i][1])){
                    graph.get(prerequisites[i][1]).add(prerequisites[i][0]);

                }else{
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(prerequisites[i][0]);
                    graph.put(prerequisites[i][1],tempList);
                }
            }

            // do a bfs
            // create a queue

            Queue<Integer> queue = new LinkedList<>();

            // add all courses without prerequisites to the queue
            for(int i = 0; i<indegree.length; i++){
                if(indegree[i]==0) queue.offer(i);
            }

            // bfs

            while(!queue.isEmpty()){
                int temp = queue.poll();
                List<Integer> courses = graph.get(temp);
                if(courses!=null){
                    for(int j = 0; j < courses.size(); j++){
                        int index = courses.get(j);
                        indegree[index]--;

                        if(indegree[index]==0){
                            queue.offer(index);
                        }
                    }
                }
            }

            // check if there's any edges that we have not traverse through in the indegree array,
            // if yes that means the graph has a circle
            for(int k : indegree){
                if(k!=0) return false;
            }

            // finish topological sort, we can traverse the graph without problem
            return true;
        }

    }

