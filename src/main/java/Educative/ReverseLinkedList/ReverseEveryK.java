package Educative.ReverseLinkedList;

import java.util.*;
public class ReverseEveryK {



    static class  ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

        public static ListNode reverse(ListNode head, int k) {
            // TODO: Write your code here

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode prevPartEnd = dummyHead, currentPartEnd = null, current = head, prev = null, next = null;

            boolean flag = true;

            while(current != null){

                if(flag){
                    currentPartEnd = current;
                    for(int i = 0; i < k && current != null; i++){

                        next = current.next;
                        current.next = prev;
                        prev = current;
                        current = next;

                    }
                    prevPartEnd.next = prev;
                    prevPartEnd = currentPartEnd;
                    flag = !flag;
                }else{

                    for(int j = 0; j < k && current != null;j++){

                        prevPartEnd.next = current;
                        prevPartEnd = prevPartEnd.next;
                        current = current.next;
                    }
                    flag = !flag;

                }

            }




            return dummyHead.next;
        }

        public static void main(String[] args) {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            head.next.next.next.next.next = new ListNode(6);
            head.next.next.next.next.next.next = new ListNode(7);
            head.next.next.next.next.next.next.next = new ListNode(8);

            ListNode result = reverse(head, 2);
            System.out.print("Nodes of the reversed LinkedList are: ");
            while (result != null) {
                System.out.print(result.value + " ");
                result = result.next;
            }
        }
    }

