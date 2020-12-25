package LeetCodes;

public class LC430FlattenAMultilevelDoublyLinkedListRecursive {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(){

        }

    }

    ;

    public Node flatten(Node head) {
        if (head == null) return null;

        Node dummyHead = new Node();
        dummyHead.next = head;

        flattenRecursively(dummyHead, head);

        // the head's prev will be attached with the flattenRecursively function
        dummyHead.next.prev = null;

        return dummyHead.next;
    }

    public Node flattenRecursively(Node prev, Node curr) {

        // this will return the last node
        if (curr == null) return prev;

        prev.next = curr;
        curr.prev = prev;

        Node tempNext = curr.next;

        Node lastNode = flattenRecursively(curr, curr.child);

        curr.child = null;

        return flattenRecursively(lastNode, tempNext);
    }
}
