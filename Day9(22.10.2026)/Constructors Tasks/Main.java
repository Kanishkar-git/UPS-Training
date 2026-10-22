package Constructors;

class A {
    A() {
        System.out.println("A");
    }
}

class Main extends A {

    Main() {
        this(10);
        System.out.println("B default");
    }

    Main(int x) {
        super();
        System.out.println("B parameterized");
    }
}

public class Main {
    public static void main(String[] args) {
        new Main();
    }
}