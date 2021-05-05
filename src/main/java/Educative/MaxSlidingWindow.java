package Educative;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MaxSlidingWindow{
    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        if(arr.length ==0 || arr==null || arr.length < windowSize) return result;

        ArrayDeque<Integer> indexDeque = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){

            if(!indexDeque.isEmpty() && indexDeque.peekFirst()==(i-windowSize)){
                indexDeque.pollFirst();
            }

            while(!indexDeque.isEmpty() && arr[indexDeque.peekLast()]<arr[i]){
                indexDeque.pollLast();
            }

            indexDeque.offer(i);

            if(i-windowSize+1>=0){
                result.offer(arr[indexDeque.peekFirst()]);
            }

        }


        return result;
    }

    public static void main(String[] args) {

//        int[] array =  {1, 2, 3, 4, 3, 2, 1, 2, 5};
//        System.out.println("Array = " + Arrays.toString(array));
//        findMaxSlidingWindow(array,4);
//
//        System.out.println("Max = " + findMaxSlidingWindow(array, 4));
//
//        int[] array2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
//        System.out.println("Array = " + Arrays.toString(array2));
//        System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
        System.out.println(1/2);
    }
}
