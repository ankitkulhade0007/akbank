package DSAAlgoritham.SinglyLinkedList;

import java.util.Objects;

public class Employee {
    private String fname;
    private  String lName;

    private int number;

    public Employee(String fname, String lName, int number) {
        this.fname = fname;
        this.lName = lName;
        this.number = number;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return number == employee.number && Objects.equals(fname, employee.fname) && Objects.equals(lName, employee.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lName, number);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", lName='" + lName + '\'' +
                ", number=" + number +
                '}';
    }
}
