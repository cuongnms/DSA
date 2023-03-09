package linkedlist;

public class LinkedList {
    private Node head;

    public void travel(){
        if(head == null){
            return;
        }
        Node travel = head;
        do {
            System.out.println(travel.getData());
            travel = travel.getNextNode();
        } while(travel != null);
    }

    public void insertLastData(int data){
        Node insertNode = new Node(data);
        if(head == null){
            head = insertNode;
            return;
        }
        Node travel = head;
        while(travel.getNextNode() != null){
            travel = travel.getNextNode();
        }
        travel.setNextNode(insertNode);
    }

    public void insertFirstData(int data){
        Node insertNode = new Node(data);
        if(head == null){
            head = insertNode;
            return;
        }
        insertNode.setNextNode(head);
        head = insertNode;
    }

    public void insertRandom(int data, int indexInsert){
        if(head == null){
            head = new Node();
            return;
        }
        Node travel = head;
        for(int i = 0; i < indexInsert; i++){
            travel = travel.getNextNode();
        }
        Node insertNode = new Node(data);
        Node nextCurrentNode = travel.getNextNode();
        travel.setNextNode(insertNode);
        insertNode.setNextNode(nextCurrentNode);

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertFirstData(0);
        list.insertLastData(1);
        list.insertLastData(2);
        list.insertLastData(3);
        list.insertLastData(4);
        list.insertLastData(5);
        list.insertLastData(6);
        list.insertLastData(7);
        list.insertLastData(8);
        list.insertLastData(9);
        list.insertRandom(1000, 5);
        list.travel();
    }
}
