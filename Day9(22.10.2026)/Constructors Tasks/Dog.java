package Constructors;

class Animal {	
    Animal() {
        System.out.println("Animal constructor");
    }
}

public class Dog extends Animal {

    Dog() {
        super();
        System.out.println("Dog constructor");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
    }
}