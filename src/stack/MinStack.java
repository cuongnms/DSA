package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {
    class Node {
        int value;
        int min;
        Node nextNode;

        public Node(int value, int min, Node nextNode){
            this.value = value;
            this.min = min;
            this.nextNode = nextNode;
        }
    }

    private Node head;
    public MinStack(){

    }
    public void push(int val) {
        if(head == null){
            head = new Node(val, val, null);
        }else{
            if(val <= head.min){
                Node firstNode = new Node(val, val, head);
                head = firstNode;
            }else{
                Node firstNode = new Node(val, head.min, head);
                head = firstNode;
            }
        }
    }

    public void pop() {
        head = head.nextNode;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.min;
    }

}
