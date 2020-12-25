package GeneralProblems;

public class InsertNumber {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {

        Node dummyHead = new Node();
        dummyHead.next = head;

        Node newNode = new Node(insertVal);

        if(head == null){
            newNode.next = newNode;
            return newNode;
        }


        if(head.next == null){
            if(head.val>insertVal){
                newNode.next = head;
                head.next = newNode;
                return newNode;
            }else{
                head.next = newNode;
                newNode.next = head;
                return head;
            }
        }


        while(head!=null){
            Node tempNext = head.next;

            if(head.val <= insertVal && tempNext.val >= insertVal){
                head.next = newNode;
                newNode.next = tempNext;
                break;
            }else{
                head = head.next;
            }
        }

        return dummyHead.next;


    }
}
