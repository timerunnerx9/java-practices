package LeetCodes.reverseLinkedList;


//  Definition for singly-linked list.
class reverseKGroup{

  public static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode prevPartEnd = null, nextPartStart = null,  current = head, next = null;

        ListNode dummyHead = new ListNode();

        dummyHead.next = head;
        prevPartEnd = dummyHead;

        while(current != null){

            ListNode[] result = reverseForK(current, k);
            nextPartStart = result[0];


            if(nextPartStart == current){
                while(current!= null){

                    prevPartEnd.next = current;
                    prevPartEnd = prevPartEnd.next;
                    current = current.next;

                }
                return dummyHead.next;

            };

            prevPartEnd.next = nextPartStart;

            prevPartEnd = current;

            current = result[1];
        }

        return dummyHead.next;

    }

    public static ListNode[] reverseForK(ListNode node, int k){


        ListNode prev = null, next = null, current = node, countNode = node;
        int count = 0;

        while(count < k){
            if(countNode == null) return new ListNode[]{node,null};
            countNode = countNode.next;
            count++;
        }

        for(int i = 0; i < k; i++){

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return new ListNode[]{prev, current};

    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        reverseKGroup(node1,3);


    }
}
