package DSAAlgoritham;

public class PersonDsa {
    String name;
    int age;

    PersonDsa(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
