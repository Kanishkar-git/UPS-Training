package Constructors;

public class Calculator {
	
    Calculator getObject() {
        return this;
    }

    void display() {
        System.out.println("Calculator method called");
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.getObject().display();
    }
}