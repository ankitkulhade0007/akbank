package functionInterfacePractice;

public class FunctioNalMain {

    public static void main(String[] args) {
        Hello hello = ()-> System.out.println("Hello");
        process(hello);
        process(()-> System.out.println("Hello"));


        ArthematicOperationInterface sumOperation = (a, b)-> a+b;
        System.out.println(sumOperation(sumOperation));

        System.out.println(sumOperation.operation(10,20));

        ArthematicOperationInterface divideOperation = (a, b)-> a/b;
        System.out.println(divideOperation.operation(10, 5));

        ArthematicOperationInterface multiplyOperation = (a, b) -> a*b;
        System.out.println(multiplyOperation.operation(10, 20));
    }

    public static void process(Hello h){
        h.sayHello();
    }

    public  static int sumOperation(ArthematicOperationInterface sumOperation){
        return sumOperation.operation(1, 2);
    }


}
