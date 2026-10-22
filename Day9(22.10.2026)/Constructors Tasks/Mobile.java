package Constructors;

public class Mobile {
	String brand;
    int price;
    
    Mobile() {
        this("Samsung", 15000);
    }
    
    Mobile(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }
    
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
    
	public static void main(String[] args) {
		 Mobile m = new Mobile();
	     m.display();

	}

}
