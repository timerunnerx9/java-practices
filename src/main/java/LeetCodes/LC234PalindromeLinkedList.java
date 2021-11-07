package LeetCodes;

public class LC234PalindromeLinkedList {

    /**
     * Definition for singly-linked list.
     * */
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



        ListNode frontNode; // initialize the variable here because we are going to use this later in every recursion

        public boolean isPalindrome(ListNode head) {

            frontNode = head; // frontNode is the node from the front that we are gonna compare with later

            return check(head); // put it in the recursive method
        }


        public boolean check(ListNode node){

            if(node != null){ // check if we are at the end, if yes we can't do any comparison

                if(!check(node.next)) return false; // if in the next check method we get any "false" we return false and let
                // it bubble up

                if(node.val != frontNode.val) return false;  // we are at the correct position to compare with frontNode, if
                // the values are not the same, we return false

                frontNode = frontNode.next;  // we passed the value check, set frontNode to the next node

            }

            return true;  // if we passed all the checks we return true
        }
    }

