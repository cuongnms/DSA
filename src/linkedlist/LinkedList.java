package linkedlist;

public class LinkedList {
    private Node head;
    private int length;

    public void travel(){
        if(head == null){
            return;
        }
        Node travel = head;
        do {
            System.out.println(travel.getData());
            travel = travel.getNextNode();
        } while(travel != null);
        System.out.println("Length: " + length);
    }

    public void insertLastData(int data){
        Node insertNode = new Node(data);
        if(head == null){
            head = insertNode;
            length++;
            return;
        }
        Node travel = head;
        while(travel.getNextNode() != null){
            travel = travel.getNextNode();
        }
        travel.setNextNode(insertNode);
        length++;
    }

    public void insertFirstData(int data){
        Node insertNode = new Node(data);
        if(head == null){
            head = insertNode;
            length++;
            return;
        }
        insertNode.setNextNode(head);
        head = insertNode;
        length++;
    }

    public void insertRandom(int data, int indexInsert){
        if(head == null){
            head = new Node();
            length++;
            return;
        }
        Node travel = head;
        for(int i = 0; i < indexInsert - 1; i++){
            travel = travel.getNextNode();
        }
        Node insertNode = new Node(data);
        Node nextCurrentNode = travel.getNextNode();
        travel.setNextNode(insertNode);
        insertNode.setNextNode(nextCurrentNode);
        length++;
    }

    public void deleteLastNode(){
        if(head == null){
            System.out.println("No node for delete");
            return;
        }
        if(head.getNextNode() == null){
            head = null;
            length = 0;
            return;
        }
        Node beforeLastNode = head;
        while(beforeLastNode.getNextNode().getNextNode() != null){
            beforeLastNode = beforeLastNode.getNextNode();
        }
        beforeLastNode.setNextNode(null);
        length--;
    }

    public void deleteFirstNode(){
        if(head == null){
            System.out.println("No node for delete");
            return;
        }
        if(head.getNextNode() == null){
            head = null;
            length = 0;
            return;
        }
        Node firstNode = head;
        head = firstNode.getNextNode();
        length--;
    }

    public void deleteRandom(int indexDelete){
        if(head == null){
            return;
        }
        if(indexDelete < 0 || indexDelete > length - 1){
            System.out.println("Index delete invalid");
            return;
        }
        if(indexDelete == 0){
            deleteFirstNode();
            return;
        }
        if(indexDelete == length - 1){
            deleteLastNode();
            return;
        }

        Node preIndexNode = head;
        for(int i = 0 ; i < indexDelete - 1; i++){
            preIndexNode = preIndexNode.getNextNode();
        }
        preIndexNode.setNextNode(preIndexNode.getNextNode().getNextNode());
        length--;
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
//        list.deleteLastNode();
//        list.deleteFirstNode();
//        list.deleteRandom(5);
        list.travel();
    }
}
