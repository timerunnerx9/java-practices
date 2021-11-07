package LeetCodes;

public class LC206ReverseLinkedList {

      public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseListIteratively(ListNode head) {   // iteratively


        ListNode prev = null, current = null, next = null;

        current = head;

        while(current != null){

            next = current.next; // point to the current next

            current.next = prev; // break current next and point to the previous

            prev = current; // move prev to point to current

            current = next; // point current to the next
        }

        return prev;

    }

    public static ListNode reverseListRecursively(ListNode head){ //recursively


          if(head == null || head.next == null){
              return head; // reach the end of the linked list
          }

          ListNode newHead = reverseListRecursively(head.next); // this will be the new head we are going to return
          head.next.next = head;   // if we have 1,2,3,4,5, this will be 4.next.next = 4, which will be 5.next = 4
          head.next = null;   // this will be 4.next = null, breaking the 4.next = 5 link. When we get to 1, this will be the
                              // tail of the linkedlist

          return newHead; // new head will always be 5, we are returning the same head in every recursion



    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(reverseListRecursively(head));

    }
}
