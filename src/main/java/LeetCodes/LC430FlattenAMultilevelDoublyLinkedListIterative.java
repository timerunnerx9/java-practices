package LeetCodes;

import java.util.Stack;

public class LC430FlattenAMultilevelDoublyLinkedListIterative {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child){
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    };



    public Node flatten(Node head) {
        Stack<Node> stack = new Stack();

        Node curr = head;

        while(curr!=null){
            if(curr.child!=null){
                if(curr.next!=null){
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }else if(curr.next==null && !stack.isEmpty()){
                curr.next = stack.pop();
                curr.next.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}
