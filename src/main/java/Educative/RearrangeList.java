package Educative;


class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {


    public static void reorder(ListNode head) {
        // TODO: Write your code here

        ListNode slow = head, fast = head, mid;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        mid = slow;

        ListNode dummyHead = head;

        recursiveRebuild(mid, dummyHead);

        while(head != null && dummyHead != null){

            rearrange(head, dummyHead.next);
            dummyHead = dummyHead.next;
        }



    }


    public static void recursiveRebuild(ListNode node, ListNode dummyHead){

        if(node != null){
            recursiveRebuild(node.next,dummyHead);
            dummyHead.next = node;
        }

    }

    public static ListNode rearrange(ListNode mainNode, ListNode insertNode){

        ListNode tempNode = mainNode.next;
        mainNode.next = insertNode;
        insertNode.next = tempNode;
        return mainNode;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}