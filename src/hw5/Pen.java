package hw5;

public abstract class Pen {
	private String brand;
	private int price=100;
	
	public Pen() {}
	
	public Pen(String brand,int price) {
		this.brand =brand;
		this.price =price;
	}
	
	public void setBrand(String brand) {
		this.brand=brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public abstract void write();
}
