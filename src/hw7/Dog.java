package hw7;

import java.io.Serializable;

public class Dog extends Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Dog(String name) {
		super(name);
	}
	
	public void speak() {
		System.out.println("This is Dog " + getName() + " speaking.");
	}
}
