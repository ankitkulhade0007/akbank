package DSAAlgoritham.EmployeeDoublyLinkedList;

import DSAAlgoritham.SinglyLinkedList.Employee;

public class EmployeeMainDoublyLinkedList {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        System.out.println("Currently List is Empty :- " + list.isEmpty());
        System.out.println();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        System.out.printf("After Adding into List size is :- %s %n", list.getSize());
        System.out.println();

        Employee ankit = new Employee("Ankit", "Kulhade", 3245);
        list.addToTail(ankit);
        System.out.printf("After Adding Ankit to Tail List size is :- %s %n", list.getSize());
        list.printList();
        System.out.println();

        list.removeFronFront();
        System.out.printf("After Removing from Front List size is :- %s %n", list.getSize());
        list.printList();
        System.out.println();

        list.addBefore(janeJones, ankit);
        System.out.printf("After add Ankit before JaneJones List size is :- %s %n", list.getSize());
        list.printList();
        System.out.println();


        list.addBefore(marySmith, new Employee("someone", "else", 7829));
        System.out.printf("Adding Someone Else at Head List size is :- %s %n", list.getSize());
        list.printList();
        System.out.println();


        list.removeFronTail();
        System.out.printf("After Removing from Tail List size is :- %s %n", list.getSize());
        list.printList();
        System.out.println();
    }
}

class EmployeeDoublyLinkedNode {

    private Employee employee;
    private EmployeeDoublyLinkedNode next;
    private EmployeeDoublyLinkedNode previous;

    EmployeeDoublyLinkedNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(EmployeeDoublyLinkedNode next) {
        this.next = next;
    }

    public EmployeeDoublyLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeDoublyLinkedNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "EmployeeDoublyLinkedNode{" +
                "employee=" + employee +
                '}';
    }
}

class EmployeeDoublyLinkedList {

    private EmployeeDoublyLinkedNode head;
    private EmployeeDoublyLinkedNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(employee);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        node.setNext(head);
        head = node;
        size++;
    }

    public void addToTail(Employee employee) {
        EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(employee);
        if (tail == null) {
            head = node;

        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        size++;
    }

    public void removeFronFront() {
        if (isEmpty()) {
            return;
        }
        EmployeeDoublyLinkedNode removeNode = head;
        if (getSize() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        removeNode.setNext(null);
        size--;
    }

    public void removeFronTail() {
        if (isEmpty()) {
            return;
        }
        EmployeeDoublyLinkedNode removeTailnode = tail;
        if (getSize() == 1) {
            head = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        removeTailnode.setPrevious(null);
        size--;
    }

    public void addBefore(Employee beforeEmployee, Employee newEmployee) {

        if (beforeEmployee != null && newEmployee != null && !isEmpty()) {
            EmployeeDoublyLinkedNode tempNode = head;
            while (head != null && !tempNode.getEmployee().equals(beforeEmployee)) {
                tempNode = tempNode.getNext();
            }
            if (tempNode != null) {
                EmployeeDoublyLinkedNode node = new EmployeeDoublyLinkedNode(newEmployee);
                node.setPrevious(tempNode.getPrevious());
                node.setNext(tempNode);
                tempNode.setPrevious(node);
                if (head == tempNode) {
                    head = node;
                } else {
                    node.getPrevious().setNext(node);
                }
                size++;
            }
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeDoublyLinkedNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <==> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
