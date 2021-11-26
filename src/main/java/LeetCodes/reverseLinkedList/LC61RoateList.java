package LeetCodes.reverseLinkedList;

public class LC61RoateList {


//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
         ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

        public ListNode rotateRight(ListNode head, int k) {

            if(head == null || head.next == null || k < 1) return head;

            ListNode countNode = head;

            int length = 0;

            while(countNode!=null){
                countNode = countNode.next;
                length++;
            }

            int step = k % length;

            if(step == 0) return head;

            ListNode fast = head, current = head;

            for(int i = 0; i < step; i++){
                fast = fast.next;
            }

            while(fast.next != null){
                fast = fast.next;
                current = current.next;
            }

            fast.next = head;
            ListNode newHead = current.next;
            current.next = null;

            return newHead;
        }
    }

