package Constructors;

public class Book {
	Book() {
        System.out.println("Default constructor");
    }
	Book(String title) {
        System.out.println("Title: " + title);
    }
	Book(String title, double price) {
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }

	public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java");
        Book b3 = new Book("Python", 500);
    }

}
