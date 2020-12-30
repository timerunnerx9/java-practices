package LeetCodes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC146LRUCache_handmade {



        private int capacity;
        private HashMap<Integer,Node> map;

        private Node head;
        private Node tail;


        public class Node{
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key,int value){
                this.key = key;
                this.value = value;
            }

            public Node(){

            }

        }

        public void addNode(Node node){
            Node originHead = head.next;

            head.next = node;

            node.prev = head;

            node.next = originHead;

            originHead.prev = node;



        }


        public void removeNode(Node node){

            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

        }


        public LC146LRUCache_handmade(int capacity) {
            map = new HashMap<Integer,Node>(capacity);
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            int result = -1;
            Node node = map.get(key);
            if(node!=null){
                result = node.value;
                removeNode(node);
                addNode(node);
            }

            return result;
        }

        public void put(int key, int value) {
            Node newNode = new Node(key,value);
            Node existNode = map.get(key);
            if(existNode!=null){
                removeNode(existNode);

            }else{
                if(map.size()==capacity){
                    Node tailNode = tail.prev;
                    removeNode(tailNode);
                    map.remove(tailNode.key);
                }
            }
            map.put(key,newNode);
            addNode(newNode);

        }


    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */



    public static void main(String[] args) {
        LC146LRUCache_handmade obj = new  LC146LRUCache_handmade(2);

        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */