package DSAAlgoritham.SinglyLinkedList;

public class EmployeeSinglyMain {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeSinglyLinkedList list = new EmployeeSinglyLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

    }

}

class EmployeeSinglyLinkedList {
    private EmployeeSinglyNode head;
    private int size;
    public void addToFront(Employee employee) {
        EmployeeSinglyNode node = new EmployeeSinglyNode(employee);
        node.setNextReference(head);
        head = node;
        size++;
    }

    public EmployeeSinglyNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        EmployeeSinglyNode removeNode = head;
        head = head.getNextReference();
        size--;
        removeNode.setNextReference(null);
        return removeNode;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeSinglyNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNextReference();
        }
        System.out.println("null");
    }
}

class EmployeeSinglyNode {

    private Employee data;
    private EmployeeSinglyNode nextReference;

    public EmployeeSinglyNode(Employee data) {
        this.data = data;
    }

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public EmployeeSinglyNode getNextReference() {
        return nextReference;
    }

    public void setNextReference(EmployeeSinglyNode nextReference) {
        this.nextReference = nextReference;
    }

    @Override
    public String toString() {
        return "EmployeeSinglyNode{" +
                "data=" + data +
                ", nextReference=" + nextReference +
                '}';
    }
}


