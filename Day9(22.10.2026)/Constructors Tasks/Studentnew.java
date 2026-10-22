package Constructors;

public class Studentnew {
	String name;

    Studentnew(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }

	public static void main(String[] args) {
		Studentnew s = new Studentnew("Kanishkar");
        s.display();

	}

}
