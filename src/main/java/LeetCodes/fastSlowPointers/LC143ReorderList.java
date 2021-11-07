package LeetCodes.fastSlowPointers;

public class LC143ReorderList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

     class Solution {
        public void reorderList(ListNode head) {

            ListNode slow = head, fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode firstHalf = head;
            ListNode secondHalf = reverseLinkedList(slow);

            while(firstHalf != null && secondHalf != null){

                ListNode firstHalfNext = firstHalf.next;
                ListNode secondHalfNext = secondHalf.next;

                firstHalf.next = secondHalf;
                firstHalf = firstHalfNext;

                secondHalf.next = firstHalf;
                secondHalf = secondHalfNext;


            }

            if(firstHalf != null){
                firstHalf.next = null;
            }





        }

        public ListNode reverseLinkedList(ListNode node){

            if(node == null || node.next ==null){
                return node;
            }

            ListNode newHead = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;

            return newHead;

        }

    }
}
