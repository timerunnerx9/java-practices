package Educative.kWayMerge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallestEle {


    static class Element{

        int val;
        int fromIndex;
        int eleIndex;

         public  Element(int val, int listIndex,int eleIndex){
            this.val = val;
            this.fromIndex = fromIndex;
            this.eleIndex = eleIndex;

        }


    }

        public static int findKthSmallest(List<Integer[]> lists, int k) {
            // TODO: Write your code here

            PriorityQueue<Element> minHeap = new PriorityQueue<Element>( (a, b)-> a.val - b.val);

            for(int i = 0; i < lists.size(); i++){

                int first = lists.get(i)[0];
                Element newEle = new Element(first, i, 0);
                minHeap.offer(newEle);

            }

            int count = 0;
            int result = 0;
            while(!minHeap.isEmpty()){
                Element curr = minHeap.poll();
                int listIndex = curr.fromIndex;
                int eleIndex = curr.eleIndex;
                result = lists.get(listIndex)[eleIndex];

                count++;
                if(count == k){
                    break;
                }

                if( eleIndex + 1 < lists.get(listIndex).length){
                    Element eleToAdd = new Element(lists.get(listIndex)[eleIndex+1], listIndex, eleIndex+1);
                    minHeap.offer(eleToAdd);
                }

            }
            return result;
        }



    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }

}
