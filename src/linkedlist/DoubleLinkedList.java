package linkedlist;

public class DoubleLinkedList {
    private Node2Way head;
    private Node2Way tail;
    private int length;

    public DoubleLinkedList(int headData, int tailData) {
        head = new Node2Way(headData);
        tail = new Node2Way(tailData);
        length = 2;
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public void insertAtIndex(int data, int index){
        if(index < 0 || index > length - 1){
            System.out.println("Invalid index");
            return;
        }
        Node2Way nodeBefore = head;
        for(int i = 0 ; i < index - 1; i ++){
            nodeBefore = nodeBefore.getNext();
        }
        Node2Way nodeInsert = new Node2Way(data);
        Node2Way nodeAfter = nodeBefore.getNext();

        nodeInsert.setPrevious(nodeBefore);
        nodeInsert.setNext(nodeAfter);

        nodeBefore.setNext(nodeInsert);
        nodeAfter.setPrevious(nodeInsert);

    }

    public void deleteAtIndex(int data, int index){

    }


}
