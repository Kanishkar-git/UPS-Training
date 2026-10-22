package Constructors;

class Parent {
    Parent(int x) {
        System.out.println(x);
    }
}

class Child extends Parent {
    Child() {
        super(10);
        System.out.println("Child");
    }

    public static void main(String[] args) {
        Child c = new Child();
    }
}