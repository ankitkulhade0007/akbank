package DSAAlgoritham.SinglyLinkedList;

public class IntegerSinglyLinkedList {

    private IntegerSinglyNode head;
    private int size;


    public void insertSorted(int num){

        if(head == null || head.getData() >= num){
            addToFront(num);
            return;
        }// find the insertuon point
        IntegerSinglyNode current = head.getNext();
        IntegerSinglyNode previous = head;

        while(current != null && current.getData() < num){
           previous = current;
           current= current.getNext();
        }
    }

    public void addToFront(Integer num) {
        IntegerSinglyNode node = new IntegerSinglyNode(num);
        node.setNext(head);
        head = node;
        size++;
    }
}


class IntegerSinglyNode{

    private int data;
    private IntegerSinglyNode next;

    public IntegerSinglyNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public IntegerSinglyNode getNext() {
        return next;
    }

    public void setNext(IntegerSinglyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "IntegerSinglyNode{" +
                "data=" + data +
                '}';
    }
}