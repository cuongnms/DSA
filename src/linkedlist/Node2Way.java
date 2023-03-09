package linkedlist;

public class Node2Way {
    private Node2Way previous;
    private Node2Way next;
    private int data;

    public Node2Way(Node2Way previous, Node2Way next, int data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node2Way(int data) {
        this.data = data;
    }

    public Node2Way getPrevious() {
        return previous;
    }

    public void setPrevious(Node2Way previous) {
        this.previous = previous;
    }

    public Node2Way getNext() {
        return next;
    }

    public void setNext(Node2Way next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
