package functionInterfacePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnnonyoumsClassDemo {


    public static void main(String[] args) {

        Hello hello = new Hello() {
            @Override
            public void sayHello() {
              System.out.println("Hello Annonyoums Class");
            }
        };

        process(hello);
    }

    public  static  void process(Hello h){
        h.sayHello();
    }

    public static List<Person> filterByAge(int age) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 28, "New York"));
        persons.add(new Person("Jane", 22, "Los Angeles"));
        persons.add(new Person("Jack", 30, "New York"));
        persons.add(new Person("Jill", 24, "Chicago"));
        // Write your code below

        return persons.stream().filter(person-> person.getAge() > age).collect(Collectors.toList());
    }
}
